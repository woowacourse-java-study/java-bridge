package bridge.domain.vo;

import bridge.domain.Move;

public class StepResult implements Comparable<StepResult> {
	
	private final int step;
	private final Move move;
	private final boolean isSuccess;
	
	public StepResult(int step, Move move, boolean isSuccess) {
		this.step = step;
		this.move = move;
		this.isSuccess = isSuccess;
	}
	
	public boolean isSuccess() {
		return isSuccess;
	}
	
	@Override
	public int compareTo(StepResult o) {
		return this.step - o.step;
	}
	
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
}
