package ReverseFollowing_RelationshipsAPIv2;

import org.json.JSONException;
import org.json.JSONObject;




public class Reversefollowing_RelationshipsThread extends Thread{

	private String auth_token;
	private String requestURL;
	private sendReceiveJSON srJSON;
	private JSONObject obj;
	int method;
	//1 = create
	
	public Reversefollowing_RelationshipsThread(String auth_token) {
		// TODO Auto-generated constructor stub

		this.auth_token = auth_token;
		srJSON = new sendReceiveJSON();
	}
	
	/*
	 * CONSTRUCTOR 2
	 */
	public Reversefollowing_RelationshipsThread(String auth_token, JSONObject obj) {
		// TODO Auto-generated constructor stub

		this.auth_token = auth_token;
		this.obj = obj;
		srJSON = new sendReceiveJSON();
	}
	
	/*
	 * CONSTRUCOTR 3
	 */
	public Reversefollowing_RelationshipsThread(String auth_token,String user_ID){
		// TODO Auto-generated constructor stub
		srJSON = new sendReceiveJSON();
		//JSONObject user = new JSONObject();
		

		this.auth_token = auth_token;
		try {
			this.obj = new JSONObject();
			obj.put("id", user_ID);
			//obj.put("User", user);
			
		
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
	
	public void run(){
		String returnString = new String();
		
		switch(method){
		
		case 1:
			System.out.println("Attempting to find the relationship at: " +requestURL);
			returnString = srJSON.showRelationship(requestURL,auth_token);
			System.out.println("Message from " + requestURL + ": "+ returnString + "\n");
		break;
		case 2:
			System.out.println("Attempting to get all people i've followed:");
			returnString = srJSON.getAllRelationships(requestURL, auth_token);
			System.out.println("Message from " + requestURL + ": "+ returnString + "\n");
		break;
		}
		
	}

}
