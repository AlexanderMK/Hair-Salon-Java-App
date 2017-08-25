import java.util.List;
import java.util.ArrayList;

public class Stylist {
  private String name;
  private static List<Stylist> instances = new ArrayList<Stylist>();

  //logic for initial instantiation
  public Stylist(String name) {
    mName = name;
  }

  //give a stylist a name
  public String getName() {
    return mName;
  }
}
