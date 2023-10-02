package side.project.publicapi.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import side.project.publicapi.mvc.service.LoginService;
import side.project.publicapi.mvc.vo.LoginVO;;

@Controller
@RequiredArgsConstructor
@RequestMapping("/login")
public class SecurityLoginController {
    
    @Autowired
    LoginService loginService;
    
    // ID 생성
    @RequestMapping("/createId")
    public String createId (LoginVO vo) throws Exception{
        int check = loginService.loginCheck(vo);
        if(check == 0)
            loginService.loginInsert(vo);
        // else
            // bindingResult.reject("createFail", "입력하신 아이디는 이미 사용되고 있습니다.");
        return "redirect:/login/CreateId";
    }
    
    // LOGIN 화면
    @RequestMapping("/login")
    public String loginAA (LoginVO vo) throws Exception{
        
        return "/login/success";
    }

    // LOGIN 인증 및 세션 부여
    @PostMapping("/loginA")
    public String login(LoginVO vo, HttpServletRequest httpServletRequest, Model model) throws Exception {

        String user = loginService.getLoginId(vo);

        // 로그인 아이디나 비밀번호가 틀린 경우 global error return
        if(user == null) 
            // bindingResult.reject("loginFail", "로그인 아이디 또는 비밀번호가 틀렸습니다.");

        // if(bindingResult.hasErrors()) 
        //     return "login";

        // 로그인 성공 => 세션 생성

        // 세션을 생성하기 전에 기존의 세션 파기
        httpServletRequest.getSession().invalidate();
        HttpSession session = httpServletRequest.getSession(true);  // Session이 없으면 생성
        // 세션에 userId를 넣어줌
        session.setAttribute("userId", user);
        // session.setMaxInactiveInterval(1800); // Session이 30분동안 유지

        return "redirect:/login/success";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response,
                SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/ConnectId";
    }
}