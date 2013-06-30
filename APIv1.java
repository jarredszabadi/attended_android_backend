import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;


public class APIv1 {

	public static void main(String[] args) {
		String website;
		JSONObject event = new JSONObject();
		JSONObject obj = new JSONObject();
		JSONObject address = new JSONObject();
		
		String returnString = new String();
		
		
		/*
		 * Create event
		 */
		////////////////////////////////////////////////////////////////
		System.out.println("Create Event\n************");
		try {
			address.put("street", "CREATE");
			address.put("street_number", "CREATE");
			address.put("apt_number", "CREATE");
			address.put("country", "CREATE");
			address.put("province", "CREATE");
			address.put("city", "CREATE");
			address.put("event_id", "42");
			
			
			event.put( "title", "CREATE");
			event.put( "start_at", "2013-12-10 15:15:15");
			event.put( "end_at", "2013-12-20 15:15:15");
			event.put( "address_attributes", address);
			event.put("user_id", "1");
			event.put("description", "CREATE");
			event.put("event_type", "CREATE");
			
			
			obj.put("event", event);
			System.out.println("object to be created"+obj.toString()+"\n");
			
		}
		catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		website = "http://localhost:3000/api/v1/events";
		returnString=createEvent(website, obj);
		System.out.println("return string: "+returnString+"\n");
		
		
		////////////////////////////////////////////////////////////////////////////////////
		/*
		 * get A single Event
		 */
		/*System.out.println("Get Single Event ID=1\n************");
		website = "http://localhost:3000/api/v1/events/1";
		returnString=getSingleEvent(website);
		System.out.println("\nreturn string: "+returnString+"\n");

		
		
		
		///////////////////////////////////////////////////////////////////////////////////
		
		/*
		 * Get all events => rails = api/v1/events#index
		 */
		/*System.out.println("Get All Events\n************");
		website = "http://localhost:3000/api/v1/events";
		//returnString=getAllEvents(website);
		System.out.println("\nreturn string: "+returnString+"\n");

		///////////////////////////////////////////////////////////////////////////////////
		
		/*
		 * Edit an Event
		 */
		/*try {
			address.put("street", "PUT");
			address.put("street_number", "PUT");
			address.put("apt_number", "PUT");
			address.put("country", "PUT");
			address.put("province", "PUT");
			address.put("city", "PUT");
			address.put("event_id", "5");
			
			
			event.put( "title", "PUT");
			event.put( "start_at", "2013-12-10 15:15:15");
			event.put( "end_at", "2013-12-20 15:15:15");
			event.put( "address_attributes", address);
			event.put("user_id", "1");
			event.put("description", "PUT");
			event.put("event_type", "PUT");
			
			
			obj.put("event", event);
			System.out.println("object to be editted: "+obj.toString()+"\n");
			
		}
		catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("\nEDIT Single Event ID=1\n************");
		website = "http://localhost:3000/api/v1/events/1";
		returnString=editEvent(website, obj);
		System.out.println("\nreturn string: "+returnString+"\n");
		
		System.out.println("\nGet Single Event ID=1\n************");
		website = "http://localhost:3000/api/v1/events/1";
		returnString=getSingleEvent(website);
		System.out.println("\nreturn string: "+returnString+"\n");
		
		///////////////////////////////////////////////////////////////////////////////////

		/*
		 * Delete an Event
		 */
		/*
		System.out.println("Delete Single Event ID=1\n************");
		website = "http://localhost:3000/api/v1/events/1";
		//returnString=deleteEvent(website);
		System.out.println("\nreturn string: "+returnString+"\n");
		*/
		///////////////////////////////////////////////////////////////////////////////////
		
	}
	
	
	
