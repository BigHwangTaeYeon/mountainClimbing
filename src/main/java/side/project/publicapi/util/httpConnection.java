package side.project.publicapi.util;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;

public class HttpConnection {
    public static String httpTestByMethod(String url, String method) {
		HttpUtils htppUtils = new HttpUtils();
		String result = "";

		HttpURLConnection conn = htppUtils.getHttpURLConnection(url, method);

		if("GET".equalsIgnoreCase(method)){
			result = htppUtils.getHttpRespons(conn);
		}else if("POST".equalsIgnoreCase(method)) {
			conn.setDoOutput(true); //URL 연결시 데이터를 사용할지에 대한 설정 ( defualt false )
			try (DataOutputStream dataOutputStream = new DataOutputStream(conn.getOutputStream());){
				//String str = "{\"user\" : \"kimchy\",    "
				//		+ "\"post_date\" : \"2009-11-15T14:12:12\",    "
				//		+ "\"message\" : \"trying out Elasticsearch\"}";
				// String stringData = data.toString();
				// JSONObject jsonData =  new JSONObject(data);
				//dataOutputStream.writeBytes(str);
				// dataOutputStream.writeBytes(stringData);
				dataOutputStream.flush();
				result = htppUtils.getHttpRespons(conn);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else if("DELETE".equalsIgnoreCase(method)) {
			result = htppUtils.getHttpRespons(conn);
		}
		System.out.println("Method = " + method + "/ result = " + result);
		return result;
	}
}
