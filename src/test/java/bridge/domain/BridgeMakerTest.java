package bridge.domain;

import bridge.service.bridgeNumberGenerator.BridgeNumberGenerator;
import bridge.testUtil.TestNumberGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

public class BridgeMakerTest {
	
	@Test
	void 정상적으로_다리를_생성한다() {
		//given
		BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0));
		BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
		
		//when
		List<String> bridge = bridgeMaker.makeBridge(3);
		
		//then
		assertThat(bridge).containsExactly("U", "D", "D");
	}
}
