package bridge.io.input;

import bridge.domain.MoveCommand;
import bridge.domain.RestartCommand;
import bridge.io.reader.Reader;
import bridge.io.writer.Writer;

public class InputView {
    
    private final Reader reader;
    private final Writer writer;
    private final InputValidator inputValidator;
    private final InputParser inputParser;
    
    public InputView(Reader reader, Writer writer, InputValidator inputValidator, InputParser inputParser) {
        this.reader = reader;
        this.writer = writer;
        this.inputValidator = inputValidator;
        this.inputParser = inputParser;
    }
    
    public int readBridgeSize() {
        writer.write("\n다리의 길이를 입력해주세요.\n");
        String input = reader.readLine();
        inputValidator.validateBridgeSize(input);
        return inputParser.parseBridgeSize(input);
    }

    public MoveCommand readMoveCommand() {
        writer.write("\n이동할 칸을 선택해주세요. (위: U, 아래: D)\n");
        String input = reader.readLine();
        inputValidator.validateMoveCommand(input);
        return inputParser.parseMoveCommand(input);
    }

    public RestartCommand readGameCommand() {
        writer.write("\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)\n");
        String input = reader.readLine();
        inputValidator.validateRestartCommand(input);
        return inputParser.parseRestartCommand(input);
    }
}
