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
      
		// JSONObject title = (JSONObject)movieData10.get(0);
		// String title1 = (String)title.get("title");

      cultureApiVO cpVO = new cultureApiVO();
      ArrayList<cultureApiVO> getData = new ArrayList();
      for(int i=0; i<movieData10.size(); i++){
         JSONObject jsonList = (JSONObject)movieData10.get(i);

         // 데이터 구분 PK 추출
         String urlStr = (String)jsonList.get("url");
         //http://www.mcst.go.kr/web/s_culture/culture/cultureView.jsp?pSeq=12741
         int index = urlStr.indexOf("pSeq=");
         String result = urlStr.substring(index + 4, str.length());
         cpVO.setPSql(result);

         if(seqCheck)  // 있는 데이터는 손 안본다.
            break;

         cpVO.setTitle((String)jsonList.get("title"));
         cpVO.setPeriod((String)jsonList.get("period"));
         cpVO.setEventPeriod((String)jsonList.get("eventPeriod"));
         cpVO.setEventSite((String)jsonList.get("eventSite"));
         cpVO.setCharge((String)jsonList.get("charge"));
         cpVO.setContactPoint((String)jsonList.get("contactPoint"));
         cpVO.setUrl((String)jsonList.get("url"));
         cpVO.setImageObject((String)jsonList.get("imageObject"));
         cpVO.setDescription((String)jsonList.get("description"));
         cpVO.setViewCount((String)jsonList.get("viewCount"));
         getData.add(cpVO);
      }

      for(int i=0; i<movieData10.size(); i++){
		   cpVO = (cultureApiVO)movieData10.get(i);
         //insert service.insertCulture(cpVO)
      }

     }
}