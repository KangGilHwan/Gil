package bowling.domain;

import java.util.ArrayList;
import java.util.List;

public class NomalFrame extends Frame {

    public NomalFrame next() {
        return new NomalFrame();
    }

    public void secondPinCheckException(int secondPin) {
        if (isSecondNull() && firstInFrame() + secondPin > 10) {
            throw new IllegalArgumentException("핀의 합계가 10을 초과 했습니다.");
        }
    }
}
