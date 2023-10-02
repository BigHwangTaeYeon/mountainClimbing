package side.project.publicapi.mvc.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import side.project.publicapi.mvc.dao.LoginDAO;
import side.project.publicapi.mvc.vo.User;

@Service
public class SecurityLoginServiceImpl implements UserDetailsService {
	
	
    @Autowired
	private LoginDAO LoginVODao;

	@Override
    public User loadUserByUsername(String username) {
		
		return LoginVODao.getLoginInfo(username);
    }
	
}
