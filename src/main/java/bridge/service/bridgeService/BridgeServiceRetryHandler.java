package bridge.service.bridgeService;

import bridge.domain.BridgeGame;
import bridge.service.retryHandler.RetryHandler;

import java.util.function.Supplier;

public class BridgeServiceRetryHandler implements BridgeService {
	
	private final BridgeService bridgeService;
	private final RetryHandler retryHandler;
	
	public BridgeServiceRetryHandler(BridgeService bridgeService, RetryHandler retryHandler) {
		this.bridgeService = bridgeService;
		this.retryHandler = retryHandler;
	}
	
	@Override
	public BridgeGame createBridgeGame(Supplier<Integer> bridgeSizeSupplier) {
		return retryHandler.tryUntilSuccess(() -> bridgeService.createBridgeGame(bridgeSizeSupplier));
	}
}
