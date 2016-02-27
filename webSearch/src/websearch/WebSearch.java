/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package websearch;


import java.net.*;
import java.io.*;
/**
 *
 * @author Summer
 */
public class WebSearch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        URL google = new URL("http://www.google.com/search ");
        URLConnection yc = google.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                                    yc.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) 
            System.out.println(inputLine);
        in.close();
    }
    
    
}
