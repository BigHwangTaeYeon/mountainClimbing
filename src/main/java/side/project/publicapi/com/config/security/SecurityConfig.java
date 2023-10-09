package side.project.publicapi.com.config.security;

import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
    private final OAuth2UserService oAuth2UserService;
 
    public SecurityConfig(OAuth2UserService oAuth2UserService) {
        this.oAuth2UserService = oAuth2UserService;
    }

//     @Bean
//     public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//         return http
//                 .httpBasic().disable()
//                 .csrf().disable()   
//                 .cors().disable()
//                 .authorizeHttpRequests(requests -> requests
//                         .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
//                         // .requestMatchers("/api/*").permitAll()  //test가 왜 안될까..
//                         .requestMatchers("/login/view/*").permitAll()
//                         // .requestMatchers("/css/login/**", "/js/login/**").permitAll()
//                         .requestMatchers(HttpMethod.POST, "/login/manage/*").permitAll()
//                     //    .requestMatchers(HttpMethod.GET,"/login").authenticated()
//                         .anyRequest().authenticated())
//                 .formLogin(login -> login	// form 방식 로그인 사용
//                         .loginPage("/login/view/login")	// [A] 커스텀 로그인 페이지 지정
//                         .loginProcessingUrl("/login/manage/signIn")	// [B] submit 받을 url
//                         .usernameParameter("id")	// [C] submit할 아이디
//                         .passwordParameter("pw")	// [D] submit할 비밀번호
//                         .defaultSuccessUrl("/api/culture", true)	// 성공 시 dashboard로
//                         .permitAll()	// 대시보드 이동이 막히면 안되므로 얘는 허용
//                 )
//                 // .logout()
//                 //     .logoutUrl("/login/manage/logout") // 로그아웃 처리 URL, default: /logout, 원칙적으로 post 방식만 지원
//                 //     .logoutSuccessUrl("/api/culture/Culture") // 로그아웃 성공 후 이동페이지
//                 //     .deleteCookies("JSESSIONID", "remember-me") // 로그아웃 후 쿠키 삭제
//                 .getOrBuild();
// // .requestMatchers("/status", "/images/**").permitAll()
// //    - "/images/**"은 static 폴더에 있는 이미지 파일입니다! 로그인 화면에 이미지 하나 정도는 있어야 이쁠 것 같은데 그것조차 인증에 막혀있었으니 인증 안되도 통과되게 해줍시다.
//     }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeHttpRequests(config -> config.anyRequest().permitAll());
        http.oauth2Login(oauth2Configurer -> oauth2Configurer
                        .loginPage("/login")
                        .successHandler(successHandler())
                        .userInfoEndpoint()
                        .userService(oAuth2UserService));
 
        return http.build();
    }
 
    @Bean
    public AuthenticationSuccessHandler successHandler() {
        return ((request, response, authentication) -> {
            DefaultOAuth2User defaultOAuth2User = (DefaultOAuth2User) authentication.getPrincipal();
 
            String id = defaultOAuth2User.getAttributes().get("id").toString();
            String body = """
                    {"id":"%s"}
                    """.formatted(id);
 
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            response.setCharacterEncoding(StandardCharsets.UTF_8.name());
 
            PrintWriter writer = response.getWriter();
            writer.println(body);
            writer.flush();
        });
    }

}