package bridge.controller;

import bridge.domain.*;
import bridge.domain.vo.GameResult;
import bridge.domain.vo.MoveResult;
import bridge.io.InputView;
import bridge.io.OutputView;
import bridge.service.BridgeService;

public class BridgeController implements Controller {
	
	private final InputView inputView;
	private final OutputView outputView;
	private final BridgeService bridgeService;
	
	public BridgeController(InputView inputView, OutputView outputView, BridgeService bridgeService) {
		this.inputView = inputView;
		this.outputView = outputView;
		this.bridgeService = bridgeService;
	}
	
	@Override
	public void run() {
		outputView.printGreetings();
		int bridgeSize = inputView.readBridgeSize();
		
		BridgeGame bridgeGame = bridgeService.createBridgeGame(bridgeSize);
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
