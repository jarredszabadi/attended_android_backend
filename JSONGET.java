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

public class JSONGET {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// http://localhost:8080/RESTfulExample/json/product/post

	 
		  try {
	 
			URL url = new URL("http://localhost:3000/api/v1/events/2");
			 System.out.println("protocol = " + url.getProtocol());
       System.out.println("authority = " + url.getAuthority());
       System.out.println("host = " + url.getHost());
       System.out.println("port = " + url.getPort());
       System.out.println("path = " + url.getPath());
       System.out.println("query = " + url.getQuery());
       System.out.println("filename = " + url.getFile());
       System.out.println("ref = " + url.getRef());
       
       
       System.out.println("**************\n");
			
			
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("Accept", "application/json");

			//conn.setRequestProperty("Content-Type", "application/json");
	 
			//String input = "{\"title\":Starfox,\"start_at(1i)\":\"2013\",\"start_at(2i)\":\"5\",\"start_at(3i)\":\"18\",\"start_at(4i)\":\"18\"," +
				//	"\"start_at(5i)\":\"39\",\"end_at(1i)\":\"2013\",\"end_at(2i)\":\"5\",\"end_at(3i)\":\"18\",\"end_at(4i)\":\"18\"," +
					//"\"end_at(5i)\":\"39\",\"address\":\"iyg\"}";
		
			/*
			"event"=>{"title"=>"iyug",
					 "start_at(1i)"=>"2013",
					 "start_at(2i)"=>"5",
					 "start_at(3i)"=>"18",
					 "start_at(4i)"=>"18",
					 "start_at(5i)"=>"39",
					 "end_at(1i)"=>"2013",
					 "end_at(2i)"=>"5",
					 "end_at(3i)"=>"18",
					 "end_at(4i)"=>"18",
					 "end_at(5i)"=>"39",
					 "address"=>"iyg"},
	 
			OutputStream os = conn.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			//osw.write(input);
			os.flush();
	 
			if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
				throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
			}
	 */
			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));
			StringBuilder res= new StringBuilder();
			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				res.append(output + "\n");
				//System.out.println(output);
			}
	    String resultString = res.toString();
	    resultString = resultString.substring(0,resultString.length()-1); // remove wrapping "[" and "]"
	    System.out.println(resultString);
			conn.disconnect();
			try {
				JSONObject jsonObjRecv = new JSONObject(resultString);
				System.out.println("\n"+jsonObjRecv.toString());
			}
			catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  } catch (MalformedURLException e) {
	 
			e.printStackTrace();
	 
		  } catch (IOException e) {
	 
			e.printStackTrace();
	 
		 }
	 
		}
	 

	}


