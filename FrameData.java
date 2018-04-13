package bowling.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FrameData {

    static final int LAST_FRAME = 9;

    private List<NomalFrame> frames = new ArrayList<>();
    private NomalFrame nomalFrame = new NomalFrame();
    private LastFrame lastFrame = new LastFrame();
    private List<Score> scores = new ArrayList<>();

    public void play(int pin) {
        nomalFrame.playOneBall(pin);
        for (int i = 0; i< scores.size() ; i++) {
            if (!scores.get(i).isLeft()) {
                scores.set(i, scores.get(i).of(pin));
            }
        }
        if (nomalFrame.isStrike() || nomalFrame.isTwiceBall()) {
            frames.add(nomalFrame);
            scoreMake(pin);
            nextFrame(frames.size());
        }
    }

    public void scoreMake(int pin) {
        int score = 0;
        Score score1;
        if (nomalFrame.isStrike()) {
            score = nomalFrame.firstInFrame();
            if (frames.size() == 1) {
                score1 = new Score(score, 2);
            } else {
                score1 = new Score(scores.get(scores.size() - 1).getPin() + score, 2);
            }
        } else {
            score = nomalFrame.firstInFrame() + nomalFrame.secondInFrame();
            if (frames.size() == 1) {
                score1 = new Score(score, 0);
            } else {
                score1 = new Score(scores.get(scores.size() - 1).getPin() + score, 0);
            }
        }
        scores.add(score1);
    }

    public boolean playLastFrame(int pin) {
        if (lastFrame.isNewFrame() || lastFrame.isSecondNull()) {
            lastFrame.playOneBall(pin);
        } else if (lastFrame.isStrike() || lastFrame.isSpare()) {
            lastFrame.playLastBall(pin);
        }
        return lastFrame.isLastBall();
    }

    public void nextFrame(int numberOfFrame) {
        if (numberOfFrame < LAST_FRAME) {
            nomalFrame = nomalFrame.next();
        }
    }

    public List<NomalFrame> getFrames() {
        return Collections.unmodifiableList(frames);
    }

    public NomalFrame getNomalFrame() {
        return nomalFrame;
    }

    public LastFrame getLastFrame() {
        return lastFrame;
    }

    public List<Score> getScores() {
        return scores;
    }

    public int numberOfFrame() {
        return frames.size() + 1;
    }           //현재 프레임이 몇번째인지 알려준다.
}
