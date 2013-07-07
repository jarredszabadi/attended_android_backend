package CommentsAPIv2;

import org.json.JSONException;
import org.json.JSONObject;


public class CommentsJsonThread extends Thread{

	
	
	
	private String auth_token;
	private String requestURL;
	private sendReceiveJSON srJSON;
	private JSONObject obj;
	int method;
	//1 = create
	
	public CommentsJsonThread(String auth_token) {
		// TODO Auto-generated constructor stub

		this.auth_token = auth_token;
		srJSON = new sendReceiveJSON();
	}
	
	/*
	 * CONSTRUCTOR 2
	 */
	public CommentsJsonThread(String auth_token, JSONObject obj) {
		// TODO Auto-generated constructor stub

		this.auth_token = auth_token;
		this.obj = obj;
		srJSON = new sendReceiveJSON();
	}
	
	/*
	 * CONSTRUCOTR 3
	 */
	public CommentsJsonThread(String auth_token,String event_id, String content){
		// TODO Auto-generated constructor stub
		srJSON = new sendReceiveJSON();
		JSONObject comment = new JSONObject();
		

		this.auth_token = auth_token;
		try {
			this.obj = new JSONObject();
			comment.put("Event_id", event_id);
			comment.put("Content", content);
			obj.put("Comment", comment);
			
		
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
		
		String returnstring = new String();
		
		switch(method){
			case 1:
				System.out.println("Commenting on event: ");
				returnstring = srJSON.createComment(requestURL, obj, auth_token);
				System.out.println("Response from url: "+requestURL +": "+returnstring);
				
			break;
			
			case 2:
				System.out.println("Getting all comments on an event: ");
				returnstring = srJSON.getAllComments(requestURL, auth_token);
				System.out.println("Response from url: "+requestURL +": "+returnstring);
			break;
		}
		
	}
	

}
