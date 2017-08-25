import java.util.ArrayList;
import org.sql2o.*;


public class Client {
  private String name;
  private String description;

  public Client(String name) {
    this.name = name;
    this.description = description;
  }


//get the name of the stylist
  public String getName() {
    return name;
  }

//return name of stylist as a String
  public String getDesciption() {
    return description;
  }
}
