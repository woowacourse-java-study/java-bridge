package bridge.domain;

import bridge.common.dto.StepResult;
import bridge.common.exception.CustomExceptions;

import java.util.List;
import java.util.Objects;

public class Bridge {
	
	private static final int MIN_STEP_SIZE = 3;
	private static final int MAX_STEP_SIZE = 20;
	
	private final List<Step> steps;
	
	public Bridge(List<Step> steps) {
		Objects.requireNonNull(steps);
		validate(steps);
		this.steps = steps;
	}
	
	private static void validate(List<Step> steps) {
		if (steps.size() < MIN_STEP_SIZE || steps.size() > MAX_STEP_SIZE) {
			throw CustomExceptions.ILLEGAL_BRIDGE_SIZE.get(MIN_STEP_SIZE, MAX_STEP_SIZE);
		}
	}
	
	public static Bridge from(int size, BridgeMaker bridgeMaker) {
		List<String> brigeValue = bridgeMaker.makeBridge(size);
		return new Bridge(Step.fromList(brigeValue));
	}
	
	public StepResult move(int position, Move move) {
		Step currentStep = steps.get(position);
		return new StepResult(position, move, currentStep.isValid(move));
	}
	
	public boolean isBridgeEnd(int currentPosition) {
		return steps.size() <= currentPosition;
	}
}
