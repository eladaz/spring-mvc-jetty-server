Spring MVC Jetty Example
Add to pom.xml
<dependencies>
   <dependency>
       <groupId>org.springframework</groupId>
       <artifactId>spring-webmvc</artifactId>
       <version>4.3.10.RELEASE</version>
   </dependency>
   <dependency>
       <groupId>org.eclipse.jetty</groupId>
       <artifactId>jetty-server</artifactId>
       <version>9.4.6.v20170531</version>
    </dependency>
    <dependency>
        <groupId>org.eclipse.jetty</groupId>
        <artifactId>jetty-servlet</artifactId>
        <version>9.4.6.v20170531</version>
     </dependency>
     <dependency>
        <groupId>org.eclipse.jetty</groupId>
        <artifactId>jetty-webapp</artifactId>
        <version>9.4.6.v20170531</version>
     </dependency>
</dependencies>
Build config
@EnableWebMvc
@Configuration
@ComponentScan({"com.pethoalpar.ctrl"})
public class Config {
}
Add controller
@Controller
public class WebController {

    @RequestMapping(path = "/get/{name}", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String hello(@PathVariable("name") String name){
        return "Hello "+name;
    }

    @RequestMapping(path = "/test", method = {RequestMethod.GET})
    @ResponseBody
    public String test(){
        return "Success";
    }
}
Main.java
public class Main {

    public static void main(String [] args) throws Exception {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.setConfigLocation("com.pethoalpar.config");

        ServletContextHandler contextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        contextHandler.setErrorHandler(null);
        contextHandler.addServlet(new ServletHolder(new DispatcherServlet(context)),"/");

        Server server = new Server(8080);
        server.setHandler(contextHandler);
        server.start();
        server.join();
    }
}