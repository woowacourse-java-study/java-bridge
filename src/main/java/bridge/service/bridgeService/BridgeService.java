package bridge.service.bridgeService;

import bridge.common.dto.MoveResult;
import bridge.domain.BridgeGame;
import bridge.domain.MoveCommand;
import bridge.domain.RestartCommand;
import bridge.service.bridgeNumberGenerator.BridgeNumberGenerator;

import java.util.function.Consumer;
import java.util.function.Supplier;

public interface BridgeService {
	
	BridgeGame createBridgeGame(
			BridgeNumberGenerator bridgeNumberGenerator,
			Supplier<Integer> bridgeSizeSupplier
	);
	
	MoveResult playOneStep(
			BridgeGame bridgeGame,
			Supplier<MoveCommand> moveSupplier,
			Consumer<MoveResult> moveResultConsumer
	);
	
	boolean restartPlay(BridgeGame bridgeGame, Supplier<RestartCommand> restartCommandSupplier);
}
