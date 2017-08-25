import java.util.ArrayList;
import java.util.List;


public class Client {
  private String mName;
  private String mDescription;
  private static ArrayList<Client> instances = new ArrayList<Client>();
  private int mId;

  public Client(String name) {
    mName = name;
    //mDescription = description;
    instances.add(this);
    mId = instances.size();

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
