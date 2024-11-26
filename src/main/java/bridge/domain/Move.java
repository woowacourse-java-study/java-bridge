package bridge.domain;

import bridge.exception.CustomExceptions;

import java.util.Arrays;

public enum Move {
	
	UP_MOVE("U"),
	DOWN_MOVE("D"),
	;
	
	private final String inputValue;
	
	Move(String inputValue) {
		this.inputValue = inputValue;
	}
	
	public static Move from(String value) {
		return Arrays.stream(Move.values())
				.filter(move -> move.inputValue.equals(value))
				.findFirst()
				.orElseThrow(CustomExceptions.ILLEGAL_MOVE::get);
	}
}
