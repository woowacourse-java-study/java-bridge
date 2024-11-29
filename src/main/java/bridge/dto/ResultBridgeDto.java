package bridge.dto;

import bridge.model.Bridge;
import java.util.ArrayList;

public class ResultBridgeDto {
    private Bridge upperBridge;
    private Bridge lowerBridge;

    public ResultBridgeDto() {
        this.upperBridge = new Bridge(new ArrayList<>());
        this.lowerBridge = new Bridge(new ArrayList<>());
    }

    public Bridge getUpperBridge() {
        return upperBridge;
    }

    public Bridge getLowerBridge() {
        return lowerBridge;
    }

    public void addUpperBridge(String block) {
        upperBridge.add(block);
    }

    public void addLowerBridge(String block) {
        lowerBridge.add(block);
    }

    public void resetResultBridge() {
        upperBridge = new Bridge(new ArrayList<>());
        lowerBridge = new Bridge(new ArrayList<>());
    }
}
