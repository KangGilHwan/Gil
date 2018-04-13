package bowling.domain;

public class Score {

    private int pin;
    private int count;

    public Score(int pin, int count) {
        this.pin = pin;
        this.count = count;
    }

    public Score of(int countOfPin) {
        return new Score(pin + countOfPin, count - 1);
    }

    public int getCount() {
        return count;
    }

    public int getPin() {
        return pin;
    }

    public boolean isLeft() {
        return count == 0;
    }
}
