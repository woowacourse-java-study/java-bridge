package bridge.model;

import bridge.constant.GameValue;
import bridge.dto.ResultBridgeDto;
import bridge.dto.StackDto;

public class Referee {
    private final String SAME = "O";
    private final String DIFF = "X";
    private final String DEFAULT = " ";

    public boolean isWin(Bridge gameBridge, ResultBridgeDto resultBridgeDto, StackDto stackDto) {
        if (gameBridge.size() == stackDto.getBlockStack()) {
            return !resultBridgeDto.getUpperBridge().getBridge().contains(DIFF) &&
                    !resultBridgeDto.getLowerBridge().getBridge().contains(DIFF);
        }
        return false;
    }

    public boolean judge(Bridge gameBridge, ResultBridgeDto resultBridgeDto, String moveCommand,
                         StackDto stackDto) {
        int progressIdx = stackDto.getBlockStack() - 1;
        boolean moveResult = gameBridge.get(progressIdx).equals(moveCommand);
        String moveRefereeResult = getMoveRefereeResult(moveResult);
        applyMoveResult(resultBridgeDto, moveCommand, moveRefereeResult);
        return moveResult;
    }

    private void applyMoveResult(ResultBridgeDto resultBridgeDto, String moveCommand, String moveRefereeResult) {
        if (moveCommand.equals(GameValue.UP)) {
            resultBridgeDto.addUpperBridge(moveRefereeResult);
            resultBridgeDto.addLowerBridge(DEFAULT);
            return;
        }
        resultBridgeDto.addUpperBridge(DEFAULT);
        resultBridgeDto.addLowerBridge(moveRefereeResult);
    }

    private String getMoveRefereeResult(boolean moveResult) {
        if (moveResult) {
            return SAME;
        }
        return DIFF;
    }

}
