package racingcar;

import java.util.List;

public class Output {

    private Output() {}

    public static void printRacingStatus(String carName, int moveCount){
        System.out.println(Prompt.buildRacingStatusPrompt(carName, moveCount));
    }

    public static void printWinners(List<String> winners){
        System.out.println(Prompt.buildWinnerPrompt(winners));
    }
}
