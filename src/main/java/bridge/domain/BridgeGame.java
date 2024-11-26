package bridge.domain;

import bridge.domain.vo.GameResult;
import bridge.domain.vo.StepResult;
import bridge.domain.vo.MoveResult;

import java.util.ArrayList;
import java.util.List;

public class BridgeGame {
    
    private final Bridge bridge;
    private final List<StepResult> stepResults = new ArrayList<>();
    private int currentPosition = 0;
    private int tryCount = 0;
    
    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
    }
    
    public MoveResult move(Move move) {
        stepResults.add(bridge.move(currentPosition++, move));
        return new MoveResult(stepResults, ++tryCount);
    }
    
    public boolean isBridgeGameSuccess() {
        return bridge.isBridgeEnd(currentPosition);
    }
    
    public void retry() {
        currentPosition = 0;
        stepResults.clear();
    }
    
    public GameResult getGameResult(MoveResult moveResult) {
        return new GameResult(moveResult, tryCount);
    }
}
