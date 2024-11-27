package bridge.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MoveCommandTest {
	
	@Nested
	class 생성_테스트 {
		
		@ParameterizedTest
		@ValueSource(strings = {"U, D"})
		void 정상적으로_생성한다(String input) {
		    //given
			
		    //expected
			assertThatCode(() -> MoveCommand.from(input))
					.doesNotThrowAnyException();
		}
		
		@ParameterizedTest
		@ValueSource(strings = {"q", "a", "1", "12", "u", "d"})
		void 비정상적으로_생성한다(String input) {
			//given
			
			//expected
			assertThatThrownBy(() -> MoveCommand.from(input))
					.isInstanceOf(IllegalArgumentException.class)
					.hasMessage("움직임은 U또는 D만 가능합니다.");
		}
	}
}
