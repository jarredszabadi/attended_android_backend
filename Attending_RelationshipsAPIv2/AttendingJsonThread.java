package Attending_RelationshipsAPIv2;

import org.json.JSONException;
import org.json.JSONObject;



public class AttendingJsonThread extends Thread{


	
	
	private String auth_token;
	private String requestURL;
	private sendReceiveJSON srJSON;
	private JSONObject obj;
	int method;
	//1 = create
	
	
	public AttendingJsonThread(String auth_token) {
		// TODO Auto-generated constructor stub

		this.auth_token = auth_token;
		srJSON = new sendReceiveJSON();
	}
	
	/*
	 * CONSTRUCTOR 2
	 */
	public AttendingJsonThread(String auth_token, JSONObject obj) {
		// TODO Auto-generated constructor stub

		this.auth_token = auth_token;
		this.obj = obj;
		srJSON = new sendReceiveJSON();
	}
	/*
	 * CONSTRUCOTR 3
	 */
	public AttendingJsonThread(String auth_token, String event_id){
		srJSON = new sendReceiveJSON();
		this.auth_token = auth_token;

		this.auth_token = auth_token;
		try {
			this.obj = new JSONObject();
			obj.put("id", event_id);
			
			
		
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
			System.out.println("Following event at: "+requestURL+"/"+obj.toString());
			returnString = srJSON.createAttend(requestURL, obj, auth_token);
			System.out.println("Response from url: "+returnString);
		break;
		
		case 2:
			System.out.println("Following event at: "+requestURL+"/");
			returnString = srJSON.destroyAttend(requestURL, auth_token);
			System.out.println("Response from url: "+returnString);
		break;
		
		case 3:
			System.out.println("Following event at: "+requestURL+"/");
			returnString = srJSON.getAllAttends(requestURL, auth_token);
			System.out.println("Response from url: "+returnString);
		break;
		}
	}
	
	
	



}
