import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

import java.util.ArrayList;

public class App {
  public static void main(String[] args) {

    //logic for Heroku to assign different ports
    ProcessBuilder process = new ProcessBuilder();
     Integer port;
     if (process.environment().get("PORT") != null) {
         port = Integer.parseInt(process.environment().get("PORT"));
     } else {
         port = 4567;
     }

    setPort(port);

    //layout route
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    //route to our homepage
    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("clients", request.session().attribute("clients"));
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    //route to create new clients
    get("clients/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/client-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    //route to show all clients
    get("/clients", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("clients", Client.all());
      model.put("template", "templates/tasks.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    //sends new stylists data to db
    post("/clients", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();

      ArrayList<Client> clients = request.session().attribute("clients");
      if (clients == null) {
        clients = new ArrayList<Client>();
        request.session().attribute("clients", clients);
      }
      String name = request.queryParams("name");
      //String description = request.queryParams("description");
      Client newClient = new Client(name);
      clients.add(newClient);
      model.put("template", "templates/success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
