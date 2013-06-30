


	import java.net.*;
	import java.net.HttpURLConnection;
	import java.io.*;

	public class URLReader {
	    /*public static void main(String[] args) throws Exception {

	        URL oracle = new URL("http://localhost:3000/api/v1/events");
	        BufferedReader in = new BufferedReader(
	        new InputStreamReader(oracle.openStream()));

	        String inputLine;
	        while ((inputLine = in.readLine()) != null)
	            System.out.println(inputLine);
	        in.close();
	    }*/
	   public static void main(String[] args) throws Exception {
      /* URL oracle = new URL("http://localhost:3000/api/v1/events");
       URLConnection yc = oracle.openConnection();
       BufferedReader in = new BufferedReader(new InputStreamReader(
                                   yc.getInputStream()));
       String inputLine;
       while ((inputLine = in.readLine()) != null) 
           System.out.println(inputLine);
       in.close();
       
       */
       
       URL url = new URL("http://www.android.com/");
       HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
       BufferedReader in = new BufferedReader(new InputStreamReader(
           urlConnection.getInputStream()));
       String inputLine;
       while ((inputLine = in.readLine()) != null) 
      	 System.out.println(inputLine);
       in.close();
       urlConnection.disconnect();
       
       /*
       try {
         InputStream in = new BufferedInputStream(urlConnection.getInputStream());
         readStream(in);
        finally {
         urlConnection.disconnect();
       }
      }*/
   }
	   

	}


