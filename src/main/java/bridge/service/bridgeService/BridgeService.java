package bridge.service.bridgeService;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.service.bridgeNumberGenerator.BridgeRandomNumberGenerator;

import java.util.function.Supplier;

public interface BridgeService {
	
	BridgeGame createBridgeGame(Supplier<Integer> bridgeSizeSupplier);
}
