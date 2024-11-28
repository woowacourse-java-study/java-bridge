package bridge.config.io;

import bridge.config.io.reader.ReaderConfig;
import bridge.config.io.writer.WriterConfig;
import bridge.io.input.InputParser;
import bridge.io.input.InputValidator;
import bridge.io.input.InputView;

public class InputViewConfig {
	
	private final InputView inputView;
	
	public InputViewConfig(ReaderConfig readerConfig, WriterConfig writerConfig) {
		this.inputView = new InputView(
				readerConfig.getReader(),
				writerConfig.getWriter(),
				new InputValidator(),
				new InputParser()
		);
	}
	
	public InputView getInputView() {
		return inputView;
	}
}
