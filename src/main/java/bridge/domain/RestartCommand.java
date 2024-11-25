package bridge.domain;

import bridge.exception.CustomExceptions;

import java.util.Arrays;

public enum RestartCommand {
	
	RESTART("R"),
	END("Q"),
	;
	
	private final String inputValue;
	
	RestartCommand(String inputValue) {
		this.inputValue = inputValue;
	}
	
	public static RestartCommand from(String input) {
		return Arrays.stream(RestartCommand.values())
				.filter(restartCommand -> restartCommand.inputValue.equals(input))
				.findFirst()
				.orElseThrow(CustomExceptions.INVALID_RESTART::get);
	}
}
