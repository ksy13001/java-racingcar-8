package racingcar;

import java.util.List;

public class Prompt {

    private Prompt() {
    }

    private static final String WINNER_PROMPT = "최종 우승자 : ";
    private static final String INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_RACE_ROUNDS = "시도할 횟수는 몇 회인가요?";
    private static final String CAR_NAME_SEPARATOR = ":";
    private static final String MOVE_SYMBOL = "-";
    private static final String WINNER_SEPARATOR = ", ";
    private static final String SPACE = " ";


    public static String buildCarNamesPrompt(){
        return INPUT_CAR_NAMES;
    }

    public static String buildRaceRoundsPrompt(){
        return INPUT_RACE_ROUNDS;
    }

    public static String buildRacingStatusPrompt(String carName, int moveCount) {
        return carName + SPACE + CAR_NAME_SEPARATOR + SPACE + MOVE_SYMBOL.repeat(moveCount);
    }

    public static String buildWinnerPrompt(List<String> winners) {
        return WINNER_PROMPT + String.join(WINNER_SEPARATOR, winners);
    }
}
