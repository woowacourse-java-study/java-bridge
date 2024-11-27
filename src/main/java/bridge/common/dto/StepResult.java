package bridge.common.dto;

import bridge.domain.MoveCommand;

public record StepResult(
		int step,
		MoveCommand moveCommand,
		boolean isSuccess
) implements Comparable<StepResult> {
	
	public String getUpString() {
		if (moveCommand == MoveCommand.DOWN_MOVE) return "   ";
		if (!isSuccess) return " X ";
		return " O ";
	}
	
	public String getDownString() {
		if (moveCommand == MoveCommand.UP_MOVE) return "   ";
		if (!isSuccess) return " X ";
		return " O ";
	}
	
	@Override
	public int compareTo(StepResult o) {
		return this.step - o.step;
	}
}
