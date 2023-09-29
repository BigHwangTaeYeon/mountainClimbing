package side.project.publicapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import side.project.publicapi.service.CultureApiService;
import side.project.publicapi.util.HttpConnection;
import side.project.publicapi.vo.CultureApiVO;

@Controller
@RequestMapping("/api")
public class Culture {
    
    @Autowired
    CultureApiService cultureApiService;
    
    @RequestMapping(value="/culture")
    public String getCulture(Model model) throws Exception {
        // 컬쳐 게시판 select 20개씩 가져와서 보여주기
        List<CultureApiVO> getCultureList = cultureApiService.getCultureList();
        model.addAttribute("getCultureList", getCultureList);
        return "culture/culture";
    }

    @RequestMapping(value="/weather")
    public void getWeather(String method){
        String url = "http://api.kcisa.kr/openapi/CNV_060/request";
        
		// url += "?serviceKey=" + cultureKey;
		// url += "&numOfRows=" + 10;
		// url += "&pageNo=" + 1;

        // HttpConnection hc = new HttpConnection();
        HttpConnection.httpTestByMethod(url, method);
    }

}
