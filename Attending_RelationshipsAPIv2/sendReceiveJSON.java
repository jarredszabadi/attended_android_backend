package Attending_RelationshipsAPIv2;

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
	
	
	
	
	
	
	/*
	 * CREATE
	 */
	
	public  String createAttend(String urlString, JSONObject toAttend, String auth_token) {

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
			conn.setRequestProperty("User_Authorization", auth_token);
			conn.setRequestProperty("Authorization", "c247233c33aef5cde84c973c474c18c8");

			os = conn.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			osw.write(toAttend.toString());
			osw.flush();

			response = getCreateResponse(conn);

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}
	
	
	
	
	
	

	
	
	public  String getCreateResponse(HttpURLConnection c) {
		StringBuilder res = new StringBuilder();
		String output;
		String response = null;
		BufferedReader br;
		try {
			br = new BufferedReader(new InputStreamReader((c.getInputStream())));
			while ((output = br.readLine()) != null) {
				res.append(output);
			}

			response = res.toString();
			c.disconnect();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}	
	
	/*
	 * DESTROY
	 */
	
	public String destroyAttend(String website, String auth_token) {
		URL url;
		String response = null;
		try {
			url = new URL(website);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);

			conn.setRequestMethod("DELETE");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("User_Authorization", auth_token);
			conn.setRequestProperty("Authorization", "c247233c33aef5cde84c973c474c18c8");
			conn.connect();
			conn.getInputStream();
			response = getDeleteResponse(conn);
			

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}

	
	public  String getDeleteResponse(HttpURLConnection c){
		BufferedReader br = null;

		try {
			br = new BufferedReader(new InputStreamReader((c.getInputStream())));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		StringBuilder res = new StringBuilder();
		String output;

		try {
			while ((output = br.readLine()) != null) {
				res.append(output);
				// System.out.println(output);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String resultString = res.toString();

		c.disconnect();

		return resultString;
	}
	
	
	
	
	/*
	 * INDEX
	 */

	public String getAllAttends(String requestURL, String auth_token){
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
			       
			JSONArray events = (JSONArray) data.get("Attended_events");
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
