package side.project.publicapi.com.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .httpBasic().disable()
                .csrf().disable()
                .cors().and()
                .authorizeHttpRequests(requests -> requests
                        .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
                        .requestMatchers("/login/view/*").permitAll()
                        .requestMatchers("/css/login/**", "/js/login/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/login/manage/*").permitAll()
                    //    .requestMatchers(HttpMethod.GET,"/login").authenticated()
                        .anyRequest().authenticated())
                .formLogin(login -> login	// form 방식 로그인 사용
                        .loginPage("/login/view/login")	// [A] 커스텀 로그인 페이지 지정
                        .loginProcessingUrl("/login/manage/signIn")	// [B] submit 받을 url
                        .usernameParameter("id")	// [C] submit할 아이디
                        .passwordParameter("pw")	// [D] submit할 비밀번호
                        .defaultSuccessUrl("/culture/culture", true)	// 성공 시 dashboard로
                        .permitAll()	// 대시보드 이동이 막히면 안되므로 얘는 허용
                )
                .logout(withDefaults());
               .getOrBuild();

// .requestMatchers("/status", "/images/**").permitAll()
//    - "/images/**"은 static 폴더에 있는 이미지 파일입니다! 로그인 화면에 이미지 하나 정도는 있어야 이쁠 것 같은데 그것조차 인증에 막혀있었으니 인증 안되도 통과되게 해줍시다.
    }
}