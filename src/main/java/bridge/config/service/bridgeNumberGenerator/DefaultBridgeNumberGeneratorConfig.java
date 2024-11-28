package bridge.config.service.bridgeNumberGenerator;

import bridge.service.bridgeNumberGenerator.BridgeNumberGenerator;
import bridge.service.bridgeNumberGenerator.BridgeRandomNumberGenerator;

public class DefaultBridgeNumberGeneratorConfig implements BridgeNumberGeneratorConfig {
	
	private final BridgeNumberGenerator bridgeNumberGenerator;
	
	public DefaultBridgeNumberGeneratorConfig() {
		this.bridgeNumberGenerator = new BridgeRandomNumberGenerator();
	}
	
	@Override
	public BridgeNumberGenerator getBridgeNumberGenerator() {
		return bridgeNumberGenerator;
	}
}
