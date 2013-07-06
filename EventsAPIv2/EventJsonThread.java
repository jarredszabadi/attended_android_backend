package EventsAPIv2;

import org.json.JSONException;
import org.json.JSONObject;

public class EventJsonThread extends Thread{

	private String auth_token;
	private String requestURL;
	private sendReceiveJSON srJSON;
	private JSONObject obj;
	int method;
	//1 = create
	//2 = show
	//3 = delete
	//4 = put
	//5 = index
 
	public EventJsonThread(String auth_token) {
		// TODO Auto-generated constructor stub

		this.auth_token = auth_token;
		srJSON = new sendReceiveJSON();
	}
	
	/*
	 * CONSTRUCTOR 2
	 */
	public EventJsonThread(String auth_token, JSONObject obj) {
		// TODO Auto-generated constructor stub

		this.auth_token = auth_token;
		this.obj = obj;
		srJSON = new sendReceiveJSON();
	}
	/*
	 * CONSTRUCOTR 3
	 */
	public EventJsonThread(String auth_token, String street, String streetNum, String aptNum, String country,
			String province, String city, String event_id, String title, String start_at, String end_at, String user_id, String description, 
			String eventType){
		// TODO Auto-generated constructor stub
		srJSON = new sendReceiveJSON();
		

		this.auth_token = auth_token;
		try {
			this.obj = new JSONObject();
			JSONObject event = new JSONObject();
			JSONObject address = new JSONObject();
			address.put("street", street);
			address.put("street_number", streetNum);
			address.put("apt_number", aptNum);
			address.put("country", country);
			address.put("province", province);
			address.put("city", city);
			address.put("event_id", event_id);
			
			//"2013-12-10 15:15:15"
			event.put( "title", title);
			event.put( "start_at", start_at);
			event.put( "end_at", end_at);
			event.put( "address_string", address);
			event.put("user_id", user_id);
			event.put("description", description);
			event.put("event_type", eventType);
			
			obj.put("event", event);
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
	
	
	


	@Override
	public void run() {
		// TODO Auto-generated method stub


			

			String returnString = new String();
			
			switch(method){
			/*
			 * CREATE
			 */
			case 1: 
								
						System.out.println("Sending: " + obj.toString() + "to "+ requestURL);
						returnString = srJSON.createEvent(requestURL, obj,auth_token);
					
						System.out.println("Message from " + requestURL + ": "+ returnString + "\n");
			break;
						
			/*
			 * SHOW
			 */
			case 2: 
							System.out.println("Getting Event At: " + requestURL);
							returnString = srJSON.getSingleEvent(requestURL, auth_token);
							System.out.println("Message from " + requestURL + ": "+ returnString + "\n");
						
			break;
			/*
			 * DESTROY	
			 */
			case 3:
							System.out.println("Deleteing Event At: " + requestURL);
							returnString = srJSON.deleteEvent(auth_token, requestURL);
							System.out.println("Message from " + requestURL + ": "+ returnString + "\n");
			break;
			/*
			 * PUT
			 */
			case 4:
							System.out.println("Editting Event At: " + requestURL);
							returnString = srJSON.editEvent(auth_token, requestURL, obj);
							System.out.println("Message from " + requestURL + ": "+ returnString + "\n");
			break;
			/*
			 * INDEX
			 */
			case 5:
							System.out.println("Indexing All Events: ");
							returnString = srJSON.getAllEvents(auth_token, requestURL);
							System.out.println("Message from " + requestURL + ": "+ returnString + "\n");
			break;
			}
	}
}
