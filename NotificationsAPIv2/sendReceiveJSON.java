package NotificationsAPIv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class sendReceiveJSON {

	
		public JSONObject getAuthObj(String username, String password) {
			// TODO Auto-generated method stub

			JSONObject obj = new JSONObject();
			JSONObject user = new JSONObject();

			try {

				user.put("email", username);
				user.put("password", password);

				obj.put("user", user);

				return obj;
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return null;
		}
	
		
		/*
		 * INDEX
		 */

		public String index(String requestURL, String auth_token){
			URL url;
			String response = null;
			try {
				url = new URL(requestURL);
				HttpURLConnection c = (HttpURLConnection) url.openConnection();

				c.setRequestMethod("GET");
				c.setRequestProperty("Content-Type", "application/json");
				c.setRequestProperty("Accept", "application/json");
				c.setRequestProperty("User_Authorization", auth_token);
				c.setRequestProperty("Authorization", "c247233c33aef5cde84c973c474c18c8");
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
		
		public static String streamAllEvents(HttpURLConnection c){
			String output;
			StringBuilder sb = new StringBuilder();
			BufferedReader br;
			JSONObject data; 
			
			
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

			try {
				data = ((JSONObject) new JSONObject(sb.toString())).getJSONObject("data");
				       
				JSONArray events = (JSONArray) data.get("Notifications");
				JSONObject event;
				
				for(int i =0; i<events.length(); i++){
					event = (JSONObject) events.get(i);
					System.out.println(event.toString());
				}
			}
			catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			return sb.toString();
		}


	}
