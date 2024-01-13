package side.project.publicapi.mvc.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import side.project.publicapi.mvc.dao.LoginDAO;
import side.project.publicapi.mvc.vo.User;
import side.project.publicapi.mvc.vo.auth.MemberDetails;

import java.util.Optional;

@Service
public class SecurityLoginServiceImpl implements UserDetailsService {
//public class SecurityLoginServiceImpl {

    @Autowired
	private LoginDAO LoginVODao;

    @Autowired
    private PasswordEncoder passwordEncoder;	//@Autowired를 통해 PasswordEncoder를 선언할 때 자동으로 클래스 바인딩 됨.

    public Optional<User> save(User user) {
		  return LoginVODao.save(user);
    }

    public Optional<User> findByEmailAndOauthType(User user) {
		  return LoginVODao.findByEmailAndOauthType(user);
    }

	@Override
    public UserDetails loadUserByUsername(String username) {
        User user = new User();
        try {
            user = LoginVODao.selectUserById(username);

            //★해싱하는 코드★
            String password = passwordEncoder.encode(user.getPw());

            user.setPw(password);
            user.setRole("ROLE_USER");

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if(user != null){
                return new MemberDetails(user);
            }
        }
        return null;

//        User user = null;
//        try {
//            user = LoginVODao.selectUserById(username);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        } finally {
//            if(user == null)
//                throw new UsernameNotFoundException(username);
//        }

//        return user;
//		  return LoginVODao.getLoginInfo(username);
    }
}
