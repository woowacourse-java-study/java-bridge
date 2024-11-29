package bridge.config;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.controller.BridgeGame;
import bridge.model.Parser;
import bridge.model.Referee;
import bridge.view.InputView;
import bridge.view.OutputView;

public class AppConfig {
    public BridgeGame bridgeGame() {
        return new BridgeGame(inputView(), outputView(), bridgeMaker(), referee(), parser());
    }

    public InputView inputView() {
        return new InputView();
    }

    public OutputView outputView() {
        return new OutputView();
    }

    public BridgeRandomNumberGenerator bridgeRandomNumberGenerator() {
        return new BridgeRandomNumberGenerator();
    }

    public BridgeMaker bridgeMaker() {
        return new BridgeMaker(bridgeRandomNumberGenerator());
    }

    public Referee referee() {
        return new Referee();
    }

    public Parser parser() {
        return new Parser();
    }
}
