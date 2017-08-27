import java.util.List;
import java.util.ArrayList;
import org.sql2o.*;

public class Stylist {
  private String name;
  private int id;
  //private List<Client> mClients;

  //logic for initial instantiation
  public Stylist(String name) {
    this.name = name;
    //instances.add(this);
    //mId = instances.size();
    //mClients = new ArrayList<Client>();
  }

  //give a stylist a name
  public String getName() {
    return name;
  }

  //returns all instances of a stylist
  public static List<Stylist> all() {
    //return instances;
  }

  //clear all instances of a stylist
  //public static void clear() {
    //instances.clear();
  //}

  //getting id for a stylist
  public int getId() {
    return id;
  }

  //locating a stylist using id
  public static Stylist find(int id) {
    return instances.get(id - 1);
  }

  //listing clients under stylists
  public List<Client> getClients() {
    return mClients;
  }

  //adding a client to a stylists
  public void addClient(Client client) {
    mClients.add(client);
  }

  //method to return all stylists
  public static List<Stylist> all() {
    String sql = "SELECT id, name FROM stylists";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Stylist.class);
    }
  }
}
