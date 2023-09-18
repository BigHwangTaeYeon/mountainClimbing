package side.project.publicapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;;

public class api {
    
    public void mountain(){

        String url = "https://api.vworld.kr/req/data";
        //sampleData = 'https://api.vworld.kr/req/data?service=data&version=2.0&request=GetFeature&key=%24%24KJeB2cxWt-HX_0fFllSqPnebrwByLJklBoBvxM2_KiR61F8IXfp9eSlD2aN-FPAl&format=xml&errorformat=xml&size=10&page=1&data=LT_L_FRSTCLIMB&geomfilter=LINESTRING(13133057.313802%204496529.073264%2C14133023.872602%204496514.7413212)&attrfilter=sec_len%3ABETWEEN%3A100%2C200&columns=sec_len%2Cup_min%2Cdown_min%2Ccat_nam%2Cmntn_nm%2Cag_geom&geometry=true&attribute=true&crs=EPSG%3A900913&domain=api.vworld.kr'
		//
        
        
        httpTestByMethod(url, "GET");
		
		httpTestByMethod(url, "POST");
		
		httpTestByMethod(url, "DELETE");

    }

}
