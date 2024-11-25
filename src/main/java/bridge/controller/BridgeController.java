package bridge.controller;

import bridge.domain.*;
import bridge.io.InputView;
import bridge.io.OutputView;
import bridge.service.bridgeNumberGenerator.BridgeRandomNumberGenerator;

public class BridgeController {
	
	private final InputView inputView;
	private final OutputView outputView;
	
	public BridgeController(InputView inputView, OutputView outputView) {
		this.inputView = inputView;
		this.outputView = outputView;
	}
	
	public void run() {
		outputView.printGreetings();
		int bridgeSize = inputView.readBridgeSize();
		BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
		Bridge bridge = Bridge.from(bridgeSize, bridgeMaker);
		BridgeGame bridgeGame = new BridgeGame(bridge);
		
		MoveStatus moveStatus;
		while(true) {
			Move move = inputView.readMoving();
			moveStatus = bridgeGame.move(move);
			outputView.printMap(moveStatus);
			
			if (moveStatus.isFail()) {
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
		
		GameResult gameResult = bridgeGame.getGameResult(moveStatus);
		outputView.printResult(gameResult);
	}
}
