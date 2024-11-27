package bridge.io.input;

import bridge.common.exception.CustomExceptions;

public class InputValidator {
	
	public void validateBridgeSize(String input) {
		for (char ch : input.toCharArray()) {
			if (!Character.isDigit(ch)) {
				throw CustomExceptions.INVALID_BRIDGE_SIZE.get();
			}
		}
	}
	
	public void validateMoving(String input) {
		for (char ch : input.toCharArray()) {
			if (!Character.isAlphabetic(ch)) {
				throw CustomExceptions.INVALID_MOVE.get();
			}
		}
	}
	
	public void validateRestartCommand(String input) {
		for (char ch : input.toCharArray()) {
			if (!Character.isAlphabetic(ch)) {
				throw CustomExceptions.INVALID_RESTART.get();
			}
		}
	}
}
