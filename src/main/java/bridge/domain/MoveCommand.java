package bridge.domain;

import bridge.common.exception.CustomExceptions;

import java.util.Arrays;

public enum MoveCommand {
	
	UP_MOVE("U"),
	DOWN_MOVE("D"),
	;
	
	private final String inputValue;
	
	MoveCommand(String inputValue) {
		this.inputValue = inputValue;
	}
	
	public static MoveCommand from(String input) {
		return Arrays.stream(MoveCommand.values())
				.filter(move -> move.inputValue.equals(input))
				.findFirst()
				.orElseThrow(() -> CustomExceptions.ILLEGAL_MOVE.get(UP_MOVE.inputValue, DOWN_MOVE.inputValue));
	}
}
