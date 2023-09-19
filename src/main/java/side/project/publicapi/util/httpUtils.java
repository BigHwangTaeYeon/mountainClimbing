public class httpUtils {
    public HttpURLConnection getHttpURLConnection(String strUrl, String method) {
		URL url;
		HttpURLConnection conn = null;
		try {
			url = new URL(strUrl);
			
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod(method); //Method 방식 설정. GET/POST/DELETE/PUT/HEAD/OPTIONS/TRACE
			conn.setConnectTimeout(5000); //연결제한 시간 설정. 5초 간 연결시도
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("accept", "application/json");

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		return conn;
		
	}
	
	public String getHttpRespons(HttpURLConnection conn) {
		StringBuilder sb = null;

		try {
			if(conn.getResponseCode() == 200) {
				//정상적으로 데이터를 받았을경우
				sb = readResopnseData(conn.getInputStream());
			}else{
				//정상적으로 데이터를 받지 못한 경우 
				System.out.println(conn.getResponseCode());
				System.out.println(conn.getResponseMessage());
				
				sb = readResopnseData(conn.getErrorStream());
				
				System.out.println("error : " + sb.toString());
				
				return null;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			conn.disconnect(); //연결 해제
		};
		
		if(sb == null) return null;
		
		return sb.toString();
	}
	
	public StringBuilder readResopnseData(InputStream in) {
		
		if(in == null ) return null;

		StringBuilder sb = new StringBuilder();

		String line = "";
		
		try (InputStreamReader ir = new InputStreamReader(in);
				BufferedReader br = new BufferedReader(ir)){
			while( (line = br.readLine()) != null) {
				sb.append(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sb;
	}

}
