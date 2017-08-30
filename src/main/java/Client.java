import java.util.ArrayList;
import java.util.List;
import org.sql2o.*;

public class Client {
  private String name;
  private String description;
  private static ArrayList<Client> instances = new ArrayList<Client>();
  private int id;
  private int stylistId;

  public Client(String name, int stylistId) {
    this.name = name;
    this.stylistId = stylistId;
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

//SQL command to retrieve info from DB
  public static List<Client> all() {
    String sql = "SELECT Id, name from clients";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Client.class);
    }
  }

//find method using client id
  public static Client find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM clients where id=:id";
      Client client = con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(Client.class);
      return client;
    }
  }

//method to overide equals method
  @Override
  public boolean equals(Object otherClient) {
    if (!(otherClient instanceof Client)) {
      return false;
    } else {
      newClient = (Client) otherClient;
      return this.getName().equals(newClient.getName()) &&
              this.getId() == newClient.getId();
    }
  }

//save method for new new objects after Overide
  public void save() {
  try(Connection con = DB.sql2o.open()) {
    String sql = "INSERT INTO clients (name) VALUES (:name)";
    this.id = (int) con.createQuery(sql, true)
      .addParameter("name", this.name)
      .executeUpdate()
      .getKey();
    }
  }



}
