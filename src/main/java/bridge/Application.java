package bridge;

import bridge.controller.BridgeController;
import bridge.io.InputView;
import bridge.io.OutputView;
import bridge.io.reader.MissionUtilsReader;
import bridge.io.writer.ConsoleWriter;

public class Application {

    public static void main(String[] args) {
        MissionUtilsReader reader = new MissionUtilsReader();
        ConsoleWriter writer = new ConsoleWriter();
        new BridgeController(
                new InputView(reader, writer),
                new OutputView(writer)
        ).run();
    }
}
