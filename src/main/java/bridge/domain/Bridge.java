package bridge.domain;

import bridge.dto.MoveResult;
import bridge.exception.CustomExceptions;

import java.util.List;
import java.util.Objects;

public class Bridge {
	
	private static final int MIN_STEP_SIZE = 3;
	private static final int MAX_STEP_SIZE = 8;
	
	private final List<Step> steps;
	
	public Bridge(List<Step> steps) {
		Objects.requireNonNull(steps);
		validate(steps);
		this.steps = steps;
	}
	
	private static void validate(List<Step> steps) {
		if (steps.size() < MIN_STEP_SIZE || steps.size() > MAX_STEP_SIZE) {
			throw CustomExceptions.INVALID_BRIDGE_SIZE.get();
		}
	}
	
	public static Bridge from(int size, BridgeMaker bridgeMaker) {
		List<String> brigeValue = bridgeMaker.makeBridge(size);
		return new Bridge(Step.fromList(brigeValue));
	}
	
	public MoveResult move(int position, Move move) {
		Step currentStep = steps.get(position);
		return new MoveResult(position, move, currentStep.isValid(move));
	}
	
	public boolean isBridgeEnd(int currentPosition) {
		return steps.size() <= currentPosition;
	}
}
