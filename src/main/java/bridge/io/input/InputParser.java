package bridge.io.input;

import bridge.domain.Move;
import bridge.domain.RestartCommand;

public class InputParser {
	
	public int parseBridgeSize(String input) {
		return Integer.parseInt(input);
	}
	
	public Move parseMove(String input) {
		return Move.from(input);
	}
	
	public RestartCommand parseRestartCommand(String input) {
		return RestartCommand.from(input);
	}
}
