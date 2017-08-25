import org.junit.*;
import static org.junit.Assert.*;

public class StylistTest {

    //connects ro test database
    @Before
    public void setUp() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/hair_salon_test", "alexander", "1234");
    }

    //check if tests instatiates correctly
    @Test
    public void stylist_instantiatesCorrectly_true() {
      assertTrue(stylist instanceof Stylist);
    }

    //check if name of stylist returns as a string
    @Test
    public void getName_returnsNameOfStylist_String() {
    assertEquals("Xena", stylist.getName());
    }

    //check if description of stylist returns as a String
    @Test
    public void getDescription_returnsDescriptionOfStylist_String() {
    assertEquals("Straightforward, elegant style", stylist.getDescription());
    }

}
