import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class ClientTest {

    //connects ro test database
    @Before
    public void setUp() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/hair_salon_test", "alexander", "1234");
    }

    //check if tests instatiates correctly
    @Test
    public void Client_instantiatesCorrectly_true() {
      Stylist testClient = new Client("Xena");
      assertEquals(true, testStylist instanceof Client);
    }

    //check if name of stylist returns as a string
    @Test
    public void getName_returnsNameOfClient_String() {
     Stylist testClient = new Client("Xena");
    assertEquals("Xena", testClient.getName());
    }

    //check if description of stylist returns as a String
    @Test
    public void getDescription_returnsDescriptionOfClient_String() {
    assertEquals("Straightforward, elegant style", stylist.getDescription());
    }

    //check if if properties returned are similar
    @Test
    public void equals_returnsTrueIfPropertiesAreTheSame_true() {
    Client secondClient = new Client("Xena", "Straightforward, elegant style");
    assertTrue(client.equals(secondClient));
    }

    //assigning unique id to a client
    @Test
    public void getId_clientsInstantiateWithAnID() {
    Client testClient = new Client("Xena");
    myClient.save();
    assertTrue(myClient.getId() > 0);
    }

    //test to compare objects retrieved from DB
    @Test
    public void equals_returnsTrueIfNamesAretheSame() {
    Client firstClient = new Client("Xena");
    Client secondClient = new Client("Jane");
    assertTrue(firstClient.equals(secondClient));
    }


    //test to save new objects in the DB
    @Test
    public void save_returnsTrueIfNamesAretheSame() {
    Client myClient = new Client("Xena");
    myClient.save();
    assertTrue(Client.all().get(0).equals(myClient));
    }

    //test to assign unique ids
    @Test
    public void save_assignsIdToObject() {
    Client myClient = new Client("Xena");
    myClient.save();
    Client savedClient = Client.all().get(0);
    assertEquals(myClient.getId(), savedClient.getId());
    }

    //test to find clients by ID
    @Test
    public void find_returnsClientWithSameId_secondTask() {
    Client firstClient = new Client("Xena");
    firstClient.save();
    Client secondClient = new Client("Jane");
    secondClient.save();
    assertEquals(Client.find(secondClient.getId()), secondClient);
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
