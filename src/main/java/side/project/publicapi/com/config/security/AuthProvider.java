// package side.project.publicapi.com.config.security;

// import java.util.ArrayList;
// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.authentication.AuthenticationProvider;
// import org.springframework.security.authentication.BadCredentialsException;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.core.AuthenticationException;
// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.core.authority.SimpleGrantedAuthority;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.stereotype.Component;

// import side.project.publicapi.com.util.AesUtil;
// import side.project.publicapi.mvc.service.LoginService;
// import side.project.publicapi.mvc.vo.LoginVO;
// import side.project.publicapi.mvc.vo.User;
// @Component
// public class AuthProvider implements AuthenticationProvider {
//     @Autowired
//     private LoginService userService;

//     @Override
//     public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//         String id = (String) authentication.getPrincipal(); // 로그인 창에 입력한 email 
//         String password = (String) authentication.getCredentials(); // 로그인 창에 입력한 password
//         LoginVO vo = new LoginVO();
//         vo.setId(id);
//         vo.setPw(password);
//         UsernamePasswordAuthenticationToken token;
//         LoginVO userVo = userService.getLoginInfo(vo);
        
//         if (userVo != null && password == AesUtil.aesCBCDecode(userVo.getPw())) { // 일치하는 user 정보가 있는지 확인
//             List<GrantedAuthority> roles = new ArrayList<>();
//             roles.add(new SimpleGrantedAuthority("USER")); // 권한 부여

//             token = new UsernamePasswordAuthenticationToken(userVo.getId(), null, roles); 
//             // 인증된 user 정보를 담아 SecurityContextHolder에 저장되는 token

//             return token;
//         }

//         throw new BadCredentialsException("No such user or wrong password."); 
//         // Exception을 던지지 않고 다른 값을 반환하면 authenticate() 메서드는 정상적으로 실행된 것이므로 인증되지 않았다면 Exception을 throw 해야 한다.
//     }

//     @Override
//     public boolean supports(Class<?> authentication) {
//         return true;
//     }
// }