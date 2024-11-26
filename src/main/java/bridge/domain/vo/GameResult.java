package bridge.domain.vo;

public class GameResult {
	
	private final MoveResult moveResult;
	private final int totalTryCount;
	
	public GameResult(MoveResult moveResult, int totalTryCount) {
		this.moveResult = moveResult;
		this.totalTryCount = totalTryCount;
	}
	
	public MoveResult getMoveStatus() {
		return moveResult;
	}
	
	public int getTotalTryCount() {
		return totalTryCount;
	}
}
