import org.junit.*;
import static org.junit.Assert.*;

public class StylistTest {

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

}
