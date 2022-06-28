## 1차

1. 품질데이터 관리 운영
  * MariaDB와 접속 TEST(완료)
  * 영화데이터 구성
      - 데이터 구성 대상 항목 검토(진행)
      - 스키마 정의 (완료)

2. 개발환경 셋팅
  * STS 4
    - STS 3 현재 이클립스EE 최신버전(ver.4.24)과 호환오류 이슈로 인해 STS 4로 변경
  * MariaDB
    - 1.8
  * WorkBench
    - 8.0CE
---

## 2차
### REST
REST란 자원 이름으로 구분하여 해당 자원의 상태를 주고 받는 모든것을 말한다.   
> 즉, 표현에 의한 상태전달

HTTP URI를 통해 리소스를 명시하고, HTTP 메소드(get, post, delete)를 통해 해당 자원에대한 CRUD를 적용하는것을 의미한다.

* Create: post
* Read: get
* Update: put
* Delete: delete

URI와 위에 명시한 HTTP 메소드를 이용하여 객체화된 서비스에 접근하는 것이다.   

cf) URI, URL   
* URI
> 특정 리소스를 식별하는 통합자원 식별자.
> 웹 기술에서 사용하는 논리적 또는 물리적 리소스를 식별하는 고유한 문자열 시퀀스

* URL
> 웹주소라고하며, 네트워크 상에서 리소스가 어디있는지 알려주기 위한 규약

URI는 식별하고, URL는 위치를 가르킨다.   

### REST의 특징
|항목|내용|
|:---|:---|
|server-client|REST 서버는 API를 제공하고, 비즈니스 로직을 처리및 저장을 하고, client는 사용자 인증이나 세션, 로그인정보 등을 직접 관리하고 책임진다.|
|Statelss|직관적인 오브젝트의 접근으로 서비스를 처리. 세션정보를 보관할 필요가 없다.|
|Cacheable|HTTP프로토콜을 그대로 사용하므로 기존 인프라 그대로 활용. 캐시를 사용하여 응답이 빠르다.|
|LayeredSystem|Client는 REST API 서버만 호출한다. REST 서버는 다중 계층으로 구성|
|Addressability|REST는 모든 유일한 object에대해 유일하고 직관적인 URI를 통해 접근하도록 한다. 웹사이트의 임지, 텍스트, DB 내용 등의 모든 자원에 고유한 ID인 HTTP URI를 부여|
