package bridge.domain;

import bridge.dto.MoveResult;

import java.util.List;

public class BridgeGame {
    
    private final Bridge bridge;
    private final List<MoveResult> moveResults;
    private int currentPosition;
    private int tryCount;
    
    public BridgeGame(Bridge bridge, List<MoveResult> moveResults) {
        this.bridge = bridge;
        this.moveResults = moveResults;
    }
    
    public MoveStatus move(Move move) {
        moveResults.add(bridge.move(currentPosition++, move));
        return new MoveStatus(moveResults, ++tryCount);
    }
    
    public void retry() {
        currentPosition = 0;
        moveResults.clear();
    }
}
