package bridge.controller;

import bridge.domain.*;
import bridge.domain.vo.GameResult;
import bridge.domain.vo.MoveResult;
import bridge.io.InputView;
import bridge.io.OutputView;
import bridge.service.bridgeService.BridgeService;

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
		BridgeGame bridgeGame = bridgeService.createBridgeGame(inputView::readBridgeSize);
		playBridgeGame(bridgeGame);
		GameResult gameResult = bridgeGame.getGameResult();
		outputView.printResult(gameResult);
	}
	
	private void playBridgeGame(BridgeGame bridgeGame) {
		while(!bridgeGame.isBridgeGameSuccess()) {
			MoveResult moveResult = bridgeService.playOneStep(bridgeGame, inputView::readMoving, outputView::printMap);
			
			if (moveResult.isFail() && !bridgeService.restartPlay(bridgeGame, inputView::readGameCommand)) {
				break;
			}
		}
	}
}
