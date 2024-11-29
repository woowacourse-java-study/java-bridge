package bridge;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class BridgeMakerTest {
    BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    @Test
    public void 다리_생성_정상_테스트() throws Exception {

        //given
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

        //when
        List<String> bridge = bridgeMaker.makeBridge(3);

        //then
        assertEquals(3, bridge.size());

    }
}