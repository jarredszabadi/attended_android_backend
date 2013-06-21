

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;


public class createPostThread extends Thread {
	private final String message;

	private final String auth_token;
	private final String requestURL;
	private sendReceiveJSON srJSON;

	public createPostThread(String message, String auth_token,
			String requestURL) {
		// TODO Auto-generated constructor stub
		this.message = message;
		this.auth_token = auth_token;
		this.requestURL = requestURL;
		srJSON = new sendReceiveJSON();
	}

	
	private boolean checkNoteLength() {
		// TODO Auto-generated method stub
		if (message == null) {
			return false;
		}
		return true;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		if (checkNoteLength()) {

			JSONObject obj = new JSONObject();
			JSONObject note = new JSONObject();
			String returnString = new String();
			
			JSONObject event = new JSONObject();
			JSONObject obj2 = new JSONObject();
			JSONObject address = new JSONObject();

			try {
				//note.put("text", message);
				//obj.put("note", note);
				
				address.put("street", "streetPUT");
				address.put("street_number", "12");
				address.put("apt_number", "152");
				address.put("country", "PUT");
				address.put("province", "PUT");
				address.put("city", "PUT");
				address.put("event_id", "42");
				
				
				event.put( "title", "PUT");
				event.put( "start_at", "2013-12-10 15:15:15");
				event.put( "end_at", "2013-12-20 15:15:15");
				event.put( "address_attributes", address);
				event.put("user_id", "1");
				event.put("description", "description2");
				event.put("event_type", "PUT");
				
				obj.put("event", event);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("Sending: " + obj.toString() + "to "
					+ requestURL);
			returnString = srJSON.createEvent(requestURL, obj,
					auth_token);
			
			System.out.println("Message from " + requestURL + ": "
					+ returnString + "\n");


		}else{			
			System.out.println("ERROR: note content cannot be blank");
		}

	}

}
