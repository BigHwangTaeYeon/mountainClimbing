package side.project.publicapi.mvc.controller;

import org.elasticsearch.discovery.zen.MembershipAction.JoinRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import side.project.publicapi.mvc.service.LoginService;
import side.project.publicapi.mvc.vo.LoginVO;;

@Controller
@RequiredArgsConstructor
@RequestMapping("/login")
public class LoginController {
    
    LoginService loginService;
    
    @RequestMapping("/createId")
    public void createId (LoginVO vo) throws Exception{
        int check = loginService.loginCheck(vo);
        if(check == 0)
            loginService.loginInsert(vo);
    }

    @PostMapping("/login")
    public String login(BindingResult bindingResult, LoginVO vo, HttpServletRequest httpServletRequest, Model model) throws Exception {

        String user = loginService.getLoginId(vo);

        // 로그인 아이디나 비밀번호가 틀린 경우 global error return
        if(user == null) 
            bindingResult.reject("loginFail", "로그인 아이디 또는 비밀번호가 틀렸습니다.");

        if(bindingResult.hasErrors()) 
            return "login";

        // 로그인 성공 => 세션 생성

        // 세션을 생성하기 전에 기존의 세션 파기
        httpServletRequest.getSession().invalidate();
        HttpSession session = httpServletRequest.getSession(true);  // Session이 없으면 생성
        // 세션에 userId를 넣어줌
        session.setAttribute("userId", user);
        // session.setMaxInactiveInterval(1800); // Session이 30분동안 유지

        return "redirect:/session-login";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, Model model) {
        model.addAttribute("loginType", "session-login");
        model.addAttribute("pageName", "세션 로그인");

        HttpSession session = request.getSession(false);  // Session이 없으면 null return
        if(session != null) 
            session.invalidate();
        return "redirect:/session-login";
    }

}
