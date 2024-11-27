package bridge.io.input;

import bridge.domain.MoveCommand;
import bridge.domain.RestartCommand;

public class InputParser {
	
	public int parseBridgeSize(String input) {
		return Integer.parseInt(input);
	}
	
	public MoveCommand parseMoveCommand(String input) {
		return MoveCommand.from(input);
	}
	
	public RestartCommand parseRestartCommand(String input) {
		return RestartCommand.from(input);
	}
}
