package racingcar;

public class Car {

    private Car(String name){
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

    public static Car of(String name){
        return new Car(name);
    }
}
