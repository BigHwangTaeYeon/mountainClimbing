package side.project.publicapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;;

public class api {
    
    @Value("${api.culture.key}")
    private String cultureKey;

    public void cultureApi(String method){
        String url = "http://api.kcisa.kr/openapi/CNV_060/request";
        String method = "GET";
        HashMap<String, String> data = new HashMap<String, String>();
        data.push("serviceKey", cultureKey);
        data.push("numOfRows", 10);
        data.push("pageNo", 1);

        httpConnection hc = new httpConnection();
        hc.httpTestByMethod(url, method, data);
    }

}
