package bridge.service.bridgeService;

import bridge.domain.BridgeGame;
import bridge.domain.Move;
import bridge.domain.RestartCommand;
import bridge.common.dto.MoveResult;
import bridge.service.bridgeNumberGenerator.BridgeNumberGenerator;
import bridge.service.retryHandler.RetryHandler;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class BridgeServiceRetryProxy implements BridgeService {
	
	private final BridgeService bridgeService;
	private final RetryHandler retryHandler;
	
	public BridgeServiceRetryProxy(BridgeService bridgeService, RetryHandler retryHandler) {
		this.bridgeService = bridgeService;
		this.retryHandler = retryHandler;
	}
	
	@Override
	public BridgeGame createBridgeGame(BridgeNumberGenerator bridgeNumberGenerator, Supplier<Integer> bridgeSizeSupplier) {
		return retryHandler.tryUntilSuccess(() -> bridgeService.createBridgeGame(bridgeNumberGenerator, bridgeSizeSupplier));
	}
	
	@Override
	public MoveResult playOneStep(BridgeGame bridgeGame, Supplier<Move> moveSupplier, Consumer<MoveResult> moveResultConsumer) {
		return retryHandler.tryUntilSuccess(() -> bridgeService.playOneStep(bridgeGame, moveSupplier, moveResultConsumer));
	}
	
	@Override
	public boolean restartPlay(BridgeGame bridgeGame, Supplier<RestartCommand> restartCommandSupplier) {
		return retryHandler.tryUntilSuccess(() -> bridgeService.restartPlay(bridgeGame, restartCommandSupplier));
	}
}
