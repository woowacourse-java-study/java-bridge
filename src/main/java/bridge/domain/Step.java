package bridge.domain;

import bridge.exception.CustomExceptions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Step {
	
	UP_VALID("U", Move.UP_MOVE),
	DOWN_VALID("D", Move.DOWN_MOVE),
	;
	
	private final String value;
	private final Move validMove;
	
	Step(String value, Move validMove) {
		this.value = value;
		this.validMove = validMove;
	}
	
	public static Step from(int value) {
		if (value == 0) return UP_VALID;
		return DOWN_VALID;
	}
	
	public static List<Step> fromList(List<String> brigeValue) {
		return brigeValue.stream()
				.map(str -> Arrays.stream(Step.values())
						.filter(step -> step.value.equals(str))
						.findFirst()
						.orElseThrow(CustomExceptions.ILLEGAL_STEP::get))
				.collect(Collectors.toList());
	}
	
	public String getValue() {
		return value;
	}
	
	public boolean isValid(Move move) {
		return validMove == move;
	}
}
