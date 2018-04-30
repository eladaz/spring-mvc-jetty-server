package com.gett.automation.server;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * @author eladaz (eladaz@gett.com)
 * Created on 29/04/2018.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.setConfigLocation("com.gett.automation.server.config");

        ServletContextHandler contextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        contextHandler.setErrorHandler(null);
        contextHandler.addServlet(new ServletHolder(new DispatcherServlet(context)), "/");

        Server server = new Server(8090);
        server.setHandler(contextHandler);
        server.start();
        server.join();
    }

}
