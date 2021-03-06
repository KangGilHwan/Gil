package bowling.domain;

public class LastFrame extends Frame {

    private Ball third;

    public void playLastBall(int pin) {
        third = Ball.playOf(pin);
    }

    public int thirdInFrame() {
        return third.getPin();
    }

    public boolean isStrikeOrSpare() {
        return isStrike() || isSpare();
    }

    public boolean isLastBall() {
        return (isTwiceBall()&&!isSpare()) || !isThirdNull();
    }

    public boolean isThirdNull() {
        return third == null;
    }

    public void secondPinCheckException(int secondPin) {
        if (!isStrike() && firstInFrame() + secondPin > 10) {
            throw new IllegalArgumentException("핀의 합계가 10을 초과 했습니다.");
        }
    }
}
