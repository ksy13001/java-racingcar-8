package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private static final int FORWARD_REQUIRED_VALUE = 4;

    private final List<Car> cars;
    private final NumberGenerator numberGenerator;
    private final int raceRounds;

    public Game(List<String> carNames, NumberGenerator numberGenerator, int raceRounds) {
        this.numberGenerator = numberGenerator;
        this.raceRounds = raceRounds;
        this.cars = carNames.stream().map(Car::of).toList();
    }

    public List<String> play() {
        for (int i = 0; i < raceRounds; i++) {
            for (Car car : cars) {
                race(car, numberGenerator.generateNumber());
            }
            System.out.println();
        }

        return selectWinners();
    }

    private void race(Car car, int randomValue){
        if (randomValue >= FORWARD_REQUIRED_VALUE) {
            car.moveForward();
        }
        Output.printRacingStatus(car.getName(), car.getMoveCount());
    }

    private List<String> selectWinners(){
        int max_value = getMaxMoveCount();

        return cars.stream()
                .filter(car -> car.getMoveCount() == max_value)
                .map(Car::getName)
                .toList();
    }

    private int getMaxMoveCount(){
        return cars.stream().mapToInt(Car::getMoveCount).max()
                .orElseThrow(()-> new IllegalArgumentException("최대값이 존재하지 않습니다."));
    }
}
