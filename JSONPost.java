import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;




public class JSONPost {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		JSONObject event = new JSONObject();
		JSONObject obj = new JSONObject();
		JSONObject address = new JSONObject();
		
		
		
		try {
			address.put("street", "streetPUT");
			address.put("street_number", "12");
			address.put("apt_number", "152");
			address.put("country", "PUT");
			address.put("province", "PUT");
			address.put("city", "PUT");
			address.put("event_id", "42");
		}
		catch (JSONException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		try {
			
		  event.put( "title", "PUT");
			event.put( "start_at", "2013-12-10 15:15:15");
			event.put( "end_at", "2013-12-20 15:15:15");
			event.put( "address_attributes", address);
			event.put("user_id", "1");
			event.put("description", "description2");
			event.put("event_type", "PUT");
			
		}
		
		catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
		
		
		try {
			obj.put("event", event);
		}
		catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(obj.toString());
		


		try {
	 
			URL url = new URL("http://localhost:3000/api/v1/events/1");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			//conn.setRequestProperty("Content-Type", "application/json");
			//conn.setRequestProperty("Accept", "application/json");
		 // conn.setRequestProperty("Content-Type", "application/json;charset=utf-8");
		  //conn.setRequestProperty("X-Requested-With", "XMLHttpRequest");
			

			conn.connect();
			conn.getInputStream();
			//String urlParameters = "id=1";

			OutputStream os = conn.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			osw.write(obj.toString());
			//osw.write(urlParameters);
			osw.flush();
	 /*
			if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
				throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
			}
	 */
			

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));
	 
			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}
	 
			conn.disconnect();
	 
		  } catch (MalformedURLException e) {
	 
			e.printStackTrace();
	 
		  } catch (IOException e) {
	 
			e.printStackTrace();
	 
		 }
	 
		}
	 

	}


