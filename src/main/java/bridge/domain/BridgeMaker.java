package bridge.domain;

import bridge.service.bridgeNumberGenerator.BridgeNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {
    
    private final BridgeNumberGenerator bridgeNumberGenerator;
    
    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }
    
    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            bridge.add(makeOneStep());
        }
        return bridge;
    }
    
    private String makeOneStep() {
        Step step = Step.from(bridgeNumberGenerator.generate());
        return step.getValue();
    }
}
