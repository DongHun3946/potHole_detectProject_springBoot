# 캡스톤디자인_포트홀 탐지 및 자동신고 시스템

## 👨‍🏫 프로젝트 소개
**일반국도 및 고속도로에서 자주 보이는 포트홀을 보다 쉽게 신고하고 보수하기 위한 시스템입니다.**<br/>

운전 중 발견되는 포트홀을 카메라가 탐지하면 당시의 위치(위도, 경도), 사진, 일자, 사용자정보를 자동으로 서버에 신고해주며 
서버(관리자)에서는 전송된 이미지와 사진 속 신뢰도를 기준으로 도로를 보수할 수 있도록 하기 위한 프로젝트입니다.

## ⏲️ 개발 기간
- 2024/09/01 ~ 2024/10/10
## 🧑‍🤝‍🧑 개발자 소개
- 최동훈, 이경민
## 💻 개발환경
- Version : Java 17
- IDE : IntelliJ
- Framework : SpringBoot 3.3.1
- ORM : JPA
## ⚙️ 기술 스택
- Server : Amazon EC2
- DataBase : Amazon RDS(mysql)
- WS/WAS : Tomcat
## 📝 프로젝트 아키텍쳐
![system2 drawio (1)](https://github.com/user-attachments/assets/e4168fc7-038f-459b-9318-10047b0acd44)

## 📝 현장 테스트
![20210127_150057_HDR](https://github.com/user-attachments/assets/032f79ae-d76d-481b-801e-242da2f1ddb8)

## 📝 와이어프레임(화면 구성)
- 로그인 화면
  ![image](https://github.com/user-attachments/assets/cde23140-e07c-4546-a553-71a8f8636fe5)
- 회원가입 화면
  ![image](https://github.com/user-attachments/assets/1631e538-0d31-44a9-849f-569e4ca9852a)
- 메인 화면
  ![image](https://github.com/user-attachments/assets/d70d5247-068c-4ec5-bdc9-7df6de064efa)
- 포트홀 관리 화면
  ![image](https://github.com/user-attachments/assets/a9700d45-37d8-4ee2-b8ce-dc1bde25b06a)
## 📝 구현(이미지)
- 메인화면(사용자 시점)
  ![메인화면](https://github.com/user-attachments/assets/5ee5ef48-ce8b-40a8-ad48-4ec7309d617f)

- 관리화면(관리자 시점)
  ![관리자시점관리화면](https://github.com/user-attachments/assets/a471e5f1-9a53-41c2-9fd3-bf754b573e28)

## 📝 구현(동영상)
- 로그인 화면
- https://github.com/user-attachments/assets/57e62e92-d949-451b-89dd-917539d341ea

- 회원가입 화면
- https://github.com/user-attachments/assets/b6fd44f6-4d69-4787-bd18-d3b8b2540f92

- 아이디 찾기 화면
- https://github.com/user-attachments/assets/5a588aff-ee7f-47e4-90dc-c3e0df1954bb

- 비밀번호 찾기 화면
- https://github.com/user-attachments/assets/b708ce1e-330a-4a73-bd19-4351cd1bce7a

- 메인화면(유저)
- https://github.com/user-attachments/assets/78218a70-a637-465a-975d-e6d001ebeb2e

- 포트홀 관리 화면(관리자)
- https://github.com/user-attachments/assets/e0652dc1-46dc-4680-a8e8-98cac2991b2a

- 개인정보 수정 화면
- https://github.com/user-attachments/assets/d900aa2d-8b52-4078-a036-156f677c31de

## 📌 주요 기능
1. 포트홀 탐지 기능
2. 지도에 포트홀 위치 정보 표시
3. 포트홀 탐지 후 서버 전송 및 지도 내에서 마커 클릭 시 이미지 출력
## 📌 기능 구현 계획
- **클라이언트가 포트홀을 탐지하는 기능**
1. 정확도 60%를 기준으로 탐지된 포트홀이 탐지될 때마다 사진을 저장
2. 만약 클라이언트가 정지된 상태에서 같은 포트홀을 탐지하고 있으면 사진을 무한정 저장하기 때문에 5초 딜레이간격으로 설정


- **탐지된 사진 서버(springboot)에 보내는 방법**
1. 클라이언트(python)에서 Post 형식으로 서버에 지정한 url(http://localhost:8080/api/upload) 로 전송
2. 서버(springboot)에서는 Post형식으로 전송된 이미지를 /resources/static/pothole_images/ 에 저장


- **클라이언트가 서버에 포트홀 정보를 보내는 방법**
1. 클라이언트(python)에서 mysql에 [사용자id, 위도, 경도, 상태(default="접수 중"), 탐지일자, 이미지파일경로] 저장


## 📌 배운점
- **수정 시 콤보박스를 이용할 경우 배열을 통해 값을 컨트롤러에 넘겨줄 수 있고 컨트롤러에서는 Map<key, value> 데이터 구조를 이용해서 해결할 수 있음** <br/>
ex) View : th:name="'stateMap[' + ${pothole.id} + ']'" <br/>
    Controller : @RequestParam Map<String, String> stateMap
________________________________________________________________________________________
![image](https://github.com/user-attachments/assets/81e99863-7e61-4ecc-918f-7af6579c885d)
________________________________________________________________________________________
![image](https://github.com/user-attachments/assets/a50c1904-5f8f-4417-90b5-6a4248980c15)<br/>
________________________________________________________________________________________
![image](https://github.com/user-attachments/assets/9a24c993-bdc2-4f0a-af9b-507fee27152b)
________________________________________________________________________________________
- **mvc 패턴을 직접 Figma 로 그려가며 이해하였음**
![image](https://github.com/user-attachments/assets/5af822b5-ab87-418a-a64f-b20dadd08a31)

- **mvc 패턴에서 정적인 리소스는 서블릿 컨테이너를 안 거치고 Web Server 에서 바로 응답될 수 있으며 동적인 요청은 반드시 DispatcherServlet 을 통해 처리된다는 사실을 알게 되었음**
- **mvc 패턴에서 DispatcherServlet 은 서블릿 컨테이너가 초기화될 때 한 번만 생성되고 이 후 요청이 올 때마다 해당 인스턴스를 재사용한다는 점을 알게 되었음(요청이 들어올 때마다 Servcie() → .doGet()/doPost() 과정으로 DispatcherServlet 이 실행됨)**
- **서블릿 컨테이너는 내부적으로 Thread Pool 을 관리하며 사용자 요청이 들어오면 서블릿 컨테이너는 유후 상태인 쓰레드를 꺼내면 그 쓰레드는 DispatcherServlet 의 Service() → .doGet()/doPost() 부터 컨트롤러까지 전달되어 실제 비즈니스 로직을 수행한 뒤 응답 데이터를 HTTP로 만들어 브라우저에게 전송한다고 한다. 즉 클라이언트로부터 하나의 요청이 들어오면 요청 → 작업 → 응답 까지 모두 하나의 쓰레드를 통해 이루어진다는 사실을 알게 되었다.**


## ✒️ API
- 사용한 API : https://www.openstreetmap.org/#map=13/38.00306/128.65213
