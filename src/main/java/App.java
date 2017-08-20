/*
 * This Java source file was generated by the Gradle 'init' task.
 */
import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
public static void main(String[] args) {
        staticFileLocation("/public");
        String layout = "templates/layout.vtl";

        //the home page route to show welcome message
        get("/", (request,response) ->{
                    Map<String,Object> model=new HashMap<String,Object>();
                    //add the template to the HashMap under the key template
                    model.put("template", "templates/index.vtl");
                    //ensure the layout.vtl and index.vtl communicate
                    return new ModelAndView(model,layout);
            },new VelocityTemplateEngine());
        //the route that will contain the template to fill the form
        get("heroes/new", (request,response) ->{
                    Map<String, Object> model = new HashMap<String, Object>();
                    //template with the form
                    model.put("template", "templates/hero-form.vtl");
                    return new ModelAndView(model,layout);
            },new VelocityTemplateEngine());

        //the route that will contain the list of heroes
        get("/heroes", (request,response) ->{
                    Map<String, Object> model = new HashMap<String, Object>();
                    //Hero.all() will add the Arraylist containing the Heroes in Hero.java
                    //Making it available under the key "heroes" for looping
                    model.put("heroes", Hero.all());
                    model.put("template", "templates/heroes.vtl");
                    return new ModelAndView(model,layout);
            },new VelocityTemplateEngine());


        post("/heroes",(request,response) -> {
                     Map<String, Object> model = new HashMap<String, Object>();
                     //getting inputs from the form
                     String name=request.queryParams("name");
                     String power=request.queryParams("power");
                     String weakness=request.queryParams("weakness");
                     String image=request.queryParams("image");
                     //creating instance of hero class
                     Hero myHero=new Hero(name,power,weakness,image);

                     model.put("template", "templates/success.vtl");
                     return new ModelAndView(model,layout);

             },new VelocityTemplateEngine());


        get("/heroes/:id", (request,response) ->{
                    Map<String, Object> model = new HashMap<String, Object>();
                    //below code fetches data from the link saved in :id
                    Hero myHero = Hero.find(Integer.parseInt(request.params(":id")));
                    //the data of the link is then saved under myHero
                    model.put("myHero", myHero);
                    //the template is rendered
                    model.put("template", "templates/hero.vtl");
                    return new ModelAndView(model,layout);
            },new VelocityTemplateEngine());
        //the route to display the squad form
        get("/squads/new", (request,response) ->{
                    Map<String, Object> model = new HashMap<String, Object>();
                    model.put("template", "templates/squad-form.vtl");
                    return new ModelAndView(model,layout);
            },new VelocityTemplateEngine());
        //the route that will process the squad form input and display the success template
        post("/squads", (request,response) -> {
                     Map<String, Object> model = new HashMap<String, Object>();
                     //processing the squad form and saving in title
                     String title =request.queryParams("title");
                     //create new squad and pass in the title to new squad because of the constructor
                     Squad mySquad=new Squad(title);
                     model.put("template", "templates/squad-success.vtl");
                     return new ModelAndView(model,layout);
             },new VelocityTemplateEngine());

        //this route will be responsible for displaying all squads created
        get("/squads", (request,response) ->{
                    Map<String, Object> model = new HashMap<String, Object>();
                    //Squad.all() gets the list of all squads created and puts it in the HashMap under model
                    model.put("squads", Squad.all());
                    model.put("template", "templates/squads.vtl");
                    return new ModelAndView(model,layout);
            },new VelocityTemplateEngine());

          //this will display details about a specific squad
        get("/squads/:id", (request,response) ->{
                    Map<String, Object> model = new HashMap<String, Object>();
                    //the variable squad below stores the object with the corresponding id
                    //the id is retrieived from the url when the link is clicked
                    Squad squad = Squad.find(Integer.parseInt(request.params(":id")));
                    //the squad object is put inside model under the key "squad"
                    model.put("squad",squad);
                    model.put("template", "templates/squad.vtl");
                    return new ModelAndView(model,layout);
            },new VelocityTemplateEngine());
}
}