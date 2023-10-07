# mountainClimbing

[Oauth 2.0](#Oauth-231007)

[Security](#Security)

# 20230919
api 내용 등산 > 문화예술공연으로 변경

//문화체육관광부_문화예술공연(통합)
//문화체육관광부 대표 누리집의 '문화예술공연' 게시판 및 문화포털(https://www.culture.go.kr/)에 등록된 게시글을 연계하여 제공하는 공연전시 프로그램 정보로 연극, 뮤지컬, 오페라, 음악, 콘서트, 국악, 무용, 전시, 기타 등 각 분야의 문화예술공연 목록 정보를 통합 제공하고 있습니다.
//https://www.culture.go.kr/data/openapi/openapiView.do?id=580

# 20230920
회사 gradle version
distributionBase=GRADLE_USER_HOME
distributionPath=wrapper/dists
distributionUrl=https\://services.gradle.org/distributions/gradle-8.2.1-bin.zip
networkTimeout=10000
validateDistributionUrl=true
zipStoreBase=GRADLE_USER_HOME
zipStorePath=wrapper/dists

# 230923
노트북 gradle version
distributionBase=GRADLE_USER_HOME
distributionPath=wrapper/dists
distributionUrl=https\://services.gradle.org/distributions/gradle-8.2.1-bin.zip
networkTimeout=10000
validateDistributionUrl=true
zipStoreBase=GRADLE_USER_HOME
zipStorePath=wrapper/dists

# 230924
CREATE TABLE CULTURE_API {
      PSEQ            NUMBER(10)        NOT NULL    PRIMARY KEY     COMMENT '컨텐츠PK'
    , TITLE           VARCHAR2(100)                                 COMMENT '제목'
    , PERIOD          VARCHAR(100)                                  COMMENT '기간'
    , EVENTPERIOD     VARCHAR(100)                                  COMMENT '시간'
    , EVENTSITE       VARCHAR(100)                                  COMMENT '장소'
    , CHARGE          VARCHAR(100)                                  COMMENT '금액'
    , CONTACTPOINT    VARCHAR2(100)                                 COMMENT '문의안내'
    , URL             VARCHAR(1000)                                 COMMENT 'URL'
    , IMAGEOBJECT     VARCHAR(100)                                  COMMENT '이미지(썸네일)'
    , DESCRIPTION     VARCHAR2(100000)                              COMMENT '설명'
    , VIEWCOUNT       VARCHAR(1000)                                 COMMENT '조회수'
    , REGDATE         DATE                                          COMMENT '등록일자'
}

# 230926
날씨 API
기상청_중기예보 조회서비스
https://www.data.go.kr/data/15059468/openapi.do
key = wvclTcKfaznWPJW5f137YCcDLJ41ee+6his8ede7mYo6xCNwf1isheXbQpXzRKN6IX7v7ilYRbYzPAEkM0Bl0Q==
6시 18시 일 2회 조회
마이페이지 > 데이터활용 > OpenAPI > 활용신청현황
https://apis.data.go.kr/1360000/MidFcstInfoService/getMidLandFcst
?serviceKey=wvclTcKfaznWPJW5f137YCcDLJ41ee%2B6his8ede7mYo6xCNwf1isheXbQpXzRKN6IX7v7ilYRbYzPAEkM0Bl0Q%3D%3D&pageNo=1&numOfRows=10&dataType=JSON&regId=11B00000&tmFc=202309260600

# 230928
노트북
{
    // Use IntelliSense to learn about possible attributes.
    // Hover to view descriptions of existing attributes.
    // For more information, visit: https://go.microsoft.com/fwlink/?linkid=830387
    "version": "0.2.0",
    "configurations": [
        {
            "type": "java",
            "name": "Current File",
            "request": "launch",
            "mainClass": "${file}"
        },
        {
            "type": "java",
            "name": "PublicapiApplication",
            "request": "launch",
            "mainClass": "side.project.publicapi.PublicapiApplication",
            "projectName": "publicapi"
        }
    ]
}

CREATE TABLE CULTURE_API (
      PSEQ            NUMBER(10)        NOT NULL    PRIMARY KEY 
    , TITLE           VARCHAR2(100)                              
    , PERIOD          VARCHAR(100)                               
    , EVENTPERIOD     VARCHAR(100)                                 
    , EVENTSITE       VARCHAR(100)                                
    , CHARGE          VARCHAR(100)                                 
    , CONTACTPOINT    VARCHAR2(100)                               
    , URL             VARCHAR(1000)                                
    , IMAGEOBJECT     VARCHAR(100)                              
    , DESCRIPTION     VARCHAR2(1000)                           
    , VIEWCOUNT       VARCHAR(1000)                               
    , REGDATE         DATE                                        
)
;

COMMENT ON TABLE CULTURE_API IS '문화API';
COMMENT ON COLUMN CULTURE_API.PSEQ IS '컨텐츠PK';
COMMENT ON COLUMN CULTURE_API.TITLE IS '제목';
COMMENT ON COLUMN CULTURE_API.PERIOD IS '기간';
COMMENT ON COLUMN CULTURE_API.EVENTPERIOD IS '시간';
COMMENT ON COLUMN CULTURE_API.EVENTSITE IS '장소';
COMMENT ON COLUMN CULTURE_API.CHARGE IS '금액';
COMMENT ON COLUMN CULTURE_API.CONTACTPOINT IS '문의안내';
COMMENT ON COLUMN CULTURE_API.URL IS 'URL';
COMMENT ON COLUMN CULTURE_API.IMAGEOBJECT IS '이미지(썸네일)';
COMMENT ON COLUMN CULTURE_API.DESCRIPTION IS '설명';
COMMENT ON COLUMN CULTURE_API.VIEWCOUNT IS '조회수';
COMMENT ON COLUMN CULTURE_API.REGDATE IS '등록일자';

# 230929
ORACLE 3개월마다 비밀번호 변경 해야함.
아래 명령으로 만료가 되지 않도록 설정.
ALTER PROFILE DEFAULT LIMIT PASSWORD_LIFE_TIME UNLIMITED;

# 230930
API TABLE 수정
CREATE TABLE CULTURE_API (
      PSEQ            NUMBER(10)        NOT NULL    PRIMARY KEY 
    , TITLE           VARCHAR2(4000)                              
    , PERIOD          VARCHAR(100)                               
    , EVENTPERIOD     VARCHAR(100)                                 
    , EVENTSITE       VARCHAR(100)                                
    , CHARGE          VARCHAR(100)                                 
    , CONTACTPOINT    VARCHAR2(4000)                               
    , URL             VARCHAR(1000)                                
    , IMAGEOBJECT     VARCHAR(100)                              
    , DESCRIPTION     VARCHAR(4000)                           
    , VIEWCOUNT       VARCHAR(1000)                               
    , REGDATE         DATE                                        
)
;
(https://docs.spring.io/spring-data/elasticsearch/docs/current/reference/html/)
Spring 데이터 릴리스 트레인	/ 스프링 데이터 Elasticsearch	/ 엘라스틱서치	/ 스프링 프레임워크	/ 스프링 부트
2023.0 (울만)                   5.1.x                           8.7.1               6.0.x           3.1.x
2022.0(튜링)                    5.0.x                           8.5.3               6.0.x           3.0.x

version
elasticsearch-7.10.2
boot 3.0.x

JPA를 공부하지 않은 상태로 엘라스틱서치 연동이 힘들었다.
최대한 가벼운 설정으로 적용하였으며, JPA 공부 후 커스텀을 하는 것이 좋을 것 같다.
    implementation('org.elasticsearch.client:elasticsearch-rest-high-level-client:6.5.3')
    implementation('org.elasticsearch:elasticsearch:6.5.3')
	implementation('org.springframework.boot:spring-boot-starter-webflux')
Spring WebFlux는 Spring 5에서 새롭게 추가된 모듈이다.
WebFlux는 클라이언트, 서버에서 reactive 스타일의 어플리케이션 개발을 도와주는 모듈이며, 
reactive-stack web framework이며 non-blocking에 reactive stream을 지원합니다.

https://devuna.tistory.com/120
https://velog.io/@zenon8485/Reactor-Java-1.-Mono%EC%99%80-Flux%EB%A5%BC-%EC%83%9D%EC%84%B1%ED%95%98%EB%8A%94-%EB%B0%A9%EB%B2%95
기본 개념

# 231001
elastic search version & java version
https://www.elastic.co/kr/support/matrix#matrix_jvm

AES 암호화/복호화 사용
javax.crypto.Cipher 클래스는 암호화 알고리즘을 나타낸다.
암호를 사용하여 데이터를 암호화하거나 복호화할 수 있다.
아래와 같이 암호화 알고리즘, 운용 방식 그리고 패딩 방식을 전달해 Cipher 인스턴스를 만들 수 있다.
Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
https://aday7.tistory.com/entry/Java-AES-%EC%95%94%ED%98%B8%ED%99%94%EB%B3%B5%ED%98%B8%ED%99%94-%EC%98%88%EC%A0%9C-AES-256

# 231002
엘라스틱서치 7.10.2 맞추기 위해 open JDK 11로 세팅했다.
분명 문서에는 openJDK 1.8도 된다 하는데, 실행 시 11을 요구한다..

https://devhan.tistory.com/310#ViewController%20%EC%83%9D%EC%84%B1-1
스프링부트 3.X 스프링 시큐리티 사용해서 회원가입, 로그인, 로그아웃 구현하기
스프링에서 제공하는 시큐리티 기능을 많이 사용한다.
정리해서 보고 이해하는 것이 좋을 것 같다.

# 231003
시큐리티 재작업 
https://velog.io/@wooryung/Spring-Boot-Spring-Security%EB%A5%BC-%EC%A0%81%EC%9A%A9%ED%95%98%EC%97%AC-%EB%A1%9C%EA%B7%B8%EC%9D%B8-%ED%9A%8C%EC%9B%90%EA%B0%80%EC%9E%85-%EA%B5%AC%ED%98%84%ED%95%98%EA%B8%B0
시큐리티 보안 작동은 가능하나, 로그인 후 다른 페이지 이동 불가.
인가 문제인듯

# 231004
// UserDetailsService 인터페이스는 DB에서 유저 정보를 가져오는 역할을 한다.
https://nahwasa.com/entry/%EC%8A%A4%ED%94%84%EB%A7%81%EB%B6%80%ED%8A%B8-30%EC%9D%B4%EC%83%81-Spring-Security-%EA%B8%B0%EB%B3%B8-%EC%84%B8%ED%8C%85-%EC%8A%A4%ED%94%84%EB%A7%81-%EC%8B%9C%ED%81%90%EB%A6%AC%ED%8B%B0
스프링부트 3.0이상 Spring Security 기본 세팅 (스프링 시큐리티)
확실히 정리 잘 되어있다.

# 231006
// https://fvor001.tistory.com/123
WebSocket 프로그래밍은 실시간 채팅, 게임, 주식 시세 등 다양한 분야에서 활용된다.

# Oauth-231007
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

