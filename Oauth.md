# 231007
https://adjh54.tistory.com/221

💡 OAuth(Open Authorization)
- 인터넷 사용자들이 특정 웹 사이트를 접근하고자 할 때 '접근하려는 웹 사이트에 비밀번호를 제공하지 않고' 
- 서드파티 애플리케이션(구글, 카카오, 페이스북 등)의 연결을 통해 '인증 및 권한'을 부여받을 수 있는 프로토콜을 의미합니다.

비교 분류	        OAuth 1.0a 	            OAuth 2.0

출시일	            2007	                2012
프로토콜	        Request/Token	        Authorization/Token
토큰 유형	        한 번만 사용 가능	     다중 사용 가능
토큰 지속 기간	    폐기되기 전까지	         구성된 기간
토큰 갱신	        없음	                리프레시 토큰
서명 방법	        HMAC-SHA1	            다중 옵션
SSL 필수 여부	    아니오	                예
클라이언트  인증	서명	                다중 옵션
부여 유형	        없음	                다중 옵션
모바일 지원	        낮음	                높음
보안	            적은 보호 기능	        더 많은 보호 기능

- OAuth 1.0은 2007년 릴리즈 되었고 OAuth 1.0a는 2010년에 릴리즈 되었습니다.

💡 Spring Boot OAuth 2 Client 란?
- Spring Boot 프레임워크에서 OAuth 2.0 프로토콜을 사용하여 인증을 수행하는 클라이언트입니다.
- OAuth 2.0 프로토콜을 사용하여 인증하는 클라이언트를 구현하는 데 필요한 기능을 제공합니다. 
- 이를 통해 서비스 제공자의 API를 사용하고 인증된 사용자 정보를 가져올 수 있습니다.

💡 Spring Boot OAuth 2 Client와 Spring Boot OAuth 2 Server의 차이는 무엇인가?
- Spring Boot OAuth 2 Client는 ‘OAuth 2.0 서비스에 대한 인증을 처리하기 위한 모듈’이고 
- Spring Boot OAuth 2 Server는 ‘OAuth 2.0 서버를 빠르게 구축하기 위한 모듈’입니다.

- Spring Boot OAuth 2 Client는 ‘외부 OAuth 2.0 서비스에 대한 인증을 처리하기 위한 모듈'입니다. 
    이 모듈을 사용하면 간단한 설정만으로 OAuth 2.0 프로토콜을 따르는 서비스의 인증을 처리할 수 있습니다.
- Spring Boot OAuth 2 Server는 OAuth 2.0 '서버를 빠르게 구축할 수 있도록 지원하는 모듈'입니다. 
    이 모듈을 사용하면 간단한 설정만으로 OAuth 2.0 프로토콜을 따르는 서버를 구축할 수 있습니다.

사용자 / 리소스 소유자(User / Resource Owner)	   
    - 인증을 담당하고 클라이언트와 리소스 공유에 대한 동의를 제공하는 최종 사용자를 의미합니다.
사용자 에이전트(User-Agent)	                       
    - 사용자가 사용하는 브라우저를 의미합니다.
클라이언트(Client)	                               
    - 액세스 토큰을 요청하는 애플리케이션을 의미합니다.
인증 서버(Authorization Server)	                   
    - 사용자/클라이언트를 인증하는 데 사용되는 서버입니다. 액세스 토큰을 발행하고 평생 동안 추적합니다.
리소스 서버 (Resource Server)	                   
    - 요청된 리소스에 대한 액세스를 제공하는 API입니다. 액세스 토큰의 유효성을 검사하고 인증을 제공합니다. ex) 카카오, 네이버, 구글, ...

제공자 (Provider)               
    - 사용자가 로그인하려는 서비스(예: Naver, Kakao, Google, Facebook, GitHub)를 의미합니다.
    - Provider는 OAuth 2.0 프로토콜을 사용하여 사용자 인증 및 권한 부여를 처리합니다.
인가 코드 (Authorization Code)	
    - 사용자에게 인가를 받기 위한 중요한 단계 중 하나로 클라이언트가 애플리케이션에 대한 ‘권한 요청’으로 Provider에게 요청하여 반환되는 코드를 의미합니다.
    - 인가 코드의 발급 과정은 Client는 Provider에게 애플리케이션에 대한 권한 요청 → Provider는 승인 후 애플리케이션에게 인가 코드 반환
