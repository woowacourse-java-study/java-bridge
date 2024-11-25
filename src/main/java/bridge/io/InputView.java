package bridge.io;

import bridge.io.reader.Reader;
import bridge.io.writer.Writer;

public class InputView {
    
    private final Reader reader;
    private final Writer writer;
    
    public InputView(Reader reader, Writer writer) {
        this.reader = reader;
        this.writer = writer;
    }
    
    public int readBridgeSize() {
        writer.write("다리의 길이를 입력해주세요.\n");
        return Integer.parseInt(reader.readLine());
    }

    public String readMoving() {
        writer.write("이동할 칸을 선택해주세요. (위: U, 아래: D)\n");
        return reader.readLine();
    }

    public String readGameCommand() {
        writer.write("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        return reader.readLine();
    }
}
