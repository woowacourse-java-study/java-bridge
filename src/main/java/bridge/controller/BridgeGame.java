package bridge.controller;

import bridge.BridgeMaker;
import bridge.constant.GameValue;
import bridge.dto.ResultBridgeDto;
import bridge.dto.StackDto;
import bridge.model.Bridge;
import bridge.model.Parser;
import bridge.model.Referee;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGame {
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;
    private final Referee referee;
    private final Parser parser;

    public BridgeGame(InputView inputView, OutputView outputView, BridgeMaker bridgeMaker, Referee referee,
                      Parser parser) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeMaker = bridgeMaker;
        this.referee = referee;
        this.parser = parser;
    }

    public void run() {
        outputView.printGameIntro();

        Bridge gameBridge = makeBridge();
        ResultBridgeDto resultBridgeDto = new ResultBridgeDto();
        StackDto stackDto = new StackDto();

        boolean isGameWin = processGame(gameBridge, resultBridgeDto, stackDto);
        outputView.printResult(resultBridgeDto, stackDto, isGameWin);
    }


    public Bridge makeBridge() {
        int bridgeSize = getBridgeSize();
        return new Bridge(bridgeMaker.makeBridge(bridgeSize));
    }

    public boolean move(Bridge gameBridge, ResultBridgeDto resultBridgeDto, StackDto tryStackDto) {
        while (true) {
            String moveCommand = getMove();
            tryStackDto.plusOneBlockStack();
            boolean moveResult = referee.judge(gameBridge, resultBridgeDto, moveCommand, tryStackDto);
            outputView.printMap(resultBridgeDto);
            boolean gameResult = referee.isWin(gameBridge, resultBridgeDto, tryStackDto);
            if (!moveResult) {
                return false;
            }
            if (gameResult) {
                return true;
            }
        }
    }

    public boolean retry(StackDto tryStackDto, ResultBridgeDto resultBridgeDto) {
        tryStackDto.resetBlockStack();
        resultBridgeDto.resetResultBridge();
        String retryCommand = getRetry();
        return retryCommand.equals(GameValue.RETRY);
    }

    private boolean processGame(Bridge gameBridge, ResultBridgeDto resultBridgeDto, StackDto stackDto) {
        while (true) {
            stackDto.plusOneTryStack();
            boolean gameResult = move(gameBridge, resultBridgeDto, stackDto);
            if (gameResult) {
                return true;
            }
            boolean retryResult = retry(stackDto, resultBridgeDto);
            if (!retryResult) {
                return false;
            }
        }
    }

    private String getRetry() {
        while (true) {
            try {
                String rawRetry = inputView.readGameCommand();
                return parser.retryParser(rawRetry);
            } catch (IllegalStateException e) {
                outputView.printError(e.getMessage());
            }
        }
    }


    private String getMove() {
        while (true) {
            try {
                String rawMove = inputView.readMoving();
                return parser.moveParser(rawMove);
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    private int getBridgeSize() {
        while (true) {
            try {
                String rawBridgeSize = inputView.readBridgeSize();
                return parser.bridgeSizeParser(rawBridgeSize);
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }
}