접근 토큰 (Access Token)	    
    - 사전에 발급 받은 인가 코드를 기반으로 클라이언트에게 발급되는 토큰을 의미합니다. 
    - 접근 토큰의 발급 과정은 Client는 사전에 발급 받은 인가 코드를 기반 요청 → Provider는 승인 후 Client에게 접근 토큰을 발급 해줍니다.
    - 접근 토큰은 제한된 시간동안 유효하며 만료된 클라이언트는 새로운 접근 토큰을 요청해야합니다.

OAuth 2 Client 기본 동작 원리
💡 사용자가 특정 웹 사이트에 로그인하고 싶다고 가정을 하며 사용자는 서드파티 애플리케이션(Facebook, Github, Google, Microsoft)을 통해 로그인할 수 있습니다.
1. User enters credentials: 사용자는 서드파티 애플리케이션을 선택하면 로그인을 위해 해당 웹 사이트로 리다이렉션 됩니다.
    (User → Client)
2. Client passes credentials and its identification to authiorization server. Authiorization Server validates the information and returns an access token.: 
    로그인에 성공하면 특정 웹사이트에서 요청한 특정 데이터에 대한 액세스 권한을 부여할지 묻는 메시지가 표시되며 원하는 옵션을 선택하고 
    인증 코드 또는 오류 코드와 함께 특정 사이트로 리다이렉션 됩니다.
    (Client ↔ Authorization Server)
3. The Client uses access token to access resource server: 타사 리소스의 작업에 따라 로그인이 성공하거나 실패합니다.
    (Client ↔ Resource Server)

