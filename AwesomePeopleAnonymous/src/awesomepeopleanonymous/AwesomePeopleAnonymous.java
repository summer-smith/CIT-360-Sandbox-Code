package awesomepeopleanonymous;

import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
/**
 *
 * @author Summer
 */
public class AwesomePeopleAnonymous {
    @SuppressWarnings("unchecked")
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       		//Create a JSON object
 		JSONObject user1 = new JSONObject();
 		
 		//Add data to the object
 		user1.put("Name", "Summer Smith");
 		user1.put("Username", "silversmith08");
 		user1.put("Password", "funkymonkey");
 		
 		//Rinse and repeat
 		JSONObject user2 = new JSONObject();
 		user2.put("Name", "Harry Potter");
 		user2.put("Username", "thechosen0ne");
 		user2.put("Password", "expectoPatronum"); 		

 		JSONObject user3 = new JSONObject();
 		user3.put("Name", "Kylo Ren");
 		user3.put("Username", "almostVader");
 		user3.put("Password", "iHateHanSolo"); 	 		
 		
 		//Create a simple JSON array
 		JSONArray animals = new JSONArray();
 		
 		//Add objects to the array
 		animals.add("Animal: cat");
 		animals.add("Animal: dog");
 	
 	 	//Create another JSON object...
 		JSONObject awesomePeopleAnon = new JSONObject();
 		awesomePeopleAnon.put("Web URL", "awesomePeopleAnonymous.org");
 		awesomePeopleAnon.put("Owner", "The Doctor");
 	
 		//Create an array of objects
 		JSONArray users = new JSONArray();
 		users.add(user1);
 		users.add(user2);
 		users.add(user3);
 		
 		//Add the array to an existing object
 		awesomePeopleAnon.put("Users List", users);
 
		//write to file and output to terminal
		try (FileWriter file = new FileWriter("/Users/Summer/eclipse/fileWrites/funWithJSON.txt")) {
			file.write(awesomePeopleAnon.toJSONString());
			System.out.println("Successfully Copied JSON Object to File...");
			System.out.println("\nJSON Object: " + awesomePeopleAnon);
		}catch (Exception E){
                    System.out.println("ERROR writing to file");
                    System.out.println("+++++++++++++++++++++++++++++");
                    System.out.println(E);
                    System.out.println("+++++++++++++++++++++++++++++");
                }
	}
}