package bridge.model;

import java.util.List;

public class Bridge {
    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public int size() {
        return bridge.size();
    }

    public String get(int i) {
        return bridge.get(i);
    }

    public void add(String block) {
        bridge.add(block);
    }

}
