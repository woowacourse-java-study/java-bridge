package bridge.config.io;

import bridge.config.io.writer.WriterConfig;
import bridge.io.OutputView;

public class OutputViewConfig {
	
	private final OutputView outputView;
	
	public OutputViewConfig(WriterConfig writerConfig) {
		this.outputView = new OutputView(writerConfig.getWriter());
	}
	
	public OutputView getOutputView() {
		return outputView;
	}
}
