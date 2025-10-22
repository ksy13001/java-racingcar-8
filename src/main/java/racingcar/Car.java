package racingcar;

public class Car {

    public Car(String name){
        this.name = name;
    }

    private final String name;
    private int moveCount;

    public void moveForward(){
        this.moveCount++;
    }

    public String getName(){
        return this.name;
    }

    public int getMoveCount(){
        return this.moveCount;
    }
}
