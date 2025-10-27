package racingcar;


import camp.nextstep.edu.missionutils.Randoms;

public class RandomGenerator {
    private final static int MIN_RANDOM_NUMBER = 0;
    private final static int MAX_RANDOM_NUMBER = 9;

    public int generateRandomNumber(){
        return Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
    }
}
