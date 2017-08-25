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
    public void getId_categoriesInstantiateWithAnId_1() {
    Category testCategory = new Category("Home");
    testCategory.save();
    assertTrue(testCategory.getId() > 0);
    }

    //clears the test database
    @After
    public void tearDown() {
      try(Connection con = DB.sql2o.open()) {
        String sql = "DELETE FROM client *;";
     con.createQuery(sql).executeUpdate();
      }
    }
}
