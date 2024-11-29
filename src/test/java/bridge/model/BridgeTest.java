package bridge.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class BridgeTest {
    @Test
    public void 다리_정상_테스트() throws Exception{
        //given
        List<String> bridgeList = new ArrayList<>(List.of("U", "D", "D"));
        //when
        Bridge bridge = new Bridge(bridgeList);
        //then
        assertEquals(bridge.size(), 3);
        assertEquals(bridge.get(0), "U");
        assertEquals(bridge.get(1), "D");
        assertEquals(bridge.get(2), "D");
    }
    @Test
    public void 다리_추가_기능_정상_테스트() throws Exception{
        //given
        List<String> bridgeList = new ArrayList<>(List.of("U", "D", "D"));
        //when
        Bridge bridge = new Bridge(bridgeList);
        bridge.add("U");
        //then
        assertEquals(bridge.size(), 4);
        assertEquals(bridge.get(3), "U");
    }
}