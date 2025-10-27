package racingcar;

public class TestNumberGenerator implements NumberGenerator {

    private final int value;

    public TestNumberGenerator(int value) {
        this.value = value;
    }

    @Override
    public int generateNumber() {
        return this.value;
    }
}
