package bridge.domain;

import bridge.dto.MoveResult;

import java.util.List;
import java.util.StringJoiner;

public class MoveStatus {
	
	private final List<MoveResult> moveResults;
	private final int tryCount;
	
	public MoveStatus(List<MoveResult> moveResults, int tryCount) {
		this.moveResults = moveResults;
		this.tryCount = tryCount;
	}
	
	public boolean isFail() {
		for (MoveResult moveResult : moveResults) {
			if (!moveResult.isSuccess()) {
				return true;
			}
		}
		return false;
	}
	
	public int getTryCount() {
		return tryCount;
	}
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		StringJoiner upStringJoiner = new StringJoiner("|", "[", "]");
		StringJoiner downStringJoiner = new StringJoiner("|", "[", "]");
		
		moveResults.forEach(moveResult -> {
			upStringJoiner.add(moveResult.getUpString());
			downStringJoiner.add(moveResult.getDownString());
		});
		
		return stringBuilder.append(upStringJoiner)
				.append("\n")
				.append(downStringJoiner)
				.toString();
	}
}
