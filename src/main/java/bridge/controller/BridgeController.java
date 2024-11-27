package bridge.controller;

import bridge.domain.*;
import bridge.domain.vo.GameResult;
import bridge.domain.vo.MoveResult;
import bridge.io.input.InputView;
import bridge.io.output.OutputView;
import bridge.service.bridgeNumberGenerator.BridgeNumberGenerator;
import bridge.service.bridgeService.BridgeService;

public class BridgeController implements Controller {
	
	private final InputView inputView;
	private final OutputView outputView;
	private final BridgeService bridgeService;
	private final BridgeNumberGenerator bridgeNumberGenerator;
	
	public BridgeController(InputView inputView, OutputView outputView, BridgeService bridgeService, BridgeNumberGenerator bridgeNumberGenerator) {
		this.inputView = inputView;
		this.outputView = outputView;
		this.bridgeService = bridgeService;
		this.bridgeNumberGenerator = bridgeNumberGenerator;
	}
	
	@Override
	public void run() {
		outputView.printGreetings();
		BridgeGame bridgeGame = bridgeService.createBridgeGame(bridgeNumberGenerator, inputView::readBridgeSize);
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
