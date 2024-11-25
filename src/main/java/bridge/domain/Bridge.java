package bridge.domain;

import bridge.dto.MoveResult;

import java.util.List;

public class Bridge {
	
	private final List<Step> steps;
	
	public Bridge(List<Step> steps) {
		this.steps = steps;
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
