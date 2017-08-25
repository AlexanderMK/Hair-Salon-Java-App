import java.util.List;
import java.util.ArrayList;

public class Stylist {
  private String mName;
  private static List<Stylist> instances = new ArrayList<Stylist>();

  //logic for initial instantiation
  public Stylist(String name) {
    mName = name;
    instances.add(this);
  }

  //give a stylist a name
  public String getName() {
    return mName;
  }

  //returns all instances of a stylist
  public static List<Stylist> all() {
    return instances;
  }

  //clear all instances of a stylist
  public static void clear() {
    instances.clear();
  }
}
