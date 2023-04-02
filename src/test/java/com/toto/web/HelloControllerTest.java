package com.toto.web;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//CTRL + SHIFT + T를 누르면 테스트코드 생성
/*
@ExtendWith
Extention 사용을 위한 어노테이션(ex BeforAllCallback 등 lifecycle callbacks 호출 시)
 - JUnit4에서는 Runwith, JUnit5에서는 ExtendWith
 - SpringExtension.class & MockitoExtension.class 두 종류가 있음
 - SpringBootTest 없이 가볍게 테스트 하고 싶을 때는 MockitoExtension, 일반적인 경우는 SpringExtents
 - 참고 링크 : https://stackoverflow.com/questions/60308578/what-is-the-difference-between-extendwithspringextension-class-and-extendwit
 */
/*
* Extention : JUnit 확장 모델으로 확장에 사용할 클래스를 정의하고 ExtendWith의 매개변수에 넣어 확장한다.
* @RegisterExtention을 통해 커스터마이징 가능
* 상세 : https://huisam.tistory.com/entry/junit
* */
@ExtendWith(SpringExtension.class)
/*
@AutoConfigureMockMvc
 - MockMvc 제어하는 어노테이션
 - Mock : 테스트를 위해 실체 객체와 비슷한 객체를 만드는 것
 - 같은 기능을 수행하는 어노테이션으로 @WebMvcTest 존재
 - @WebMvcTest는 가볍게 테스트할 때 사용, @Controller 어노테이션만 테스트 가능
 - @AutoConfigureMockMvc는 @Controller 뿐만 아니라 @Service, @Repository 모두 테스트 가능
 - 참고 링크 : https://we1cometomeanings.tistory.com/65
 */
@AutoConfigureMockMvc
/*
@SpringBootTest
 - 테스트에 필요한 거의 모든 의존성 제공
 - 사용 시 @ExtendWith(SpringExtension.class) 이미 포함하고 있기 때문에 @ExtensionWith를 하용하지 않아도 됌
 - Autowired 허용하여 객체 의존성 주입
 - 참고 링크 : https://www.inflearn.com/questions/211302/springboottest%EC%97%90%EC%84%9C-%EC%96%B4%EB%96%BB%EA%B2%8C-autowired%EA%B0%80-%EC%9E%91%EB%8F%99%ED%95%98%EB%8A%94%EC%A7%80-%EA%B6%81%EA%B8%88%ED%95%A9%EB%8B%88%EB%8B%A4
*/
@SpringBootTest
class HelloControllerTest {
    //MockMvc 객체에 의존성 주입
    //SpringBootTest 어노테이션이 없다면 의존성 주입이 되지 않아 값이 null로 처리됨
    @Autowired
    //웹 API 테스트할 때 사용, 스프링 MVC 테스트의 시작점
    private MockMvc mvc;

    @Test
    //JUnit5의 테스트 수행
    //여러 테스트 케이스 만들어서 값 안에 추가해서 테스트 가능
    public void helloControllerTest() throws Exception{
        String hello = "hello";

        //MockMvc를 통해 //hello 주소로 HTTP GET 요청
        //체이닝이 지원되어 검증기능 이어서 선언 가능
        mvc.perform(get("/hello"))
                //perform의 결과 검증
                //Http의 Header의 status를 검증하며 흔히 알고 있는 200,404,500등 검증
                //여기선 OK 즉, 200인지 아닌지 검증
                .andExpect(status().isOk())
                //응답본문의 내용검증
                .andExpect(content().string(hello));
    }

    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

/*        mvc.perform(
                get("/hello/dto")
                //값은 string만 허용되며 숫자,날짜 등의 데이터도 문자열로 변경해야만 가능
                .param("name", name)
                .param("amount", String.valueOf(amount))
            ).andExpect(status().isOk())
                        //json 응답값을 필드별로 검증할 수 있는 메소드
                        //$를 기준으로 필드명을 명시
            .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));*/
    }
}