package bridge.domain.vo;

public class GameResult {
	
	private final MoveStatus moveStatus;
	private final int totalTryCount;
	
	public GameResult(MoveStatus moveStatus, int totalTryCount) {
		this.moveStatus = moveStatus;
		this.totalTryCount = totalTryCount;
	}
	
	public MoveStatus getMoveStatus() {
		return moveStatus;
	}
	
	public int getTotalTryCount() {
		return totalTryCount;
	}
}
