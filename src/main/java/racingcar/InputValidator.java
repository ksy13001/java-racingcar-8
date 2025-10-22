package racingcar;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {

    private final static String CAR_NAME_EMPTY_MESSAGE = "자동차 이름이 비었습니다.";
    private final static String CAR_NAME_LENGTH_OVER_MESSAGE = "자동차 이름 길이 범위가 초과되었습니다(1~5).";
    private final static String DUPLICATE_CAR_NAME_MESSAGE = "중복된 자동차 이름입니다.";
    private final static String RACE_ROUNDS_LENGTH_OVER_MESSAGE = "시도횟수 범위가 초과되었습니다.";
    private final static int MAX_CAR_NAME_LENGTH = 5;
    private final static int MIN_CAR_NAME_LENGTH = 1;
    private final static int MAX_RACE_ROUNDS = 100;
    private final static int MIN_RACE_ROUNDS = 1;


    private InputValidator() {
    }

    public static void validateCarNames(List<String> carNames) {
        Set<String> existingCarNames = new HashSet<>();
        carNames.forEach(carName -> validateCarName(carName, existingCarNames));
    }

    public static void validateRaceRounds(int raceRounds) {
        if (!isInRange(raceRounds, MIN_RACE_ROUNDS, MAX_RACE_ROUNDS)) {
            throw new IllegalArgumentException(RACE_ROUNDS_LENGTH_OVER_MESSAGE);
        }
    }

    private static void validateCarName(String carName, Set<String> existingCarNames) {
        if (isEmpty(carName)) {
            throw new IllegalArgumentException(CAR_NAME_EMPTY_MESSAGE);
        }

        if (!isInRange(carName.length(), MIN_CAR_NAME_LENGTH, MAX_CAR_NAME_LENGTH)) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_OVER_MESSAGE);
        }

        if (isDuplicated(carName, existingCarNames)) {
            throw new IllegalArgumentException(DUPLICATE_CAR_NAME_MESSAGE);
        }

        existingCarNames.add(carName);
    }

    private static boolean isInRange(int value, int min, int max) {
        return min <= value && value <= max;
    }

    private static boolean isEmpty(String carName) {
        return carName == null || carName.isEmpty();
    }

    private static boolean isDuplicated(String carName, Set<String> existingCarNames) {
        return existingCarNames.contains(carName);
    }

}
