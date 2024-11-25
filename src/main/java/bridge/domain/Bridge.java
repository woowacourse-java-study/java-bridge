package bridge.domain;

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
}
