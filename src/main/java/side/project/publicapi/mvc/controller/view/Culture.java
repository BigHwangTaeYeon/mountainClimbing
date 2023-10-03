package side.project.publicapi.mvc.controller.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import side.project.publicapi.com.util.HttpConnection;
import side.project.publicapi.mvc.service.CultureApiService;
import side.project.publicapi.mvc.vo.CultureApiVO;
import side.project.publicapi.mvc.vo.Paging;

@Controller
@RequestMapping("/api")
public class Culture {
    
    @Autowired
    CultureApiService cultureApiService;
    
    @RequestMapping(value="/")
    public String getCulture(Model model, Paging pg) throws Exception {
        // 컬쳐 게시판 select 20개씩 가져와서 보여주기
        // pg.setAmount(0);
        // pg.setPageNum(0);
        List<CultureApiVO> getCultureList = cultureApiService.getCultureList(pg);
        model.addAttribute("getCultureList", getCultureList);
        return "culture/Culture";
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
