package racingcar;

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

        Game game = new Game(carNames, new RandomNumberGenerator(), raceRounds);
        List<String> winners = game.play();

        Output.printWinners(winners);
    }
}
