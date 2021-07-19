package com.mango.book.springboot.springboot;

import com.mango.book.springboot.web.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class) // 테스트를 진행할 때 JUnit에 내장된 실행자 외에 다른 실행자를 실행 / 여기서는 SpringRunner
@WebMvcTest(controllers = HelloController.class) // Web에 집중할 수 있는 어노테이션
public class HelloControllerTest {

    @Autowired // 스프링이 관리하는 빈을 주입받는다
    private MockMvc mvc; // 웹 API를 테스트 할때 사용 / 스프링 mvc 테스트의 시작점
    // 이 클래스를 통해 HTTP GET,POST등에 대한 API 테스트를 할 수 있다.

    @Test
    public void Hello_return() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello")) // MockMVC를 통해 /hello 주소로 Get 요철을 한다
                .andExpect(status().isOk()) // HTTP Header의 Status를 검증 / 200, 404, 500 등의 상태
                .andExpect(content().string(hello)); // mvc.perform의 결과를 검증한다.
        // Controller에서 "Hello"를 리턴하기 때문에 이 값이 맞는지 검증
    }

    @Test
    public void HelloDto_return() throws Exception {
        String name = "Mango";
        int amount = 1000;

        mvc.perform(get("/hello/dto").param("name",name).param("amount",String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}
