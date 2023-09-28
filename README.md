# mountainClimbing


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
