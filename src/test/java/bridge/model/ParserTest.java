package bridge.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ParserTest {
    Parser parser = new Parser();

    @Test
    public void 다리_길이_입력_정상_테스트() throws Exception {
        //when
        int result = parser.bridgeSizeParser("3");

        //then
        assertEquals(3, result);
    }

    @Test
    public void 다리_길이_빈값_입력_예외_테스트() throws Exception {
        //then
        assertThrows(IllegalArgumentException.class, () -> {
            parser.bridgeSizeParser("");
        });
    }

    @Test
    public void 다리_길이_문자_입력_예외_테스트() throws Exception {
        //then
        assertThrows(IllegalArgumentException.class, () -> {
            parser.bridgeSizeParser("A");
        });
    }

    @Test
    public void 다리_길이_범위_입력_예외_테스트() throws Exception {
        //then
        assertThrows(IllegalArgumentException.class, () -> {
            parser.bridgeSizeParser("55");
        });
    }
    @Test
    public void 이동할_칸_입력_정상_테스트() throws Exception {
        //when
        String result = parser.moveParser("U");

        //then
        assertEquals("U", result);
    }
    @Test
    public void 이동할_칸_입력_예외_테스트() throws Exception {
        //then
        assertThrows(IllegalArgumentException.class, () -> {
            parser.moveParser("R");
        });
    }
    @Test
    public void 재시도_입력_정상_테스트() throws Exception {
        //when
        String result = parser.retryParser("R");

        //then
        assertEquals("R", result);
    }
    @Test
    public void 재시도_입력_예외_테스트() throws Exception {
        //then
        assertThrows(IllegalArgumentException.class, () -> {
            parser.retryParser("U");
        });
    }

}