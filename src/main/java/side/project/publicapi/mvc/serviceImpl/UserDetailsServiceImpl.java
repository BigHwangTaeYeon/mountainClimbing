package side.project.publicapi.mvc.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import side.project.publicapi.mvc.dao.LoginDAO;
import side.project.publicapi.mvc.vo.User;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    // UserDetailsService 인터페이스는 DB에서 유저 정보를 가져오는 역할을 한다.
    // private final UserInfoRepository userInfoRepository;

    @Autowired
    private LoginDAO loginDAO;

    @Override
    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
        // https://programmer93.tistory.com/68
        // UserInfo userInfo = userInfoRepository.findByLoginId(loginId).orElseThrow(() -> new UsernameNotFoundException("not found loginId : " + loginId));
        // CustomUserDetails customUserDetails = new CustomUserDetails();
        // 값 세팅 로직 시작
        //...
        // 값 세팅 로직 끝

        // https://to-dy.tistory.com/86
        User user = new User();
        try {
            user = loginDAO.selectUserById(loginId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(user==null) 
                throw new UsernameNotFoundException(loginId);
        }
        // UserDetailsService를 상속받아 DB에서 회원정보를 받아와서 스프링부트에게 넘겨주는 부분을 구현합니다.
        return user;
    }
}