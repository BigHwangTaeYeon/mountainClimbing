package side.project.publicapi.scheduler;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.scheduling.annotation.Scheduled;

import side.project.publicapi.util.HttpConnection;
import side.project.publicapi.vo.cultureApiVO;

public class ApiScheduler {
   @Scheduled(fixedRate = 3000)
   public void fixedRate() {
      System.out.println("fixedRate: 현재시간 - {}");
   }
   public void cultureApi(String method) throws Exception {
      String url = "http://api.kcisa.kr/openapi/CNV_060/request";
      String cultureKey = "e4cad89f-ee3b-4062-b13e-60734d47a93c";
        
		url += "?serviceKey=" + cultureKey;
		url += "&numOfRows=" + 10;
		url += "&pageNo=" + 1;

      String result = HttpConnection.httpTestByMethod(url, method);


		// JSONParser로 JSONObject 객체
		JSONObject objData = (JSONObject)new JSONParser().parse(result);
		// 첫 번째 JSONObject
		JSONObject objData1 = (JSONObject)objData.get("response");
		// 첫 번째 JSONObject
		JSONObject movieData = (JSONObject)objData1.get("body");
		// 첫 번째 JSONObject
		JSONObject movieData1 = (JSONObject)movieData.get("items");
		// 두 번째 JSONObject
      JSONArray movieData10 = (JSONArray)movieData1.get("item");
      movieData10.size();
		JSONObject title = (JSONObject)movieData10.get(0);
		String title1 = (String)title.get("title");

      cultureApiVO cpVO = new cultureApiVO();
      for(int i=0; i<movieData10.size(); i++){
		   cpVO = (cultureApiVO)movieData10.get(i);
         //insert service.insertCulture(cpVO)
      }

     }
}