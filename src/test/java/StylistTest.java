import org.junit.*;
import static org.junit.Assert.*;

public class StylistTest {

  @Test
  public void stylist_instantiatesCorrectly_true() {
    Stylist testStylist = new Stylist("Xena");
    assertEquals(true, testStylist instanceof Stylist);
  }
}
