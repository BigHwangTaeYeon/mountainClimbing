package side.project.publicapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;;

public class api {
    
    public void cultureApi(){

        String url = "http://api.kcisa.kr/openapi/CNV_060/request";
        //문화체육관광부_문화예술공연(통합)
        //문화체육관광부 대표 누리집의 '문화예술공연' 게시판 및 문화포털(https://www.culture.go.kr/)에 등록된 게시글을 연계하여 제공하는 공연전시 프로그램 정보로 연극, 뮤지컬, 오페라, 음악, 콘서트, 국악, 무용, 전시, 기타 등 각 분야의 문화예술공연 목록 정보를 통합 제공하고 있습니다.
        //https://www.culture.go.kr/data/openapi/openapiView.do?id=580

        HashMap<String, String> data = new HashMap<String, String>();
        data.push("serviceKey", "Key");
        data.push("numOfRows", 10);
        data.push("pageNo", 1);

        httpTestByMethod(url, "GET", data);
		
		httpTestByMethod(url, "POST", data);
		
		httpTestByMethod(url, "DELETE", data);

    }

}
