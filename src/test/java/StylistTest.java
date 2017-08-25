import org.junit.*;
import static org.junit.Assert.*;

public class StylistTest {


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
}
