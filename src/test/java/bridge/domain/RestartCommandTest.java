package bridge.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RestartCommandTest {
	
	@Nested
	class 생성_테스트 {
		
		@ParameterizedTest
		@ValueSource(strings = {"R", "Q"})
		void 정상적으로_생성한다(String input) {
		    //given
		    
		    //expected
			assertThatCode(() -> RestartCommand.from(input))
					.doesNotThrowAnyException();
		}
		
		@ParameterizedTest
		@ValueSource(strings = {"a", "b", "r", "q", "1", "2"})
		void 비정상적으로_생성한다(String input) {
			//given
			
			//expected
			assertThatThrownBy(() -> RestartCommand.from(input))
					.isInstanceOf(IllegalArgumentException.class)
					.hasMessage("재시작은 R또는 Q만 가능합니다.");
		}
	}
}
