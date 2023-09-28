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
      PSEQ            NUMBER(10)        NOT NULL    PRIMARY KEY     COMMENT ''
    , TITLE           VARCHAR2(100)                                 COMMENT ''
    , PERIOD          VARCHAR(100)                                  COMMENT ''
    , EVENTPERIOD     VARCHAR(100)                                  COMMENT ''
    , EVENTSITE       VARCHAR(100)                                  COMMENT ''
    , CHARGE          VARCHAR(100)                                  COMMENT ''
    , CONTACTPOINT    VARCHAR2(100)                                 COMMENT ''
    , URL             VARCHAR(1000)                                 COMMENT ''
    , IMAGEOBJECT     VARCHAR(100)                                  COMMENT ''
    , DESCRIPTION     VARCHAR2(100000)                              COMMENT ''
    , VIEWCOUNT       VARCHAR(1000)                                 COMMENT ''
    , REGDATE         DATE
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