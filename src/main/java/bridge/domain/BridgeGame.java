package bridge.domain;

import bridge.common.dto.GameResult;
import bridge.common.dto.StepResult;
import bridge.common.dto.MoveResult;

import java.util.ArrayList;
import java.util.List;

public class BridgeGame {
    
    private final Bridge bridge;
    private final List<StepResult> stepResults = new ArrayList<>();
    private int currentPosition = 0;
    private int tryCount = 1;
    
    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
    }
    
    public MoveResult move(MoveCommand moveCommand) {
        stepResults.add(bridge.move(currentPosition++, moveCommand));
        return new MoveResult(stepResults);
    }
    
    public boolean isBridgeGameSuccess() {
        return bridge.isBridgeEnd(currentPosition);
    }
    
    public void restart() {
        currentPosition = 0;
        tryCount++;
        stepResults.clear();
    }
    
    public GameResult getGameResult() {
        return new GameResult(new MoveResult(stepResults), tryCount);
    }
}
