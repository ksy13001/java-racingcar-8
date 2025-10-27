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

    public void play() {
        for (int i = 0; i < raceRounds; i++) {
            for (Car car : cars) {
                race(car, numberGenerator.generateNumber());
            }
            System.out.println();
        }
    }

    private void race(Car car, int randomValue){
        if (randomValue >= FORWARD_REQUIRED_VALUE) {
            car.moveForward();
        }
        Output.printRacingStatus(car.getName(), car.getMoveCount());
    }

    public List<String> selectWinners(){
        int max_value = cars.stream().mapToInt(Car::getMoveCount).max().getAsInt();
        List<String> winners = new ArrayList<>();
        for(Car car : cars){
            if(car.getMoveCount() == max_value){
                winners.add(car.getName());
            }
        }
        return winners;
    }
}
