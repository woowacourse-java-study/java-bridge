package bridge.domain;

import bridge.dto.MoveResult;

import java.util.ArrayList;
import java.util.List;

public class BridgeGame {
    
    private final Bridge bridge;
    private final List<MoveResult> moveResults = new ArrayList<>();
    private int currentPosition = 0;
    private int tryCount = 0;
    
    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
    }
    
    public MoveStatus move(Move move) {
        moveResults.add(bridge.move(currentPosition++, move));
        return new MoveStatus(moveResults, ++tryCount);
    }
    
    public boolean isBridgeGameSuccess() {
        return bridge.isBridgeEnd(currentPosition);
    }
    
    public void retry() {
        currentPosition = 0;
        moveResults.clear();
    }
    
    public GameResult getGameResult(MoveStatus moveStatus) {
        return new GameResult(moveStatus, tryCount);
    }
}
