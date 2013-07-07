import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class StatisticAPIv2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		geStatistics("http://localhost:3000/api/v1/user_statistics/1", "jarred");
	}
	
	
	/*
	 * SHOW
	 */

	public static String geStatistics(String requestURL, String auth_token){
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
			       
			int followers = (Integer)data.get("Followers_count");
			int following = (Integer)data.get("Following_count");
			int attends = (Integer)data.get("Attends_count");
			int events = (Integer)data.get("Events_count");
			
			
			System.out.println("Followers:" +followers);
			System.out.println("Following:" +following);
			System.out.println("Attends:" +attends);
			System.out.println("Events Created:" +events);
			//JSONObject event;
			
			/*
			for(int i =0; i<events.length(); i++){
				event = (JSONObject) events.get(i);
				System.out.println(event.toString());
			}
			/*
			events = (JSONArray) data.get("Following_count");

			
			for(int i =0; i<events.length(); i++){
				event = (JSONObject) events.get(i);
				System.out.println(event.toString());
			}
			
			events = (JSONArray) data.get("Attends_count");

			
			for(int i =0; i<events.length(); i++){
				event = (JSONObject) events.get(i);
				System.out.println(event.toString());
			}
			
			events = (JSONArray) data.get("Events_count");

			
			for(int i =0; i<events.length(); i++){
				event = (JSONObject) events.get(i);
				System.out.println(event.toString());
			}*/
		}
		catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		return sb.toString();
	}
	
	

}
