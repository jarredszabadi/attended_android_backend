package Following_RelationshipsAPIv2;

import org.json.JSONException;
import org.json.JSONObject;
import EventsAPIv2.sendReceiveJSON;



public class following_RelationshipsThread extends Thread{

	private String auth_token;
	private String requestURL;
	private sendReceiveJSON srJSON;
	private JSONObject obj;
	int method;
	//1 = create
	
	public following_RelationshipsThread(String auth_token) {
		// TODO Auto-generated constructor stub

		this.auth_token = auth_token;
		srJSON = new sendReceiveJSON();
	}
	
	/*
	 * CONSTRUCTOR 2
	 */
	public following_RelationshipsThread(String auth_token, JSONObject obj) {
		// TODO Auto-generated constructor stub

		this.auth_token = auth_token;
		this.obj = obj;
		srJSON = new sendReceiveJSON();
	}
	
	/*
	 * CONSTRUCOTR 3
	 */
	public following_RelationshipsThread(String auth_token,String user_ID){
		// TODO Auto-generated constructor stub
		srJSON = new sendReceiveJSON();
		

		this.auth_token = auth_token;
		try {
			this.obj = new JSONObject();
			obj.put("id", user_ID);
			
		
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

}
