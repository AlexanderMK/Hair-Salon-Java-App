import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;

public class StylistTest {

//bloack annotatin for sql
  @Before
      public void setUp() {
        DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/hair_salon_test", "alexander", "1234");
      }


//check if tests will instantiate corretcly
  @Test
  public void stylist_instantiatesCorrectly_true() {
    Stylist testStylist = new Stylist("Xena");
    assertEquals(true, testStylist instanceof Stylist);
  }

//test if Stylist objects will get name property
  @Test
  public void getName_stylistInstantiatesWithName_Xena() {
    Category testCategory = new Category("Xena");
    assertEquals("Xena", testCategory.getName());
  }

//testing listing of all Stylist objects
  @Test
  public void all_returnsAllInstancesOfStylist_true() {
    Stylist firstStylist = new Stylist("Xena");
    firstStylist.save();
    Stylist secondStylist = new Stylist("Rose");
    secondStylist.save();
    assertEquals(true, Stylist.all().get(0).equals(firstStylist));
    assertEquals(true, Stylist.all().get(1).equals(secondStylist));
  }

//clearing all instances
  @Test
  public void clear_emptiesAllStylistFromList_0() {
    Stylist testStylist = new Stylist("Xena");
    Stylist.clear();
    assertEquals(Stylist.all().size(), 0);
  }

//get id attributes of all stylists
  @Test
  public void getId_stylistsInstantiateWithAnId_1() {
    Stylist testStylist = new Stylist("Xena");
    testStylist.save();
    assertEquals(testStylist.getId() > 0);
  }

//locate a stylist using a unique id from our DB
  @Test
  public void find_returnsStylistWithSameId_secondStylist() {
    Stylist firstStylist = new Stylist("Xena");
    firstStylist.save();
    Stylist secondStylist = new Stylist("Rose");
    secondStylist.save();
    assertEquals(Stylist.find(secondStylist.getId()), secondStylist);
  }

//instantiating a client object inside a stylist object
  @Test
  public void getClients_initiallyReturnsEmptyList_ArrayList() {
    Stylist.clear();
    Stylist testStylist = new Stylist("Xena");
    assertEquals(0, testStylist.getStylist().size());
  }

//Adding cleints to Stylist
  @Test
  public void addClient_addsClientToList_true() {
    Stylist testStylist = new Stylist("Xena");
    Client testClient = new Client("Jane");
    testStylist.addStylist(testClient);
    assertTrue(testStylist.getClients().contains(testClient));
  }

//comparing Stylist objects
  @Test
  public void equals_returnsTrueIfNamesAretheSame() {
    Stylist firstStylist = new Stylist("Ann");
    Stylist secondStylist = new Stylist("Ann");
    assertTrue(firstStylist.equals(secondStylist));
  }

//test to save new Stylist objects
  @Test
  public void save_savesIntoDatabase_true() {
    Stylist myStylist = new Stylist("Ann");
    myStylist.save();
    assertTrue(Stylist.all().get(0).equals(myStylist));
  }

//assigning unique id of stylist in DB
  @Test
  public void save_assignsIdToObject() {
    Stylist myStylist = new Stylist("Ann");
    myStylist.save();
    Stylist savedStylist = Stylist.all().get(0);
    assertEquals(myStylist.getId(), savedStylist.getId());
  }

//test to save stylistId into clients table
  @Test
  public void save_savesStylistIdIntoDB_true() {
    Stylist myStylist = new Stylist("Rose");
    myStylist.save();
    Client myClient = new Client("Ann", myStylist.getId());
    myClient.save();
    Client savedClient = Client.find(myClient.getId());
    assertEquals(savedClient.getStylistId(), myStylist.getId());
  }

//test to retrieve all clients saved in a specific stylistId
  @Test
  public void getClients_retrievesALlClientsFromDatabase_clientsList() {
    Stylist myStylist = new Stylist("Ann");
    myStylist.save();
    Client firstClient = new Client("Rose", myStylist.getId());
    firstClient.save();
    Client secondClient = new Client("Mary", myStylist.getId());
    secondClient.save();
    Client[] clients = new Client[] { firstClient, secondClient };
    assertTrue(myStylist.getClients().containsAll(Arrays.asList(clients)));
  }

//clears the test database
  @After
    public void tearDown() {
      try(Connection con = DB.sql2o.open()) {
        String deleteClientsQuery = "DELETE FROM clients *;";
        String deleteStylistsQuery = "DELETE FROM stylists *;";
        con.createQuery(deleteClientsQuery).executeUpdate();
        con.createQuery(deleteStylistsQuery).executeUpdate();
      }
    }

}
