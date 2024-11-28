package bridge.common.dto;

public record GameResult(
		MoveResult moveResult,
		int totalTryCount
) {
}
