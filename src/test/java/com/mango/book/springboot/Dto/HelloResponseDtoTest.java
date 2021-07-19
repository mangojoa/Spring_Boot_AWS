package com.mango.book.springboot.Dto;

import com.mango.book.springboot.web.DTO.HelloResponseDto;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {
    @Test
    public void lombok_option_test(){

        // givendd
        String name = "Mango";
        int amount = 1000;

        // when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        // then
        assertThat(dto.getName()).isEqualTo(name);
        // assertj 테스트 검증 라이브러리의 검증 메소드
        assertThat(dto.getAmount()).isEqualTo(amount);
        // 동등 비교 메소드 assertThat과 isEqualTo의 값을 비교할 때, 같다면 성공입니다.

        /*
        Junit의 기본 aseertThat이 아닌 assertj의 assertThat을 사용했다.
        assertj 역시 Junit에서 자동으로 라이브러리 등록을 해준다.
         */

    }
}
