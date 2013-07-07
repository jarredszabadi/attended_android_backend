package NotificationsAPIv2;

import org.json.JSONException;
import org.json.JSONObject;


public class NotificationsJsonThread extends Thread{
	private String auth_token;
	private String requestURL;
	private sendReceiveJSON srJSON;
	private JSONObject obj;
	int method;
	
	public NotificationsJsonThread(String auth_token){
		this.auth_token = auth_token;
		srJSON = new sendReceiveJSON();
	}
	
	public NotificationsJsonThread(String auth_token, String user_id){
		this.auth_token = auth_token;
		obj = new JSONObject();
		srJSON = new sendReceiveJSON();
		
		try {
			obj.put("user_id", user_id);
		}
		catch (JSONException e) {
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
		
		returnString = srJSON.index(requestURL, auth_token);
	}
}
