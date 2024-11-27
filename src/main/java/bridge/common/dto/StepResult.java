package bridge.common.dto;

import bridge.domain.Move;

public record StepResult(
		int step,
		Move move,
		boolean isSuccess
) implements Comparable<StepResult> {
	
	public String getUpString() {
		if (move == Move.DOWN_MOVE) return "   ";
		if (!isSuccess) return " X ";
		return " O ";
	}
	
	public String getDownString() {
		if (move == Move.UP_MOVE) return "   ";
		if (!isSuccess) return " X ";
		return " O ";
	}
	
	@Override
	public int compareTo(StepResult o) {
		return this.step - o.step;
	}
}
