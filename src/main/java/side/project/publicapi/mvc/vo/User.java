package side.project.publicapi.mvc.vo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User {
    private String id;
    private String loginId;
    private String pw;
    private String email;
    private String role; //ROLE_USER, ROLE_ADMIN

    private String oauth_type;	//이메일

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getOauth_type() {
        return oauth_type;
    }

    public void setOauth_type(String oauth_type) {
        this.oauth_type = oauth_type;
    }
}