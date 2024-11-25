package bridge.domain;

import bridge.exception.CustomExceptions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Step {
	
	UP_VALID("U"),
	DOWN_VALID("D"),
	;
	
	private final String value;
	
	Step(String value) {
		this.value = value;
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
						.orElseThrow(CustomExceptions.INVALID_MOVE::get))
				.collect(Collectors.toList());
	}
	
	public String getValue() {
		return value;
	}
}
