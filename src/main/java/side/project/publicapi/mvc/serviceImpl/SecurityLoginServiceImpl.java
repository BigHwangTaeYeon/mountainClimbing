package side.project.publicapi.mvc.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import side.project.publicapi.mvc.dao.LoginDAO;
import side.project.publicapi.mvc.vo.User;

import java.util.Optional;

@Service
public class SecurityLoginServiceImpl implements UserDetailsService {
//public class SecurityLoginServiceImpl {

    @Autowired
	private LoginDAO LoginVODao;

    public Optional<User> save(User user) {
		  return LoginVODao.save(user);
    }

    public Optional<User> findByEmailAndOauthType(User user) {
		  return LoginVODao.findByEmailAndOauthType(user);
    }
	
	@Override
    public User loadUserByUsername(String username) {
		  return LoginVODao.getLoginInfo(username);
    }
}
