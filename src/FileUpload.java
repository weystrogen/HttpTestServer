import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;

import java.io.*;
import java.util.List;

public class FileUpload extends FormDataHandler{
    @Override
    public void handle(HttpExchange httpExchange, List<MultiPart> parts) throws IOException {
        final String ROOT_PATH = "C:\\Users\\lsmn0\\Documents\\LSM\\TestServer";
        String resource = httpExchange.getRequestURI().toString();
        System.out.println(parts.size());

        httpExchange.sendResponseHeaders(200, 0);

        for (int i = 0; i < parts.size(); i++) {
            // Multipart/form-data 저장
            System.out.println("FormData");
            System.out.println("Name: " +parts.get(i).name);
            System.out.println("Content-Type:" + parts.get(i).contentType);
            System.out.println("File name: " + parts.get(i).filename);
            System.out.println("Value: " + parts.get(i).value);
            System.out.println("Type: " + parts.get(i).type);
            System.out.println("Data length: " + parts.get(i).bytes.length);
            System.out.println(new String(parts.get(i).bytes));

            try {
                FileOutputStream fos = new FileOutputStream(new File(ROOT_PATH + resource + File.separator + parts.get(i).filename));
                fos.write(parts.get(i).bytes);
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}