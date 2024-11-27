package bridge.domain;

import bridge.common.dto.StepResult;
import bridge.testUtil.TestNumberGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.util.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.*;

class BridgeTest {
	
	@Nested
	class 생성_테스트 {
		
		@Test
		void 정상적으로_생성한다() {
			//given
			TestNumberGenerator testNumberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0));
			BridgeMaker bridgeMaker = new BridgeMaker(testNumberGenerator);
			
			//expected
			assertThatCode(() -> Bridge.from(3, bridgeMaker))
					.doesNotThrowAnyException();
		}
		
		@Test
		void 다리길이를_짧게_생성한다() {
			//given
			TestNumberGenerator testNumberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0));
			BridgeMaker bridgeMaker = new BridgeMaker(testNumberGenerator);
			
			//expected
			assertThatThrownBy(() -> Bridge.from(2, bridgeMaker))
					.isInstanceOf(IllegalArgumentException.class)
					.hasMessage("다리길이는 3부터 20 사이의 숫자여야 합니다.");
		}
		
		@Test
		void 다리길이를_길게_생성한다() {
			//given
			TestNumberGenerator testNumberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0));
			BridgeMaker bridgeMaker = new BridgeMaker(testNumberGenerator);
			
			//expected
			assertThatThrownBy(() -> Bridge.from(2, bridgeMaker))
					.isInstanceOf(IllegalArgumentException.class)
					.hasMessage("다리길이는 3부터 20 사이의 숫자여야 합니다.");
		}
	}
	
	@Nested
	class 움직이기_테스트 {
		
		private static Bridge bridge;
		
		@BeforeEach
		void setUp() {
			TestNumberGenerator testNumberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0));
			BridgeMaker bridgeMaker = new BridgeMaker(testNumberGenerator);
			bridge = Bridge.from(3, bridgeMaker);
		}
		
		@Test
		void 정상적으로_움직여서_성공한다() {
		    //given
			
			//when
			StepResult result = bridge.move(0, MoveCommand.UP_MOVE);
		    
		    //then
			assertThat(result)
					.extracting(
							"step", "moveCommand", "isSuccess"
					).containsExactly(
							0, MoveCommand.UP_MOVE, true
					);
		}
		
		@Test
		void 정상적으로_움직여서_실패한다() {
			//given
			
			//when
			StepResult result = bridge.move(0, MoveCommand.DOWN_MOVE);
			
			//then
			assertThat(result)
					.extracting(
							"step", "moveCommand", "isSuccess"
					).containsExactly(
							0, MoveCommand.DOWN_MOVE, false
					);
		}
	}

	@Nested
	class 다리_끝_확인_테스트 {
		
		private static Bridge bridge;
		
		@BeforeEach
		void setUp() {
			TestNumberGenerator testNumberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0));
			BridgeMaker bridgeMaker = new BridgeMaker(testNumberGenerator);
			bridge = Bridge.from(3, bridgeMaker);
		}
		
		@ParameterizedTest
		@ValueSource(ints = {3, 4, 5})
		void 다리가_끝났음을_확인한다(int position) {
		    //given
		    
		    //when
			boolean result = bridge.isBridgeEnd(position);
			
			//then
			Assertions.assertThat(result).isTrue();
		}
		
		@ParameterizedTest
		@ValueSource(ints = {0, 1, 2})
		void 다리가_끝나지_않음을_확인한다(int position) {
			//given
			
			//when
			boolean result = bridge.isBridgeEnd(position);
			
			//then
			Assertions.assertThat(result).isFalse();
		}
	}
}
