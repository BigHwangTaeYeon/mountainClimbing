package side.project.publicapi.scheduler;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import side.project.publicapi.config.ApplicationContextProvider;
import side.project.publicapi.service.CultureApiService;
import side.project.publicapi.util.HttpConnection;
import side.project.publicapi.vo.CultureApiVO;

public class ApiScheduler {
   
   CultureApiService cultureApiService = (CultureApiService) ApplicationContextProvider.getApplicationContext().getBean(CultureApiService.class);
   
   public void cultureApi(String method) throws Exception {
      String url = "http://api.kcisa.kr/openapi/CNV_060/request";
      String cultureKey = "e4cad89f-ee3b-4062-b13e-60734d47a93c";

		url += "?serviceKey=" + cultureKey;
		url += "&numOfRows=" + 100;
		url += "&pageNo=" + 1;

      String httpConResult = HttpConnection.httpTestByMethod(url, method);

		// JSONParser로 JSONObject 객체
		JSONObject objData = (JSONObject)new JSONParser().parse(httpConResult);
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

      CultureApiVO cpVO;
      for(int i=0; i<movieData10.size(); i++){
         cpVO = new CultureApiVO();
         JSONObject jsonList = (JSONObject)movieData10.get(i);

         // 데이터 구분 PK 추출
         String urlStr = (String)jsonList.get("url");
         //http://www.mcst.go.kr/web/s_culture/culture/cultureView.jsp?pSeq=12741
         int index = urlStr.indexOf("pSeq=");
         int seqResult = Integer.parseInt(urlStr.substring(index + 5, urlStr.length()));
         cpVO.setP_seq(seqResult);

         // 있는 데이터는 손 안본다.
         if(cultureApiService.seqCheck(seqResult) == 1)  
            continue;
         //VO.class에서 한번에 담을 수 있도록 준비
         cpVO = new CultureApiVO.Builder(seqResult)
                                 .title((String)jsonList.get("title"))
                                 .period((String)jsonList.get("period"))
                                 .event_period((String)jsonList.get("eventPeriod"))
                                 .event_site((String)jsonList.get("eventSite"))
                                 .charge((String)jsonList.get("charge"))
                                 .contact_point((String)jsonList.get("contactPoint"))
                                 .url((String)jsonList.get("url"))
                                 .image_object((String)jsonList.get("imageObject"))
                                 // .description((String)jsonList.get("description"))
                                 .view_count((String)jsonList.get("viewCount"))
                                 .build();
                                 
         cultureApiService.cultureInsert(cpVO);
      }

   }

   public void weatherApi(String method) throws Exception {
      // https://apis.data.go.kr/1360000/MidFcstInfoService/getMidLandFcst?
      // serviceKey=wvclTcKfaznWPJW5f137YCcDLJ41ee%2B6his8ede7mYo6xCNwf1isheXbQpXzRKN6IX7v7ilYRbYzPAEkM0Bl0Q%3D%3D&
      // pageNo=1&
      // numOfRows=10&
      // dataType=JSON&
      // regId=11B00000&
      // tmFc=202309260600

      String url = "https://apis.data.go.kr/1360000/MidFcstInfoService/getMidLandFcst";
      String weatherKey = "wvclTcKfaznWPJW5f137YCcDLJ41ee+6his8ede7mYo6xCNwf1isheXbQpXzRKN6IX7v7ilYRbYzPAEkM0Bl0Q==&"; //공공데이터포털에서 받은 인증키
      String pageNo = ""; //페이지번호
      String numOfRows = ""; //한 페이지 결과 수
      String dataType = ""; //요청자료형식(XML/JSON)Default: XML
      String regId = ""; //11B0000 서울, 인천, 경기도 11D10000 등 (활용가이드 하단 참고자료 참조)
      String tmFc = ""; // 202309260600 조회 시간, 일 2회(06:00,18:00)회 생성

      SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
      Calendar c1 = Calendar.getInstance();
      String strToday = sdf.format(c1.getTime());
      tmFc = strToday + "0600 or 1800";

		url += "?serviceKey=" + weatherKey + "pageNo=" + pageNo + "&numOfRows=" + numOfRows + "&dataType=" + dataType + "&regId=" + regId + "&tmFc=" + tmFc;

      String result = HttpConnection.httpTestByMethod(url, method);
      
      System.out.println(result);
   }

}