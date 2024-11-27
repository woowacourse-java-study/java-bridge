package bridge.domain;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StepTest {
	
	@Nested
	class 생성_테스트 {
		
		@Test
		void 숫자를_통해_위를_정상적으로_생성한다() {
			//given
			
			//when
			Step result = Step.from(1);
			
			//then
			assertThat(result).isEqualTo(Step.UP_VALID);
		}
		
		@Test
		void 숫자를_통해_아래를_정상적으로_생성한다() {
			//given
			
			//when
			Step result = Step.from(0);
			
			//then
			assertThat(result).isEqualTo(Step.DOWN_VALID);
		}
		
		@Test
		void 문자열_배열을_통해_정상적으로_생성한다() {
			//given
			List<String> inputs = List.of("U", "D", "U");
			
			//when
			List<Step> result = Step.fromList(inputs);
			
			//then
			assertThat(result).containsExactly(Step.UP_VALID, Step.DOWN_VALID, Step.UP_VALID);
		}
		
		@Test
		void 문자열_배열을_통해_비정상적으로_생성한다() {
			//given
			List<String> inputs = List.of("U", "a", "U");
			
			//expected
			assertThatThrownBy(() -> Step.fromList(inputs))
					.isInstanceOf(IllegalArgumentException.class)
					.hasMessage("다리 단계는 U또는 D만 가능합니다.");
		}
	}
}
