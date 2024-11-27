package bridge.testUtil;

import bridge.service.bridgeNumberGenerator.BridgeNumberGenerator;

import java.util.List;

public class TestNumberGenerator implements BridgeNumberGenerator {
	
	private final List<Integer> numbers;
	
	public TestNumberGenerator(List<Integer> numbers) {
		this.numbers = numbers;
	}
	
	@Override
	public int generate() {
		return numbers.remove(0);
	}
}