//package side.project.publicapi.mvc.service;
//
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
//import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
//import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
//import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
//import org.springframework.security.oauth2.core.user.OAuth2User;
//import org.springframework.stereotype.Service;
//
//import groovy.util.logging.Slf4j;
//import side.project.publicapi.mvc.serviceImpl.SecurityLoginServiceImpl;
//import side.project.publicapi.mvc.vo.User;
//
//@Slf4j
//@Service
//public class OAuth2UserService extends DefaultOAuth2UserService {
//
//	@Autowired SecurityLoginServiceImpl securityLoginServiceImpl;
//
//    @Override
//    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
//        OAuth2User oAuth2User = super.loadUser(userRequest);
//
//        // Role generate
//        List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("ROLE_ADMIN");
//
//        // nameAttributeKey
//        String userNameAttributeName = userRequest.getClientRegistration()
//                .getProviderDetails()
//                .getUserInfoEndpoint()
//                .getUserNameAttributeName();
//
//        // DB 저장로직이 필요하면 추가
//
//        return new DefaultOAuth2User(authorities, oAuth2User.getAttributes(), userNameAttributeName);
//    }
//
//	// @Override
//	// public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
//
//	// 	// email, oauthType 호출
//	// 	Map<String, Object> attributes = super.loadUser(userRequest).getAttributes();
//    //     System.out.println("ATTR INFO : {}" + attributes.toString());
//
//	// 	String email = null;
//	// 	String oauthType = userRequest.getClientRegistration().getRegistrationId();
//
//	// 	OAuth2User user2 = super.loadUser(userRequest);
//
//	// 	// oauth 타입에 따라 데이터가 다르기에 분기
//	// 	if("kakao".equals(oauthType.toLowerCase())) {
//	// 		// kakao는 kakao_account 내에 email이 존재함.
//	// 		email = ((Map<String, Object>) attributes.get("kakao_account")).get("email").toString();
//	// 	}
//	// 	else if("google".equals(oauthType.toLowerCase())) {
//	// 		email = attributes.get("email").toString();
//	// 	}
//	// 	else if("naver".equals(oauthType.toLowerCase())) {
//	// 		// naver는 response 내에 email이 존재함.
//	// 		email = ((Map<String, Object>) attributes.get("response")).get("email").toString();
//	// 	}
//
//	// 	// User 존재여부 확인 및 없으면 생성
//	// 	if(getUserByEmailAndOAuthType(email, oauthType) == null) {
//    //         System.out.println("{}({}) NOT EXISTS. REGISTER" + email + oauthType);
//	// 		User user = new User();
//	// 		user.setEmail(email);
//	// 		user.setOauth_type(oauthType);
//
//	// 		save(user);
//	// 	}
//
//	// 	return super.loadUser(userRequest);
//	// }
//
//	// 저장, 조회만 수행. 기타 예외처리 및 다양한 로직은 연습용이므로
//	public void save(User user) {
//		securityLoginServiceImpl.save(user);
//	}
//
//	public User getUserByEmailAndOAuthType(String email, String oauthType) {
//			User user = new User();
//			user.setEmail(email);
//			user.setOauth_type(oauthType);
//		return securityLoginServiceImpl.findByEmailAndOauthType(user).orElse(null);
//	}
//}