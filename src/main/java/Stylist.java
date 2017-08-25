import java.util.List;
import java.util.ArrayList;

public class Stylist {
  private String mName;
  private static List<Stylist> instances = new ArrayList<Stylist>();
  private int mId;
  private List<Client> mClient;

  //logic for initial instantiation
  public Stylist(String name) {
    mName = name;
    instances.add(this);
    mId = instances.size();
    mClient = new ArrayList<Client>();
  }

  //give a stylist a name
  public String getName() {
    return mName;instantiating a client object inside a stylist object
  }

  //returns all instances of a stylist
  public static List<Stylist> all() {
    return instances;
  }

  //clear all instances of a stylist
  public static void clear() {
    instances.clear();
  }

  //getting id for a stylist
  public int getId() {
    return mId;
  }

  //locating a stylist using id
  public static Stylist find(int id) {
    return instances.get(id - 1);
  }

  //listing clients under stylists
  public List<Client> getClients() {
    return mClient;
  }

  //adding a client to a stylists
  public void addClient(Client client) {
    mClient.add(clients)
  }
}
