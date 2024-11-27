package bridge.service.bridgeService;

import bridge.common.dto.MoveResult;
import bridge.domain.*;
import bridge.service.bridgeNumberGenerator.BridgeNumberGenerator;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class DefaultBridgeService implements BridgeService {
	
	@Override
	public BridgeGame createBridgeGame(BridgeNumberGenerator bridgeNumberGenerator, Supplier<Integer> bridgeSizeSupplier) {
		Integer bridgeSize = bridgeSizeSupplier.get();
		BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
		Bridge bridge = Bridge.from(bridgeSize, bridgeMaker);
		return new BridgeGame(bridge);
	}
	
	@Override
	public MoveResult playOneStep(BridgeGame bridgeGame, Supplier<MoveCommand> moveSupplier, Consumer<MoveResult> moveResultConsumer) {
		MoveCommand moveCommand = moveSupplier.get();
		MoveResult moveResult = bridgeGame.move(moveCommand);
		moveResultConsumer.accept(moveResult);
		return moveResult;
	}
	
	@Override
	public boolean restartPlay(BridgeGame bridgeGame, Supplier<RestartCommand> restartCommandSupplier) {
		RestartCommand restartCommand = restartCommandSupplier.get();
		if (restartCommand.isRestart()) {
			bridgeGame.restart();
			return true;
		}
		return false;
	}
}
