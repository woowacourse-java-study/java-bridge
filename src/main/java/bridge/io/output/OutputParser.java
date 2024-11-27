package bridge.io.output;

import bridge.domain.vo.GameResult;
import bridge.domain.vo.MoveResult;

public class OutputParser {
	
	public String parseMoveResult(MoveResult moveResult) {
		return moveResult.toString();
	}
	
	public String parseFinalMoving(GameResult gameResult) {
		return gameResult.getMoveStatus().toString();
	}
	
	public String parseSuccess(GameResult gameResult) {
		if (gameResult.getMoveStatus().isFail()) {
			return "실패";
		}
		return "성공";
	}
	
	public String parseTotalTryCount(GameResult gameResult) {
		return String.valueOf(gameResult.getTotalTryCount());
	}
}
