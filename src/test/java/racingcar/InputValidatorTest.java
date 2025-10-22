package racingcar;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {

    @Test
    void 정상_동작_테스트(){
        List<String> carNames = List.of("car1", "car2", "car3");
        assertDoesNotThrow(()->InputValidator.validateCarNames(carNames));
    }

    @Test
    void 자동차이름_길이가_지정범위_초과할경우_예외(){
        List<String> carNames = List.of("car1", "car2", "123456");
        assertThatThrownBy(()->InputValidator.validateCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차이름_비어있을경우_예외(){
        List<String> carNames = List.of("car1", "car2", "");
        assertThatThrownBy(()->InputValidator.validateCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차이름_중복일경우_예외(){
        List<String> carNames = List.of("car1", "car2", "car1");
        assertThatThrownBy(()->InputValidator.validateCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }
}