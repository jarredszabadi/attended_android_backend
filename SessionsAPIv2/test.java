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
		
			
		
			SessionsJsonThread t = new SessionsJsonThread("jarred", "jarred", "jarred@example.com");
			t.setRequestURL("http://localhost:3000/api/v1/sessions");
			t.run();
		
		
		
	

	}
	
	
}
