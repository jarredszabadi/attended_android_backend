package SessionsAPIv2;

import org.json.JSONException;
import org.json.JSONObject;

public class SessionsJsonThread extends Thread{

	private String auth_token;
	private String requestURL;
	private SendReceiveJSON srJSON;
	private JSONObject obj;
	
	public SessionsJsonThread(String auth_token, String email, String password){
		JSONObject user = new JSONObject();
		obj = new JSONObject();
		
		srJSON = new SendReceiveJSON();
		this.auth_token = auth_token;
		
		try {
			user.put("email", email);
			user.put("password", password);
			obj.put("user", user);
			//obj.put("auth_token", auth_token);
		}
		catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setRequestURL(String requestURL){
		this.requestURL = requestURL;
	}
	
	public void run(){
		srJSON.createSession(auth_token, requestURL, obj);
	}

}