	public static String editEvent(String urlString, JSONObject tobeEdited){
			 
			URL url;
			OutputStream os;
			String response = null;
			try {
				url = new URL(urlString);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setDoOutput(true);

				conn.setRequestMethod("PUT");
				conn.setRequestProperty("Content-Type", "application/json");
				conn.setRequestProperty("Accept", "application/json");
				
				
				os = conn.getOutputStream();
				OutputStreamWriter osw = new OutputStreamWriter(os);
				osw.write(tobeEdited.toString());
				osw.flush();
				
				
				response = getCreateResponse(conn);
				
				
			}
			catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (ProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return response;
	}
	
	
	
	
	
	
	
	public static String deleteEvent(String website){
		URL url;
		String response = null;
		try {
			url = new URL(website);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);

			conn.setRequestMethod("DELETE");
			conn.connect();
			conn.getInputStream();
			//response = getDeleteResponse(conn);
			return "s";
			
		}
		catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}
	
	
	
	
	
	public static String createEvent(String urlString, JSONObject tobeCreated){
			 
			URL url;
			OutputStream os;
			String response = null;
			try {
				url = new URL(urlString);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setDoOutput(true);

				conn.setRequestMethod("POST");

				
				conn.setRequestProperty("Content-Type", "application/json");
				conn.setRequestProperty("Accept", "application/json");
				
				
				os = conn.getOutputStream();
				OutputStreamWriter osw = new OutputStreamWriter(os);
				osw.write(tobeCreated.toString());
				osw.flush();
				
				
				response = getCreateResponse(conn);
				
				
			}
			catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (ProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return response;
	}
	
	
	
	
	
	
	public static String  getSingleEvent(String website){
		URL url;
		String response = null;
		JSONObject r = new JSONObject();
		try {
			url = new URL(website);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);

			conn.setRequestMethod("GET");			
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("Accept", "application/json");

			
			r = getShowResponse(conn);
			response = r.toString();
			
			
		}
		catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}
	
	
	
	
	
	public static String getAllEvents(String website){
		URL url;
		String response = null;
		try {
			url = new URL(website);
			HttpURLConnection c = (HttpURLConnection) url.openConnection();
			c.setDoOutput(true);
			c.setRequestMethod("GET");
			c.setRequestProperty("Content-Type", "application/json");
			c.setRequestProperty("Accept", "application/json");
			response = getCreateResponse(c);
			response = streamAllEvents(c);
			
			
			
		}
		catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return response;
		
	}
	

	
	public static String getCreateResponse(HttpURLConnection c){
		StringBuilder res= new StringBuilder();
		String output;
		String response = null;
		BufferedReader br;
		try {
			br = new BufferedReader(new InputStreamReader(
					(c.getInputStream())));
			while ((output = br.readLine()) != null) {
				res.append(output);
			}
			
			
			
	    response = res.toString();
	    //response = response.substring(0,response.length()-1); // remove wrapping "[" and "]"
	    //System.out.println("777"+response);
			c.disconnect();
			
			
			
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}
	
	public static String streamAllEvents(HttpURLConnection c){
		String output;
		StringBuilder sb = new StringBuilder();
		BufferedReader br;
		try {
			br = new BufferedReader(new InputStreamReader(
					(c.getInputStream())));
			//System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				sb.append(output);
			}
			br.close();
			
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	public static JSONObject getShowResponse(HttpURLConnection c){
		BufferedReader br = null;
		JSONObject returnObj = new JSONObject();
		try {
			br = new BufferedReader(new InputStreamReader(
					(c.getInputStream())));
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		StringBuilder res= new StringBuilder();
		String output;
		try {
			while ((output = br.readLine()) != null) {
				res.append(output);
				//System.out.println(output);
			}
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    String resultString = res.toString();
    //resultString = resultString.substring(1,resultString.length()-1); // remove wrapping "[" and "]"
		c.disconnect();
		try {
			returnObj= new JSONObject(resultString);
		}
		catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnObj;
	}
	
	public static String getDeleteResponse(HttpURLConnection c){
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new InputStreamReader(
					(c.getInputStream())));
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		StringBuilder res= new StringBuilder();
		String output;

		try {
			while ((output = br.readLine()) != null) {
				res.append(output);
				//System.out.println(output);
			}
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    String resultString = res.toString();
    resultString = resultString.substring(1,resultString.length()-1); // remove wrapping "[" and "]"
		c.disconnect();
		
		return resultString;
	}

}
