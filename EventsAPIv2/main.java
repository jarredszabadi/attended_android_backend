package EventsAPIv2;

import org.json.JSONException;
import org.json.JSONObject;

public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		JSONObject obj = new JSONObject();
		JSONObject event = new JSONObject();
		JSONObject address = new JSONObject();
		try {
		
		address.put("street", "constructor2");
		address.put("street_number", "12");
		address.put("apt_number", "152");
		address.put("country", "constructor2");
		address.put("province", "constructor2");
		address.put("city", "PUT");
		address.put("event_id", "1");
		
		
		event.put( "title", "constructor2");
		event.put( "start_at", "2013-12-10 15:15:15");
		event.put( "end_at", "2013-12-20 15:15:15");
		event.put( "address_string", address);
		event.put("user_id", "1");
		event.put("description", "constructor2");
		event.put("event_type", "constructor2");
		
		obj.put("event", event);
		
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		/*
		 * CREATE
		 */
		//test constructor 2
		/*
		EventJsonThread t1 = new EventJsonThread("jarred", obj);
		t1.setRequestURL("http://localhost:3000/api/v1/events"); //change the event number when u test it
		t1.setMethod(1);
		t1.start();
		

		//test constructor 3
		
		EventJsonThread t = new EventJsonThread("jarred", "constructor3", "12", "152", "constructor3", "constructor3", "PUT", "1", "constructor3", "2013-12-10 15:15:15",
				"2013-12-20 15:15:15", "1", "constructor3", "constructor3");
		t.setRequestURL("http://localhost:3000/api/v1/events");
		t.setMethod(1);
		t.start();
		
		/*
		 * SHOW
		 */
		
		/*
		EventJsonThread t2 = new EventJsonThread("jarred");
		t2.setRequestURL("http://localhost:3000/api/v1/events/1"); //change the event number when u test it
		t2.setMethod(2);
		t2.start();
		
		
		/*
		 * DESTROY
		 */
		/*
		EventJsonThread t3 = new EventJsonThread("jarred");
		t3.setRequestURL("http://localhost:3000/api/v1/events/7"); //change the event number when u test it
		t3.setMethod(2);
		t3.start();
	
		/*
		 * PUT
		 */
		
		EventJsonThread t4 = new EventJsonThread("jarred", "TEST NOTIFICATION", "12", "152", "TEST EDIT", "TEST EDIT", "PUT", "1", "TEST EDIT", "2013-12-10 15:15:15",
				"2013-12-20 15:15:15", "1", "TEST EDIT", "TEST EDIT");
		t4.setRequestURL("http://localhost:3000/api/v1/events/8"); //change the event number when u test it
		t4.setMethod(4);
		t4.start();

		/*
		 * INDEX
		 */
		/*
		EventJsonThread t5 = new EventJsonThread("jarred");
		t5.setRequestURL("http://localhost:3000/api/v1/events"); //change the event number when u test it
		t5.setMethod(5);
		t5.start();*/
	}

}
