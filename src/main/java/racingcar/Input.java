package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private Input() {
    }

    public static String readLine(String prompt) {
        System.out.println(prompt);
        return Console.readLine();
    }
}
