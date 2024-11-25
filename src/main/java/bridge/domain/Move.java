package bridge.domain;

import bridge.exception.CustomExceptions;

import java.util.Objects;

public class Move {
	
	private static final String UP_STRING = "U";
	private static final String DOWN_STRING = "D";
	
	private final String value;
	
	private Move(String value) {
		Objects.requireNonNull(value);
		validate(value);
		this.value = value;
	}
	
	public static Move from(int value) {
		if (value == 0) return new Move(DOWN_STRING);
		return new Move(UP_STRING);
	}
	
	public String getStringValue() {
		return value;
	}
	
	private void validate(String value) {
		if (!value.equals(UP_STRING) && !value.equals(DOWN_STRING)) {
			throw CustomExceptions.INVALID_MOVE.get();
		}
	}
}
