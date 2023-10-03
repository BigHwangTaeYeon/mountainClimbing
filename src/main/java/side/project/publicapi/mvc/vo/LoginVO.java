package side.project.publicapi.mvc.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginVO {
    private String id;
    private String pw;
    private String email;
    private String user_role;
}
