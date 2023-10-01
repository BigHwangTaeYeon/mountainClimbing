package side.project.publicapi.mvc.service;

import side.project.publicapi.mvc.vo.LoginVO;

public interface LoginService {
    
    String getLoginId(LoginVO vo) throws Exception;

    int loginCheck(LoginVO vo) throws Exception;

    void loginInsert(LoginVO vo) throws Exception;

}
