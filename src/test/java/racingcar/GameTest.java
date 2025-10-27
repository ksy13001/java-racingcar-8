package racingcar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    private List<Car> cars;
    private Game game;

    @BeforeEach
    void setUp() {
        cars = List.of("ca")
        Game game = new Game(List.of("car1", "car2", "car3")
                , );
    }

    @Test
    void 랜덤값이_4이상일경우_전진(){
        Car car = Car.of("car1");


        assertDoesNotThrow(()->InputValidator.validateCarNames(carNames));
    }

}