package bridge;

import bridge.config.controller.DefaultBridgeControllerConfig;
import bridge.config.exceptionHandler.ExceptionHandlerConfig;
import bridge.config.io.InputViewConfig;
import bridge.config.io.OutputViewConfig;
import bridge.config.io.reader.DefaultReaderConfig;
import bridge.config.io.writer.DefaultWriterConfig;
import bridge.config.io.writer.WriterConfig;
import bridge.config.service.bridgeNumberGenerator.BridgeNumberGeneratorConfig;
import bridge.config.service.bridgeNumberGenerator.DefaultBridgeNumberGeneratorConfig;
import bridge.config.service.bridgeService.BridgeServiceConfig;
import bridge.config.service.bridgeService.DefaultBridgeServiceConfig;
import bridge.controller.Controller;

public class BridgeApplication {
	
	private static Controller controller;
	
	public static void run() {
		if (controller == null) {
			initController();
		}
		controller.run();
	}
	
	private static void initController() {
		WriterConfig writerConfig = new DefaultWriterConfig();
		ExceptionHandlerConfig exceptionHandlerConfig = new ExceptionHandlerConfig(writerConfig);
		
		InputViewConfig inputViewConfig = new InputViewConfig(new DefaultReaderConfig(), writerConfig);
		OutputViewConfig outputViewConfig = new OutputViewConfig(writerConfig);
		BridgeServiceConfig bridgeServiceConfig = new DefaultBridgeServiceConfig(exceptionHandlerConfig);
		BridgeNumberGeneratorConfig numberGeneratorConfig = new DefaultBridgeNumberGeneratorConfig();
		
		controller = new DefaultBridgeControllerConfig(
				inputViewConfig,
				outputViewConfig,
				bridgeServiceConfig,
				numberGeneratorConfig,
				exceptionHandlerConfig
		).getController();
	}
}
