package side.project.publicapi.api;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import side.project.publicapi.util.HttpConnection;

public class ApiScheduler {
    
    public void cultureApi(String method){
        String url = "http://api.kcisa.kr/openapi/CNV_060/request";
        String cultureKey = "e4cad89f-ee3b-4062-b13e-60734d47a93c";
        
		url += "?serviceKey=" + cultureKey;
		url += "&numOfRows=" + 10;
		url += "&pageNo=" + 1;

        String a = HttpConnection.httpTestByMethod(url, method);

        String strJson = "{\"userId\":\"sim\", "
                + "\"userPw\":\"simpw\","
                + "\"userInfo\":{"
                    + "\"age\":50,"
                    + "\"sex\":\"male\""
                    + "}"
                + "}";

        //2. Parser
        JSONParser jsonParser = new JSONParser();

        //3. To Object
        Object obj = jsonParser.parse(strJson);

        //4. To JsonObject
        JSONObject jsonObj = (JSONObject) obj;

        //print
        System.out.println(jsonObj.get("userId")); //sim
        System.out.println(jsonObj.get("userPw")); //simpw
        System.out.println(jsonObj.get("userInfo")); // {"sex":"male","age":50}

    }

}
