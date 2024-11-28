package bridge.config.service.bridgeService;

import bridge.config.exceptionHandler.ExceptionHandlerConfig;
import bridge.service.bridgeService.BridgeService;
import bridge.service.bridgeService.BridgeServiceRetryProxy;
import bridge.service.bridgeService.DefaultBridgeService;
import bridge.service.retryHandler.RetryHandler;

public class DefaultBridgeServiceConfig implements BridgeServiceConfig {
	
	private final BridgeService bridgeService;
	
	public DefaultBridgeServiceConfig(ExceptionHandlerConfig exceptionHandlerConfig) {
		BridgeService bridgeService = new DefaultBridgeService();
		this.bridgeService = new BridgeServiceRetryProxy(bridgeService, new RetryHandler(exceptionHandlerConfig.getExceptionHandler()));
	}
	
	@Override
	public BridgeService getBridgeService() {
		return bridgeService;
	}
}
