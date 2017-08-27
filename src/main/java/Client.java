import java.util.ArrayList;
import java.util.List;


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
    return mName;
  }

//return name of stylist as a String
  public String getDesciption() {
    return mDescription;
  }

//return unique id for client
  public int getId() {
    return mId;
  }

//Lists all clients
  public static void clear() {
    instances.clear();
  }

  public static List<Client> all() {
    return instances;
  }
  public static Client find(int id) {
  return instances.get(id - 1);
}
}