![img](https://blog.kakaocdn.net/dn/43Hog/btsmRn7ySFC/YViQ4kDz3nAC2DA8X1gRDk/img.png)

주요 기능
OAuth 2.0 프로토콜 인증
    - OAuth 2.0 프로토콜을 사용하여 인증 처리 가능
다양한 OAuth 2.0 제공 업체와 통합
    - 다양한 OAuth 2.0 제공 업체와 통합 가능
OAuth 2.0 인증 토큰 관리
    - OAuth 2.0 인증 토큰을 관리 가능
사용자 정보 가져오기
    - OAuth 2.0 인증을 통해 인증된 사용자 정보를 가져올 수 있음

주요 특징
간편한 설정	
    - Spring Boot의 자동 설정 기능을 사용하여 OAuth 2 클라이언트를 빠르게 설정할 수 있습니다.
다양한 인증 공급자 지원	
    - Google, Facebook, GitHub, Okta, OAuth2를 지원하는 많은 인증 공급자를 지원합니다.
커스터마이징 가능	
    - 인증 공급자의 설정을 커스터마이징하거나, 새로운 인증 공급자를 추가하여 사용할 수 있습니다.
보안	
    - Spring Security를 사용하여 인증과 권한 부여를 처리합니다.


- Spring Boot OAuth 2 Client 인증방식

Password Grant	
    - 클라이언트는 사용자의 아이디와 패스워드를 사용하여 액세스 토큰을 요청합니다. 이 그랜트 타입은 특정 상황에서만 사용됩니다.
Client Credentials Grant	
    - 클라이언트 애플리케이션은 자신의 이름과 패스워드를 사용하여 액세스 토큰을 요청합니다. 이 그랜트 타입은 클라이언트 애플리케이션 인증에 사용됩니다.
Authorization Code Grant	
    - 클라이언트는 권한 부여 서버에서 권한 부여 코드를 요청하고, 이를 액세스 토큰으로 교환합니다. 
    - 이 그랜트 타입은 사용자의 리소스에 액세스해야 하는 웹 서버 애플리케이션에서 일반적으로 사용됩니다.
Implicit Grant	
    - 클라이언트는 권한 부여 코드를 먼저 요청하는 대신, 직접 액세스 토큰을 요청합니다. 이 그랜트 타입은 보안 취약점 때문에 권장되지 않습니다.
Refresh Token Grant	
    - 클라이언트는 리프레시 토큰을 사용하여 새로운 액세스 토큰을 요청할 수 있습니다. 이 그랜트 타입은 사용자가 재인증하지 않고 새로운 액세스 토큰을 얻기 위해 일반적으로 사용됩니다.
JWT Grant	
    - 클라이언트는 JSON Web Token (JWT)을 어설션으로 사용하여 액세스 토큰을 요청합니다. 이 그랜트 타입은 단일 로그인 (SSO) 시나리오에서 일반적으로 사용됩니다.
SAML Extension Grant	
    - 클라이언트는 보안 어설션 마크업 언어 (SAML) 어설션을 사용하여 액세스 토큰을 요청합니다. 이 그랜트 타입도 SSO 시나리오에서 일반적으로 사용됩니다.
Kerberos OAuth2 Grant	
    - 클라이언트는 Kerberos 티켓을 어설션으로 사용하여 액세스 토큰을 요청합니다. 이 그랜트 타입은 Windows 환경에서 일반적으로 사용됩니다.
NTLM 그랜트	
    - 클라이언트는 Windows NT LAN Manager (NTLM) 인증 메시지를 사용하여 액세스 토큰을 요청합니다. 이 그랜트 타입도 Windows 환경에서 일반적으로 사용됩니다.

💡 다양한 인증을 위한 승인방식들이 많이 있습니다. 이중에 가장 대중적이고 많이 사용되는 방식은 ‘Authorization Code Grant’입니다.
권한 코드 승인 방식 (Authorization Code Grant)
- 클라이언트가 사용자 인증을 받기 위해 인가 서버(Authorization Server)에 인증 코드를 요청하고 이를 이용하여 액세스 토큰(Access Token)을 발급받는 과정을 말합니다.

동작과정
1. Access Application: 사용자는 앱에 접근하여 인증 및 권한 부여를 트리거합니다.
2. Authentication and Request Authorization: 앱은 사용자를 인증 서버로 리디렉션 하고, 사용자의 아이디와 비밀번호를 요청합니다. 
    이 과정에서, 사용자에게 처음으로 앱에 대한 권한 부여 페이지가 표시됩니다. 이 페이지에서 사용자는 앱이 사용자의 리소스에 접근하기 위한 권한을 선택할 수 있습니다.
3. Authentication and Grant Authorization: 클라이언트는 사용자를 인증하기 위해 Authorization Server에 인증 코드를 요청합니다.
4. Send Authorization Code: 사용자는 Authorization Server에 로그인하여 인증 코드를 받습니다.
5. Request Code Exchange for Token: 클라이언트는 Authorization Server에 액세스 토큰을 요청하고, 인증 코드와 함께 전송합니다.
6. Issue Access Token: Authorization Server는 유효한 인증 코드인지 확인하고, 액세스 토큰을 발급합니다.
7. Request Resource w/ Access Token: 클라이언트는 액세스 토큰을 이용하여 리소스 서버(Resource Server)에서 사용자 정보 등의 리소스에 접근합니다.
8. Return Resource: 액세스 토큰이 유효한 경우, 리소스 서버는 앱이 요청한 리소스를 반환합니다.

![img](https://blog.kakaocdn.net/dn/GqkYb/btsmPFU85mX/bNlK9yUnxoy8B4vi90iKY1/img.png)

💡 인증 서버(Authorization Server)
- OAuth2 프로토콜에서 인증과 권한 부여를 담당하는 서버입니다. 
    클라이언트는 사용자의 권한을 인증 서버에 요청하고 인증 서버는 사용자의 동의를 얻어 액세스 토큰을 발급합니다.
    이 액세스 토큰은 리소스 서버에서 사용자의 데이터를 가져오기 위한 권한 부여에 사용됩니다.

💡 리소스 서버(Resource Server)
- OAuth2 프로토콜에서 인증 서버로부터 발급받은 액세스 토큰을 사용하여 보호된 리소스에 대한 클라이언트의 요청을 인가하고 응답하는 서버입니다. 
    보호된 리소스는 사용자 정보와 같은 중요한 데이터를 포함할 수 있습니다.

💡 암시적 승인 방식 (Implicit Grant)
- 클라이언트 애플리케이션이 Access Token을 직접 발급받는 것이 아니라 사용자 에이전트(웹 브라우저 등)를 통해 인가 과정을 거쳐 Access Token을 발급받는 방식을 의미합니다.
- Authorization Code Grant와는 달리 Access Token을 직접 발급받기 때문에 Access Token이 노출될 위험은 있습니다. 따라서 이 방식은 보안적인 취약점이 있으므로 권장되지 않습니다.

    보안적인 취약점이 발생되는 이유
    1. Access Token이 노출될 가능성이 높습니다.
        - 클라이언트 애플리케이션에서는 JavaScript를 통해 URL Fragment를 읽을 수 있습니다. 이 경우, 악의적인 공격자가 JavaScript를 이용하여 Access Token을 탈취할 수 있습니다.
    2. Access Token의 수명이 무제한입니다.
        - 암시적 승인 방식에서는 Access Token의 수명을 제어할 수 없습니다. Access Token은 사용자가 로그아웃하거나, 일정 기간이 지나기 전에는 만료되지 않습니다. 이는 Access Token이 탈취될 경우, 악의적인 공격자가 계속해서 해당 Access Token을 사용할 수 있다는 것을 의미합니다.
    3. Access Token이 제한적인 범위로 사용되지 않을 수 있습니다.
        - Access Token의 범위(scope)를 제어할 수 없습니다. 따라서, 클라이언트 애플리케이션에서는 Access Token을 원하는 대로 사용할 수 있습니다. 이는 권한이 없는 데이터에 접근할 수 있다는 것을 의미합니다.
    4. Access Token이 클라이언트 시크릿 없이 발급됩니다.
        - 클라이언트 시크릿을 사용하지 않습니다. 따라서, 클라이언트 애플리케이션이 Access Token을 발급받는 것을 막을 수 없습니다. 이는 악의적인 공격자가 클라이언트 애플리케이션을 통해 Access Token을 발급받을 수 있다는 것을 의미합니다.

    동작과정
    1. Access client application: 클라이언트는 클라이언트 ID와 허가 유형 및 기타 선택적 매개 변수를 사용하여 액세스 토큰을 요청합니다.
    2. User authorization request: 리소스 소유자가 권한 부여 서버와 직접 인증하므로 해당 자격 증명은 클라이언트와 공유되지 않습니다.
    3. User authorizaties and authorizes the application: 권한 부여 서버는 URI 조각을 통해 액세스 토큰을 클라이언트로 보냅니다.
    4. Redirect URL with access token in fragment: 클라이언트는 조각에서 토큰을 추출하고 액세스 토큰과 함께 API 요청을 리소스 서버로 보냅니다.

💡 클라이언트 자격 증명 방식 (Client Credentials Grant)
- 클라이언트 애플리케이션이 자신의 이름과 비밀번호를 사용하여 Access Token을 직접 발급받는 방법입니다. 이 방식은 클라이언트 애플리케이션 자체의 인증에 사용됩니다.

💡 클라이언트 자격 증명 방식 (Client Credentials Grant) 동작과정
1. Client authentication: 클라이언트 응용 프로그램은 권한 부여 서버에서 액세스 토큰을 요청하고 클라이언트 키와 클라이언트 암호로 요청을 인증합니다.
2. Access Token: 클라이언트가 성공적으로 인증되면 액세스 토큰이 반환됩니다.

💡 비밀번호 자격증명 방식(Password Credentials Grant)
- 클라이언트가 사용자의 이름과 비밀번호를 직접 사용하여 Access Token을 요청하는 방법입니다. 이 방식은 특정 상황에서만 사용됩니다.

💡 비밀번호 자격증명 방식(Password Credentials Grant) 동작과정
1. Authenticate with credentials: 사용자는 클라이언트 자체에서 사용자에게 리소스 소유자의 사용자 이름과 암호를 묻습니다.
2. Access token request: 클라이언트는 자격 증명을 클라이언트 자신의 자격 증명과 함께 권한 서버로 보냅니다.
3. Access token: 권한 서버는 토큰을 발급해 줍니다.

