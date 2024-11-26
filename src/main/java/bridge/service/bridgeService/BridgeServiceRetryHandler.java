package bridge.service.bridgeService;

import bridge.domain.BridgeGame;
import bridge.domain.Move;
import bridge.domain.RestartCommand;
import bridge.domain.vo.MoveResult;
import bridge.service.retryHandler.RetryHandler;

import java.util.function.Consumer;
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
	
	@Override
	public MoveResult playOneStep(BridgeGame bridgeGame, Supplier<Move> moveSupplier, Consumer<MoveResult> moveResultConsumer) {
		return retryHandler.tryUntilSuccess(() -> bridgeService.playOneStep(bridgeGame, moveSupplier, moveResultConsumer));
	}
}
