package bridge.service.bridgeService;

import bridge.domain.*;
import bridge.domain.vo.MoveResult;

import java.util.function.Consumer;
import java.util.function.Supplier;

public interface BridgeService {
	
	BridgeGame createBridgeGame(Supplier<Integer> bridgeSizeSupplier);
	
	MoveResult playOneStep(
			BridgeGame bridgeGame,
			Supplier<Move> moveSupplier,
			Consumer<MoveResult> moveResultConsumer
	);
}
