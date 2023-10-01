package side.project.publicapi.mvc.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginVO {
    private String id;
    private String pw;
    private String email;

    //Efective java Builder
    public static class Builder{
        private String id;
        private String pw = "";
        private String email = "";

        public Builder(String id){
            this.id = id;
        }
        public Builder pw(String val)
            {pw = val; return this;}
        public Builder email(String val)
            {email = val; return this;}
        public LoginVO build() {
            return new LoginVO(this);
        }
    }
    private LoginVO (Builder builder){
        id = builder.id;
        pw = builder.pw;
        email = builder.email;
    }
    public LoginVO() {
    }
}
