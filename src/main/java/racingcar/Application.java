package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String input = Input.readLine(Prompt.buildCarNamesPrompt());
        List<String> carNames = InputParser.parseCarNames(input);
        InputValidator.validateCarNames(carNames);

        String input2 = Input.readLine(Prompt.buildRaceRoundsPrompt());
        int raceRounds = InputParser.parseRaceRounds(input2);
        InputValidator.validateRaceRounds(raceRounds);

        Game game = new Game(carNames, new RandomGenerator(), raceRounds);
        game.play();
        List<String> winners = game.selectWinners();

        String result = String.join(",", winners);
        System.out.print("최종 우승자 : "+result);
    }
}
