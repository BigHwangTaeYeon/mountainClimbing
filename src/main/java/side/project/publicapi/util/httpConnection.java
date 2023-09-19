public class httpConnection {
    public static void httpTestByMethod(String url, String method, HashMap<String,String> data) {
		
		HttpUtils htppUtils = new HttpUtils();
		String result = "";
		HttpURLConnection conn = htppUtils.getHttpURLConnection(url, method);;

		if("GET".equalsIgnoreCase(method)){
			
			// conn.setDoInput(true); //URL 연결에서 데이터를 읽을지에 대한 설정 ( defualt true )
			result = htppUtils.getHttpRespons(conn);
		}else if("POST".equalsIgnoreCase(method)) {
			
			conn.setDoOutput(true); //URL 연결시 데이터를 사용할지에 대한 설정 ( defualt false )
			try (DataOutputStream dataOutputStream = new DataOutputStream(conn.getOutputStream());){
				
				//String str = "{\"user\" : \"kimchy\",    "
				//		+ "\"post_date\" : \"2009-11-15T14:12:12\",    "
				//		+ "\"message\" : \"trying out Elasticsearch\"}";

				JSONObject jsonData =  new JSONObject(data);
				
				//dataOutputStream.writeBytes(str);
				dataOutputStream.writeBytes(jsonData);
				dataOutputStream.flush();
				
				result = htppUtils.getHttpRespons(conn);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if("DELETE".equalsIgnoreCase(method)) {
			result = htppUtils.getHttpRespons(conn);
		}
		
		System.out.println("Method = " + method + "/ result = " + result);
	}
}
