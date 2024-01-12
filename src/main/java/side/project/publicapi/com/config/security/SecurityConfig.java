package side.project.publicapi.com.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import side.project.publicapi.com.config.ApplicationContextProvider;
import side.project.publicapi.mvc.serviceImpl.SecurityLoginServiceImpl;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    //https://velog.io/@woosim34/Spring-Spring-Security-%EC%84%A4%EC%A0%95-%EB%B0%8F-%EA%B5%AC%ED%98%84SessionSpring-boot3.0-%EC%9D%B4%EC%83%81
    SecurityLoginServiceImpl securityLoginServiceImpl = (SecurityLoginServiceImpl) ApplicationContextProvider.getApplicationContext().getBean(SecurityLoginServiceImpl.class);

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .csrf((csrfConfig) ->
                        csrfConfig.disable()
                ) // 1번
                .headers((headerConfig) ->
                        headerConfig.frameOptions(frameOptionsConfig ->
                                frameOptionsConfig.disable()
                        )
                )// 2번
                .authorizeHttpRequests((authorizeRequests) ->
                        authorizeRequests
//                                .requestMatchers(PathRequest.toH2Console()).permitAll()
                                .requestMatchers("/", "/login/**").permitAll()
                                .anyRequest().authenticated()
                )// 3번
//                .exceptionHandling((exceptionConfig) ->
//                        exceptionConfig.authenticationEntryPoint(unauthorizedEntryPoint).accessDeniedHandler(accessDeniedHandler)
//                ); // 401 403 관련 예외처리
                .formLogin((formLogin) ->
                formLogin
                        .loginPage("/login/view/login")
                        .usernameParameter("id")
                        .passwordParameter("pw")
                        .loginProcessingUrl("/login/manage/signIn")
                        .defaultSuccessUrl("/", true)
        )
                .logout((logoutConfig) ->
                        logoutConfig.logoutSuccessUrl("/")
                )
                .userDetailsService(securityLoginServiceImpl);

        return http.build();
    }

//
//    private final OAuth2UserService oAuth2UserService;
//
//    public SecurityConfig(OAuth2UserService oAuth2UserService) {
//        this.oAuth2UserService = oAuth2UserService;
//    }
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        return http
//                .httpBasic().disable()
//                // .csrf().disable()
//                .cors().disable()
//                .authorizeHttpRequests(requests -> requests
//                        .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
//                        // .requestMatchers("/api/*").permitAll()  //test가 왜 안될까..
//                        .requestMatchers("/login/view/*").permitAll()
//                        // .requestMatchers("/css/login/**", "/js/login/**").permitAll()
//                        .requestMatchers(HttpMethod.POST, "/login/manage/*").permitAll()
//                    //    .requestMatchers(HttpMethod.GET,"/login").authenticated()
//                        .anyRequest().authenticated())
//                .formLogin(login -> login	// form 방식 로그인 사용
//                        .loginPage("/login/view/login")	// [A] 커스텀 로그인 페이지 지정
//                        .loginProcessingUrl("/login/manage/signIn")	// [B] submit 받을 url
//                        .usernameParameter("id")	// [C] submit할 아이디
//                        .passwordParameter("pw")	// [D] submit할 비밀번호
//                        .defaultSuccessUrl("/api/culture", true)	// 성공 시 dashboard로
//                        .permitAll()	// 대시보드 이동이 막히면 안되므로 얘는 허용
//                )
//                // .logout()
//                //     .logoutUrl("/login/manage/logout") // 로그아웃 처리 URL, default: /logout, 원칙적으로 post 방식만 지원
//                //     .logoutSuccessUrl("/api/culture/Culture") // 로그아웃 성공 후 이동페이지
//                //     .deleteCookies("JSESSIONID", "remember-me") // 로그아웃 후 쿠키 삭제
//                .getOrBuild();
//// .requestMatchers("/status", "/images/**").permitAll()
////    - "/images/**"은 static 폴더에 있는 이미지 파일입니다! 로그인 화면에 이미지 하나 정도는 있어야 이쁠 것 같은데 그것조차 인증에 막혀있었으니 인증 안되도 통과되게 해줍시다.
//    }
//
//    // @Bean
//    // public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//    //     http.csrf().disable();
//    //     http.authorizeHttpRequests(config -> config.anyRequest().permitAll());
//    //     http.oauth2Login(oauth2Configurer -> oauth2Configurer
//    //                     .loginPage("/login")
//    //                     .successHandler(successHandler())
//    //                     .userInfoEndpoint()
//    //                     .userService(oAuth2UserService));
//
//    //     return http.build();
//    // }
//
//    // @Bean
//    // public AuthenticationSuccessHandler successHandler() {
//    //     return ((request, response, authentication) -> {
//    //         DefaultOAuth2User defaultOAuth2User = (DefaultOAuth2User) authentication.getPrincipal();
//
//    //         String id = defaultOAuth2User.getAttributes().get("id").toString();
//    //         String body = """
//    //                 {"id":"%s"}
//    //                 """.formatted(id);
//
//    //         response.setContentType(MediaType.APPLICATION_JSON_VALUE);
//    //         response.setCharacterEncoding(StandardCharsets.UTF_8.name());
//
//    //         PrintWriter writer = response.getWriter();
//    //         writer.println(body);
//    //         writer.flush();
//    //     });
    // }

}