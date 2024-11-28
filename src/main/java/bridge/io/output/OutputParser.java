package bridge.io.output;

import bridge.common.dto.GameResult;
import bridge.common.dto.MoveResult;

public class OutputParser {
	
	public String parseMoveResult(MoveResult moveResult) {
		return moveResult.toString();
	}
	
	public String parseFinalMoving(GameResult gameResult) {
		return gameResult.moveResult().toString();
	}
	
	public String parseSuccess(GameResult gameResult) {
		if (gameResult.moveResult().isFail()) {
			return "실패";
		}
		return "성공";
	}
	
	public String parseTotalTryCount(GameResult gameResult) {
		return String.valueOf(gameResult.totalTryCount());
	}
}
