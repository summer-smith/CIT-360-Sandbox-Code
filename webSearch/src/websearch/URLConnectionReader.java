package websearch;
import java.net.*;
import java.io.*;
/**
 *
 * @author Summer
 */
public class URLConnectionReader {
        public static void read() throws Exception {
        URL oracle = new URL("http://www.google.com/");
        URLConnection yc = oracle.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                                    yc.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) 
            System.out.println(inputLine);
        in.close();
    }
        
    public static void write(String reverseServlet, String reverseString) throws Exception {

        String stringToReverse = URLEncoder.encode(reverseString, "UTF-8");

        URL url = new URL(reverseServlet);
        URLConnection connection = url.openConnection();
        connection.setDoOutput(true);

        OutputStreamWriter out = new OutputStreamWriter(
                                         connection.getOutputStream());
        out.write("string=" + stringToReverse);
        out.close();

        BufferedReader in = new BufferedReader(
                                    new InputStreamReader(
                                    connection.getInputStream()));
        String decodedString;
        while ((decodedString = in.readLine()) != null) {
            System.out.println(decodedString);
        }
        in.close();
    }        
}
