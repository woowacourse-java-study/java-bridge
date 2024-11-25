package bridge.domain;

import java.util.List;

public class Bridge {
	
	private final List<String> value;
	
	public Bridge(List<String> value) {
		this.value = value;
	}
	
	public static Bridge from(int size, BridgeMaker bridgeMaker) {
		List<String> brigeValue = bridgeMaker.makeBridge(size);
		return new Bridge(brigeValue);
	}
	
	public boolean isBridgeEnd(int currentPosition) {
		return value.size() == currentPosition;
	}
}
