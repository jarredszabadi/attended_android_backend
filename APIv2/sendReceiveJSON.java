package APIv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


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

	public String editEvent(String urlString, JSONObject tobeEdited) {

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

	
	
	
	public  String createEvent(String urlString, JSONObject tobeCreated,
			String auth_token) {

		try {
			if (tobeCreated == null || tobeCreated.isNull("user")) {
				tobeCreated.put("user", getAuthObj(" ", " "));
			}
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

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
			osw.write(tobeCreated.toString());
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

	public  String getSingleEvent(String website, String auth_token) {
		URL url;
		String response = null;
		JSONObject r = new JSONObject();
		try {
			url = new URL(website);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			//conn.setDoOutput(true);

			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("User_Authorization", auth_token);
			conn.setRequestProperty("Authorization", "c247233c33aef5cde84c973c474c18c8");


			r = getShowResponse(conn);
			response = r.toString();

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
	
	public  JSONObject getShowResponse(HttpURLConnection c) {
		BufferedReader br = null;
		JSONObject returnObj = new JSONObject();
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
		// resultString = resultString.substring(1,resultString.length()-1); //
		// remove wrapping "[" and "]"
		c.disconnect();
		try {
			returnObj = new JSONObject(resultString);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnObj;
	}
	
	
	
	public String deleteEvent(String auth_token, String website) {
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
		resultString = resultString.substring(1, resultString.length() - 1); // remove
																				// wrapping
																				// "["
																				// and
																				// "]"
		c.disconnect();

		return resultString;
	}
/*
	public  String getAllEvents(String website, String auth_token) throws IOException {
		URL url = new URL(website);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		
		
		String xmlResponse = null;

		try {
			String url = website;
			Log.d("getAllEvents", "performing get " + url);

			HttpGet method = new HttpGet(new URI(url));
			method.addHeader("Authorization", auth_token);
			HttpResponse response = httpClient.execute(method);
			if (response != null) {
				xmlResponse = streamAllEvents(response.getEntity());
			} else {
				Log.i("getAllEvents", "got a null response");
			}
		} catch (IOException e) {
			Log.e("Error", "IOException " + e.getMessage());
		} catch (URISyntaxException e) {
			Log.e("Error", "URISyntaxException " + e.getMessage());
		}
		
		return xmlResponse;
		
		

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

	public  String streamAllEvents(HttpEntity entity) {
		String response = "";

		try {
			int length = (int) entity.getContentLength();
			StringBuffer sb = new StringBuffer(length);
			InputStreamReader isr = new InputStreamReader(entity.getContent(),
					"UTF-8");
			char buff[] = new char[length];
			int cnt;
			while ((cnt = isr.read(buff, 0, length - 1)) > 0) {
				sb.append(buff, 0, cnt);
			}

			response = sb.toString();
			isr.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
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
		resultString = resultString.substring(1, resultString.length() - 1); // remove
																				// wrapping
																				// "["
																				// and
																				// "]"
		c.disconnect();

		return resultString;
	}
*/
}