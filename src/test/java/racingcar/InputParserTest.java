package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class InputParserTest {

    @Test
    void 자동차이름은_쉼표기준으로_분리(){
        String i = "a,b,c";
        assertThat(InputParser.parseCarNames(i))
                .containsExactly("a", "b", "c");
    }

    @Test
    void 자동차이름에_공백포함시_공백제거(){
        String i = "a, b , c";
        assertThat(InputParser.parseCarNames(i))
                .containsExactly("a", "b", "c");
    }

    @Test
    void 입력이_공백인경우_공백반환(){
        String i = "";
        assertThat(InputParser.parseCarNames(i))
                .containsExactly("");
    }
}