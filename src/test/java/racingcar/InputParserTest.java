package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputParserTest {

    @Test
    void 자동차이름은_쉼표기준으로_분리(){
        String input = "a,b,c";
        assertThat(InputParser.parseCarNames(input))
                .containsExactly("a", "b", "c");
    }

    @Test
    void 자동차이름에_공백포함시_공백제거(){
        String input = "a, b , c";
        assertThat(InputParser.parseCarNames(input))
                .containsExactly("a", "b", "c");
    }

    @Test
    void 입력이_공백인경우_공백반환(){
        String input = "";
        assertThat(InputParser.parseCarNames(input))
                .containsExactly("");
    }

    @Test
    void 시도횟수가_숫자로_변환가능한_문자열일경우_변환(){
        String input = "5";
        assertThat(InputParser.parseRaceRounds(input))
                .isEqualTo(5);
    }

    @Test
    void 시도횟수가_숫자로_변환불가한_문자열일경우_예외(){
        String input = "a";
        assertThatThrownBy(()->InputParser.parseRaceRounds(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도횟수가_공백인_경우_예외(){
        String input = "";
        assertThatThrownBy(()->InputParser.parseRaceRounds(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}