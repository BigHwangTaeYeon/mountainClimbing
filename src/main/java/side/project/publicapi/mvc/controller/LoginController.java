package side.project.publicapi.mvc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;;

@RequestMapping("/login")
@Controller
public class LoginController {
    
    @RequestMapping("/connectId")
    public String connect() {
        return "/login/ConnectId";
    }
    
    @RequestMapping("/createId")
    public String createId() {
        return "/login/CreateId";
    }
    
}
