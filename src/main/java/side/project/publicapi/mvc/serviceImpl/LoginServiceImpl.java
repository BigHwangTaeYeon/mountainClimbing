package side.project.publicapi.mvc.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import side.project.publicapi.com.util.AesUtil;
import side.project.publicapi.mvc.dao.LoginDAO;
import side.project.publicapi.mvc.service.LoginService;
import side.project.publicapi.mvc.vo.LoginVO;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
	private LoginDAO LoginVODao;

	public int loginCheck(LoginVO vo) throws Exception {
  		String encData = AesUtil.aesCBCEncode(vo.getPw());
		vo.setPw(encData);
		return LoginVODao.loginCheck(vo);
	}

    // data insert
    public void loginInsert(LoginVO vo) throws Exception{
		LoginVODao.loginInsert(vo);
	}

	@Override
	public String getLoginId(LoginVO vo) throws Exception {
  		String encData = AesUtil.aesCBCEncode(vo.getPw());
		vo.setPw(encData);
		return LoginVODao.getLoginId(vo);
	}
	
	@Override
	public LoginVO getLoginInfo(LoginVO vo) throws Exception {
  		String encData = AesUtil.aesCBCEncode(vo.getPw());
		vo.setPw(encData);
		return LoginVODao.getLoginInfo(vo);
	}
}
