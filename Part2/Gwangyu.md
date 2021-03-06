## chapter2. 스프링 MVC의 Controller

chapter 2를 진행하면서 정리가 필요한 내용들을 작성해 봄.

프로젝트 설정하면서 연습이 필요한 것들

- web.xml, root-context.xml, servlet-config.xml 등 스프링 설정문서 작성하는 법 알기
- log4j 설정하는 방법
- datasource 설정하는 방법
- myBatis 연동하는 방법

스프링 의존관계 및 설정문서가 생성하는 것들.

설정문서의 영역이 구분되어 있음을 안다.

- 웹 어플리케이션 영역(WebApplicationContext)
- RootWebApplicationContext - 공유영역
- ServletWebApplicationContext - Dispatcher에 의해 생성되는

참고  [https://linked2ev.github.io/spring/2019/09/15/Spring-5-서블릿과-스프링에서-Context(컨텍스트)란/](https://linked2ev.github.io/spring/2019/09/15/Spring-5-%EC%84%9C%EB%B8%94%EB%A6%BF%EA%B3%BC-%EC%8A%A4%ED%94%84%EB%A7%81%EC%97%90%EC%84%9C-Context(%EC%BB%A8%ED%85%8D%EC%8A%A4%ED%8A%B8)%EB%9E%80/)

---

### 자바 파일로 설정문서 세팅

기억할 클래스

- AbstractAnnotationConfigDIspatcherServletInitializer
    - 해당 클래스를 통해 WebConfig 설정.
    - rootConfig, webConfig(ServletConfig), setvletMapping
    - rootConfig → [RootConfig.java](http://rootconfig.java) 로, webConfig → ServletConfig.java로

RootConfig.java

1. 사용 어노테이션
    - @ComponentScan
2. 추가해야할 메소드
    - DataSource 관련 → @Bean 어노테이션을 꼭 사용해줌
    - SqlMapper 관련 → @Bean어노테이션 사용

[ServletConfig.java](http://servletconfig.java) → WebMvcConfigurer 상속

1. 사용하는 어노테이션 목록
    - @EnableWebMvc
    - @WebMvcConfigurer
    - @ComponentScan

2. 추가해야할 메소드 ( 초기 설정 )
    - configureViewResolvers ( 뷰 리졸버 설정 )
    - addResourceHandlers ( 리소스 핸들러 )
    - 기타 메소드 들도 필요에 따라 추가함 ( ex. formatter 등)

---

### Spring MVC 관련 어노테이션

- @Controller, @RestController
- @RequestMapping, @GetMapping, @PostMapping
- @RequestParam → 파라미터로 사용된 변수 명과 이름이 다를 때 유용함
- @InitBinder
- @DateTimeFormat
- @ModelAttribute
    - 기본 자료형은 파라미터로 선언해도 화면까지 가지 못함. 때문에 Model에 바인딩시키자