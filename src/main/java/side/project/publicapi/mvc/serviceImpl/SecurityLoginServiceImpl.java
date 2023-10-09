package side.project.publicapi.mvc.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import side.project.publicapi.mvc.dao.LoginDAO;
import side.project.publicapi.mvc.vo.User;

@Service
public class SecurityLoginServiceImpl implements UserDetailsService {
	
	
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
