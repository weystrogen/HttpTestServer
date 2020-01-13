import com.sun.net.httpserver.*;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.URI;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class TestServer {
    public static void main(String[] args) throws IOException {
        final int port = 80;

        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        System.out.println("Server started at port: " + port);
        HttpContext context = server.createContext("/", new FileUpload());
        server.start();
    }
}


