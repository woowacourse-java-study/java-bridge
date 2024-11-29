package bridge.model;

import static org.junit.jupiter.api.Assertions.*;

import bridge.dto.ResultBridgeDto;
import bridge.dto.StackDto;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class RefereeTest {
    Referee referee = new Referee();
    StackDto stack = new StackDto();
    ResultBridgeDto resultBridgeDto = new ResultBridgeDto();

    @Test
    public void 디리_비교_참_정상_테스트() throws Exception {
        //given
        Bridge gameBridge = new Bridge(new ArrayList<>(List.of("U", "U", "U")));
        stack.plusOneBlockStack();
        stack.plusOneTryStack();
        String input = "U";
        //when
        boolean result = referee.judge(gameBridge, resultBridgeDto, input, stack);
        //then
        assertTrue(result);
    }
    @Test
    public void 디리_비교_거짓_정상_테스트() throws Exception {
        //given
        Bridge gameBridge = new Bridge(new ArrayList<>(List.of("U", "U", "U")));
        stack.plusOneBlockStack();
        stack.plusOneTryStack();
        String input = "D";
        //when
        boolean result = referee.judge(gameBridge, resultBridgeDto, input, stack);
        //then
        assertFalse(result);
    }

    @Test
    public void 디리_승리조건_참_정상_테스트() throws Exception {
        //given
        Bridge gameBridge = new Bridge(new ArrayList<>(List.of("U", "U", "U")));
        stack.plusOneBlockStack();
        stack.plusOneTryStack();
        String input = "U";
        //when
        referee.judge(gameBridge, resultBridgeDto, input, stack);

        stack.plusOneBlockStack();
        referee.judge(gameBridge, resultBridgeDto, input, stack);
        stack.plusOneBlockStack();
        referee.judge(gameBridge, resultBridgeDto, input, stack);

        boolean result = referee.isWin(gameBridge,resultBridgeDto,stack);
        //then
        assertTrue(result);
    }

    @Test
    public void 디리_승리조건_거짓_정상_테스트() throws Exception {
        //given
        Bridge gameBridge = new Bridge(new ArrayList<>(List.of("U", "U", "U")));
        stack.plusOneBlockStack();
        stack.plusOneTryStack();
        String input = "U";
        //when
        referee.judge(gameBridge, resultBridgeDto, input, stack);
        boolean result = referee.isWin(gameBridge,resultBridgeDto,new StackDto());
        //then
        assertFalse(result);
    }

}