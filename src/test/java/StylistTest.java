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

//testing listing of all Stylist objects
  @Test
  public void all_returnsAllInstancesOfStylist_true() {
    Stylist firstStylist = new Stylist("Xena");
    Stylist secondStylist = new Stylist("Rose");
    assertEquals(true, Stylist.all().contains(firstStylist));
    assertEquals(true, Stylist.all().contains(secondStylist));
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
    assertEquals(1, testStylist.getId());
  }

//locate a stylist using a unique id
  @Test
  public void find_returnsStylistWithSameId_secondStylist() {
    Stylist.clear();
    Stylist firstStylist = new Stylist("Xena");
    Category secondStylist = new Stylist("Rose");
    assertEquals(Stylist.find(secondStylist.getId()), secondStylist);
  }
}
