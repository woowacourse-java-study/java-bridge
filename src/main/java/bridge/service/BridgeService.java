package bridge.service;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.service.bridgeNumberGenerator.BridgeRandomNumberGenerator;

public class BridgeService {
	
	public BridgeGame createBridgeGame(int bridgeSize) {
		BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
		Bridge bridge = Bridge.from(bridgeSize, bridgeMaker);
		return new BridgeGame(bridge);
	}
}
