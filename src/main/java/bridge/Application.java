package bridge;

import bridge.controller.BridgeController;
import bridge.controller.Controller;
import bridge.controller.ControllerExceptionHandleProxy;
import bridge.exception.ExceptionHandler;
import bridge.io.InputView;
import bridge.io.OutputView;
import bridge.io.reader.MissionUtilsReader;
import bridge.io.reader.Reader;
import bridge.io.writer.ConsoleWriter;
import bridge.io.writer.Writer;

public class Application {

    public static void main(String[] args) {
        Reader reader = new MissionUtilsReader();
        Writer writer = new ConsoleWriter();
        Controller controller = new BridgeController(
                new InputView(reader, writer),
                new OutputView(writer)
        );
        new ControllerExceptionHandleProxy(
                controller,
                new ExceptionHandler(writer)
        ).run();
    }
}
