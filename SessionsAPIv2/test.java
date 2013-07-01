package SessionsAPIv2;

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

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JSONObject me = new JSONObject();
		JSONObject user = new JSONObject();
		try {
			me.put("email", "jarred@example.com");
			me.put("password", "jarred");
			//me.put("auth_token", "jarred");
			user.put("User", me);
		}
		catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		createSession("http://localhost:3000/sessions",me ,"jarred");
		deleteSession("http://localhost:3000/");

	}
	
	public static  String createSession(String urlString, JSONObject user, String auth_token) {


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
			conn.setRequestProperty("Authorization", "c247233c33aef5cde84c973c474c18c8");

			os = conn.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			osw.write(user.toString());
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
	
	
	
	
	
	

	
	
	public static String getCreateResponse(HttpURLConnection c) {
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
	
	public static String deleteSession(String website) {
		URL url;
		String response = null;
		try {
			url = new URL(website);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);

			conn.setRequestMethod("DELETE");
			conn.setRequestProperty("Content-Type", "application/json");
			//conn.setRequestProperty("User_Authorization", auth_token);
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

	
	public static String getDeleteResponse(HttpURLConnection c){
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

}
