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
      model.put("stylist", request.session().attribute("stylist"));
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    //sends new stylists data to db
    post("/stylists", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();

      ArrayList<Stylist> stylists = request.session().attribute("stylists");
      if (stylists == null) {
        stylists = new ArrayList<Stylist>();
        request.session().attribute("stylists", stylists);
      }
      String name = request.queryParams("name");
      Stylist newStylist = new Stylist(name);
      stylists.add(newStylist);
      model.put("template", "templates/success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
