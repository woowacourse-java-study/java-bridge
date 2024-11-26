package bridge.controller;

import bridge.domain.*;
import bridge.domain.vo.GameResult;
import bridge.domain.vo.MoveResult;
import bridge.io.InputView;
import bridge.io.OutputView;
import bridge.service.bridgeNumberGenerator.BridgeRandomNumberGenerator;

public class BridgeController implements Controller {
	
	private final InputView inputView;
	private final OutputView outputView;
	
	public BridgeController(InputView inputView, OutputView outputView) {
		this.inputView = inputView;
		this.outputView = outputView;
	}
	
	@Override
	public void run() {
		outputView.printGreetings();
		int bridgeSize = inputView.readBridgeSize();
		BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
		Bridge bridge = Bridge.from(bridgeSize, bridgeMaker);
		BridgeGame bridgeGame = new BridgeGame(bridge);
		
		MoveResult moveResult;
		while(true) {
			Move move = inputView.readMoving();
			moveResult = bridgeGame.move(move);
			outputView.printMap(moveResult);
			
			if (moveResult.isFail()) {
				RestartCommand restartCommand = inputView.readGameCommand();
				if (restartCommand.shouldRestart()) {
					bridgeGame.retry();
					continue;
				}
				break;
			}
			
			if (bridgeGame.isBridgeGameSuccess()) {
				break;
			}
		}
		
		GameResult gameResult = bridgeGame.getGameResult(moveResult);
		outputView.printResult(gameResult);
	}
}
