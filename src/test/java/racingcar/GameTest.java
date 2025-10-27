package racingcar;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {

    @Test
    void 임계값_이상일_경우에만_전진() {
        List<String> carNames = List.of("car1", "car2");
        NumberGenerator generator = new TestNumberGenerator(4, 3);
        Game game = new Game(carNames, generator, 1);

        List<String> winners = game.play();

        assertThat(winners).containsExactly("car1");
    }

    @Test
    void 모든_자동차가_정지하면_공동우승() {
        List<String> carNames = List.of("car1", "car2");
        NumberGenerator generator = new TestNumberGenerator(3, 3);
        Game game = new Game(carNames, generator, 1);

        List<String> winners = game.play();

        assertThat(winners).containsExactlyElementsOf(carNames);
    }

    private static class TestNumberGenerator implements NumberGenerator {
        private final Deque<Integer> numbers;

        TestNumberGenerator(Integer... numbers) {
            this.numbers = new ArrayDeque<>(List.of(numbers));
        }

        @Override
        public int generateNumber() {
            if (numbers.isEmpty()) {
                throw new IllegalStateException("테스트값 개수가 부족합니다.");
            }
            return numbers.removeFirst();
        }
    }
}
