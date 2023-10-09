package side.project.publicapi.mvc.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;;

@Controller
@RequiredArgsConstructor
@RequestMapping("login/view")
public class LoginController {
    
    // ID 생성
    @GetMapping("/signUp")
    public String signUp () throws Exception{
        return "login/CreateId";
    }
    
    // LOGIN 화면
    @GetMapping("/login")
    public String login () throws Exception{
        
        return "login/ConnectId";
    }

    // LOGIN 화면
    @GetMapping("/oauthLogin")
    public String oauthLogin () throws Exception{
        
        return "login/oauthLogin";
    }

    // 🪴 승인된 리디렉션 URI
    // - 서비스에서 파라미터로 인증 정보가 주었을 때 인증이 성공하면 구글에서 리다이렉트할 URL
    // - 스프링 부트 2 버전의 시큐리티에서는 기본적으로 {도메인}/login/oauth2/code/{소셜서비스코드}
    // - 별도록 리다이렉트 URL을 지원하는 Controller을 만들 필요 없음
    @GetMapping("/oauth/google")
    public String oauthGoogle() {

        return "login/Success";
    }

    // @Autowired
    // LoginService loginService;
    
    // @RequestMapping("/createId")
    // public void createId (LoginVO vo) throws Exception{
    //     int check = loginService.loginCheck(vo);
    //     if(check == 0)
    //         loginService.loginInsert(vo);
    //     // else
    //         // bindingResult.reject("createFail", "입력하신 아이디는 이미 사용되고 있습니다.");
    // }

    // @PostMapping("/login")
    // public String login(LoginVO vo, HttpServletRequest httpServletRequest, Model model) throws Exception {

    //     String user = loginService.getLoginId(vo);

    //     // 로그인 아이디나 비밀번호가 틀린 경우 global error return
    //     if(user == null) 
    //         // bindingResult.reject("loginFail", "로그인 아이디 또는 비밀번호가 틀렸습니다.");

    //     // if(bindingResult.hasErrors()) 
    //     //     return "login";

    //     // 로그인 성공 => 세션 생성

    //     // 세션을 생성하기 전에 기존의 세션 파기
    //     httpServletRequest.getSession().invalidate();
    //     HttpSession session = httpServletRequest.getSession(true);  // Session이 없으면 생성
    //     // 세션에 userId를 넣어줌
    //     session.setAttribute("userId", user);
    //     // session.setMaxInactiveInterval(1800); // Session이 30분동안 유지

    //     return "redirect:/session-login";
    // }

    // @GetMapping("/logout")
    // public String logout(HttpServletRequest request, Model model) {

    //     HttpSession session = request.getSession(false);  // Session이 없으면 null return
    //     if(session != null) 
    //         session.invalidate();
    //     return "redirect:/session-login";
    // }

}
