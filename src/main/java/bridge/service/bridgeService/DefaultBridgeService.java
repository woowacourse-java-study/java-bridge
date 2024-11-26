package bridge.service.bridgeService;

import bridge.domain.*;
import bridge.domain.vo.MoveResult;
import bridge.service.bridgeNumberGenerator.BridgeRandomNumberGenerator;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class DefaultBridgeService implements BridgeService {
	
	@Override
	public BridgeGame createBridgeGame(Supplier<Integer> bridgeSizeSupplier) {
		Integer bridgeSize = bridgeSizeSupplier.get();
		BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
		Bridge bridge = Bridge.from(bridgeSize, bridgeMaker);
		return new BridgeGame(bridge);
	}
	
	@Override
	public MoveResult playOneStep(BridgeGame bridgeGame, Supplier<Move> moveSupplier, Consumer<MoveResult> moveResultConsumer) {
		Move move = moveSupplier.get();
		MoveResult moveResult = bridgeGame.move(move);
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
