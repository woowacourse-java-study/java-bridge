package bridge.config.controller;

import bridge.config.exceptionHandler.ExceptionHandlerConfig;
import bridge.config.io.InputViewConfig;
import bridge.config.io.OutputViewConfig;
import bridge.config.service.bridgeNumberGenerator.BridgeNumberGeneratorConfig;
import bridge.config.service.bridgeService.BridgeServiceConfig;
import bridge.controller.BridgeController;
import bridge.controller.Controller;
import bridge.controller.ControllerExceptionHandleProxy;

public class DefaultBridgeControllerConfig implements ControllerConfig {
	
	private final Controller controller;
	
	public DefaultBridgeControllerConfig(
			InputViewConfig inputViewConfig,
			OutputViewConfig outputViewConfig,
			BridgeServiceConfig bridgeServiceConfig,
			BridgeNumberGeneratorConfig numberGeneratorConfig,
			ExceptionHandlerConfig exceptionHandlerConfig
	) {
		BridgeController controller = new BridgeController(inputViewConfig.getInputView(), outputViewConfig.getOutputView(), bridgeServiceConfig.getBridgeService(), numberGeneratorConfig.getBridgeNumberGenerator());
		this.controller = new ControllerExceptionHandleProxy(controller, exceptionHandlerConfig.getExceptionHandler());
	}
	
	@Override
	public Controller getController() {
		return controller;
	}
}
