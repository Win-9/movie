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

[API정의서](https://github.com/Win-9/movie/blob/master/ApiGuide.docx)

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

### REST의 단점
1. 표준이 존재하지 않는다.
2. 사용할 수 있는 메소드가 get, post, put, delete 4가지만 존재
3. 형태가 제한적
4. 구형 브라우저가 지원하지 못하는 (put, delete, pushState)부분이 존재

그러나 다양한 클라이언트가 등장하거나, 여러 디바이스에서 통신 가능한 서버 프로그램이 필요하는 등
REST가 필요한 상황이 매우 많다.

### REST API
REST를 기반으로 서비스 API를 구현한 것을 REST API라고 한다.   
REST API는 사내 시스템들도 REST기반으로 시스템을 분산해 확장성과 재사용성을 높여 유지보수 및 운용을 편리하게 한다. 또한 HTTP 표준을 기반으로 구현하므로, HTTP를 지원하는 언어로 client, server를 구현할 수있다.   

이러한 REST API를 제공하는 웹 서비스를 RESTful하다고 한다.   
아래의 경우는 RESTful하지 못하다고 한다.
> CRUD기능을 모두 post로만 처리

> 라우트에 리소스, id외의 정보가 들어가는 경우 (/books/updateName)
---

### HTTP 
웹브라우저의 URL 을 통해 어느 웹사이트(도메인) 의 어느경로에 있는 페이지를 요청할지 나타내는 행위

#### Request
Request-Line은 URL정보, 요청방식(Method), HTTP버전정보제공 의 규칙을 나타낸다.
아래 그림에서는 Request URL, Request Method 를 나타내고 있다.
```
Request-Line
*(( general-header | request-header | entity-header ) CRLF)
CRLF
[ message-body ]
```

헤더에는 요청하는 클라이언트 PC, 브라우저정보, 사용자언어환경, 쿠키 등의 다양한 클라이언트 환경에 대한 정보를 가지고 있다.
HHTTP본문영역, 주로 클라이언크가 입력한 데이터를 저장하는 영역이다.
입력폼에 입력한 각종 데이터가 Method 방식에 따라 서버로 전달할 때 보안이 강화된 방식으로 message-body 에 넣어 전달

#### Response
HTTP Request 를 통해 요청된 정보에 대해 웹서버가 클라이언트에 보내는 응답형식 및 결과를 나타낸다.

```
Status-Line
*(( general-header | response-header | entity-header ) CRLF)
CRLF
[ message-body ]
```
Status-Line은 HTTP버전정보 와 세자리 숫자값(200) 과 상태코드 값을 통해 응답결과 및 상태정보를 나타낸다.

헤더는 각종 서버 및 웹사이트 관련 환경정보를 제공한다.

message-body는 HTTP본문영역으로서 주로 서버에서 사용자에게 전달되는 HTML 소스 및 포함된 데이터를 저장하는 영역이다.


1. 주소창에 URL을 입력후 엔터를 치면 URL을 해석하여 연결된 DNS서버로 이동하여 URL에 할당된 IP주소를 찾는다.
2. 정확한 좌표를 얻기 위하여 기기의 고유값은 MAC주소를 활용하여 이동하게된다. 여러 라우터를 거쳐서 호스트를 찾는데, 이때 동적 라우팅 프로토콜이 적용되어 라우팅 테이블에서 현재 경로를 따라 자동으로 경로를 조절한다. 여러 네트워크 기기를 중계해서 사용자에게 도착하는데 이때 MAC주소를 사용하여 목적지를 찾는다. 이때 ARP가 사용된다.
> ARP는 네트워크에서 IP주로를 MAC주소로 대응시키기 위해 사용되는 프로토콜

3. ARP는 수신지의 IP를 기준으로 MAC주소를 조사한다.
4. Client와 서버가 TCP 3 handShake를 거쳐 연결을 시도한다.
5. 클라이언트는 GET,POST 등으로 서버에 요청하면 서버는 그에맞는 데이터와 상태를 응답한다.
6. TCP종료를 위해 4 handShake를 거친다.

