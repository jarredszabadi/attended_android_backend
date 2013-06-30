package UsersAPIv2;

import org.json.JSONException;
import org.json.JSONObject;


public class UserJsonThread extends Thread{

	private String auth_token;
	private String requestURL;
	private sendReceiveJSON srJSON;
	private JSONObject obj;
	int method;
	
	
	public UserJsonThread(String auth_token) {
		// TODO Auto-generated constructor stub

		this.auth_token = auth_token;
		srJSON = new sendReceiveJSON();
	}
	
	/*
	 * CONSTRUCTOR 2
	 */
	public UserJsonThread(String auth_token, JSONObject obj) {
		// TODO Auto-generated constructor stub

		this.auth_token = auth_token;
		this.obj = obj;
		srJSON = new sendReceiveJSON();
	}
	
	/*
	 * CONSTRUCTOR 3
	 */
	public UserJsonThread(String email, String password, String password_confirmation, String auth_token){
		obj = new JSONObject();
		srJSON = new sendReceiveJSON();
		JSONObject user = new JSONObject();
		this.auth_token=auth_token;
		try {

			user.put("email", email);
			user.put("password", password);
			user.put("password_confirmation", password_confirmation);
			//user.put("username", username);
			//user.put("auth_token", auth_token);
			obj.put("User", user);

			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	public void setRequestURL(String requestURL){
		this.requestURL = requestURL;
	}
	
	public void setMethod(int method){
		this.method = method;
	}
	
	public void run() {
			// TODO Auto-generated method stub


				

				String returnString = new String();
				
				switch(method){
				/*
				 * CREATE
				 */
				case 1: 
									
							System.out.println("Sending: " + obj.toString() + "to "+ requestURL);
							returnString = srJSON.createUser(requestURL, obj,auth_token);
						
							System.out.println("Message from " + requestURL + ": "+ returnString + "\n");
				break;
				case 2: 
					
					System.out.println("Getting User At: "+ requestURL);
					returnString = srJSON.getSingleUser(requestURL, auth_token);
				
					System.out.println("Message from " + requestURL + ": "+ returnString + "\n");
				break;
				case 3: 
					
					System.out.println("Getting All Users: "+ requestURL);
					returnString = srJSON.getAllUsers(auth_token, requestURL);
				
					System.out.println("Message from " + requestURL + ": "+ returnString + "\n");
				break;
				
				case 4: 
					
					System.out.println("Deleting User At: "+ requestURL);
					returnString = srJSON.deleteUser(auth_token, requestURL);
				
					System.out.println("Message from " + requestURL + ": "+ returnString + "\n");
				break;
				
				case 5: 
					
					System.out.println("Editting User At: "+ requestURL);
					returnString = srJSON.editUser(auth_token, requestURL, obj);
				
					System.out.println("Message from " + requestURL + ": "+ returnString + "\n");
				break;
				}
	}
	

}
