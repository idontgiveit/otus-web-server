package org.example;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.example.handlers.HelloWorldServlet;
import org.example.handlers.auth.TokenService;
import org.example.handlers.auth.TokenServlet;
import org.example.handlers.data.Multiply;


public class Main {
    public static void main(String[] args) throws Exception {
        Server server = new Server(9090);
        ServletContextHandler context = new ServletContextHandler(server, "/");
        context.addServlet(HelloWorldServlet.class, "/hello");
        context.addServlet(Multiply.class, "/mutiply");
        context.addServlet(TokenServlet.class, "/auth");
        server.start();
    }
}