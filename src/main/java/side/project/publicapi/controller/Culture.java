package side.project.publicapi.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import side.project.publicapi.util.HttpConnection;

@Controller
@RequestMapping("/api")
public class Culture {
    
    @Value("${api.culture.key}")
    private String cultureKey;
    
    @RequestMapping(value="/culture")
    public void getCulture() throws Exception {
        // 컬쳐 게시판 select 20개씩 가져와서 보여주기
    }

    @RequestMapping(value="/weather")
    public void getWeather(String method){
        String url = "http://api.kcisa.kr/openapi/CNV_060/request";
        
		url += "?serviceKey=" + cultureKey;
		url += "&numOfRows=" + 10;
		url += "&pageNo=" + 1;

        // HttpConnection hc = new HttpConnection();
        HttpConnection.httpTestByMethod(url, method);
    }

}
