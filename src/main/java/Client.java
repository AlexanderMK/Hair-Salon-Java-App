import java.util.ArrayList;
import java.util.List;
import org.sql2o.*;

public class Client {
  private String name;
  private String description;
  private static ArrayList<Client> instances = new ArrayList<Client>();
  private int id;

  public Client(String name) {
    this.name = name;
    //mDescription = description;

    //mId = instances.size();

  }


//get the name of the stylist
  public String getName() {
    return name;
  }

//return name of stylist as a String
  public String getDesciption() {
    return description;
  }

//return unique id for client
  public int getId() {
    return id;
  }

//Lists all clients
  //public static void clear() {
    //instances.clear();
  //}

  public static List<Client> all() {
    String sql = "SELECT Id, name from clients";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Client.class);
    }
  }

  //public static Client find(int id) {
  //return instances.get(id - 1);
  //}
}
