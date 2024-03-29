package side.project.publicapi.mvc.controller.manage;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import side.project.publicapi.mvc.dao.LoginDAO;
import side.project.publicapi.mvc.service.LoginService;
import side.project.publicapi.mvc.vo.LoginVO;
import side.project.publicapi.mvc.vo.User;

;

@Controller
@RequiredArgsConstructor
@RequestMapping("login/manage")
public class SecurityLoginController {
    
    @Autowired
    LoginService loginService;

    @Autowired
    LoginDAO LoginVODao;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    // ID 생성
    @PostMapping("/createId")
    public String createId (@RequestBody LoginVO vo) throws Exception{
        int check = loginService.loginCheck(vo);
        if(check == 0)
            loginService.loginInsert(vo);
        // else
            // bindingResult.reject("createFail", "입력하신 아이디는 이미 사용되고 있습니다.");
        // return "redirect:login/Login";
        return "culture/Culture";
    }

    // LOGIN 인증 및 세션 부여
    @PostMapping("/signIn")
    public String login(User user, HttpServletRequest httpServletRequest) throws Exception {

        String rawPassword = user.getPw();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);
//        user.set(encPassword);
        user.setRole("ROLE_USER");
//        userRepository.save(user);

//        String user = loginService.getLoginId(vo);
//        User user = LoginVODao.selectUserById(vo.getLoginId());

        if(user == null) 
            return "login/ConnectId";

        // 로그인 성공 => 세션 생성
        // 세션을 생성하기 전에 기존의 세션 파기
        httpServletRequest.getSession().invalidate();
        HttpSession session = httpServletRequest.getSession(true);  // Session이 없으면 생성
        // 세션에 userId를 넣어줌
        session.setAttribute("userId", user);
        // session.setMaxInactiveInterval(1800); // Session이 30분동안 유지

        return "culture/Culture";
    }

//    @PostMapping("/logout")
//    public String logout(HttpServletRequest request, HttpServletResponse response) {
//        new SecurityContextLogoutHandler().logout(request, response,
//                SecurityContextHolder.getContext().getAuthentication());
//        return "login/Success";
//    }





}
