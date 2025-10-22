package racingcar;

import java.util.Arrays;
import java.util.List;

public class InputParser {

    private static final String DELIMITER = ",";

    private InputParser() {
    }

    public static List<String> parseCarNames(String input){
        return Arrays.stream(input.split(DELIMITER))
                .map(String::trim)
                .toList();
    }

    public static Integer parseRaceRounds(String input){
        Integer result = null;
        try {
            result = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도횟수는 숫자만 가능합니다.");
        }
        return result;
    }
}
