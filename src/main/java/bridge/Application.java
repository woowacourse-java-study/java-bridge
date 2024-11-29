package bridge;

import bridge.config.AppConfig;
import bridge.controller.BridgeGame;

public class Application {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        BridgeGame bridgeGame = appConfig.bridgeGame();
        bridgeGame.run();
    }

}
