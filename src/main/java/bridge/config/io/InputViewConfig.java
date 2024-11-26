package bridge.config.io;

import bridge.config.io.reader.ReaderConfig;
import bridge.config.io.writer.WriterConfig;
import bridge.io.InputView;

public class InputViewConfig {
	
	private final InputView inputView;
	
	public InputViewConfig(ReaderConfig readerConfig, WriterConfig writerConfig) {
		this.inputView = new InputView(readerConfig.getReader(), writerConfig.getWriter());
	}
	
	public InputView getInputView() {
		return inputView;
	}
}
