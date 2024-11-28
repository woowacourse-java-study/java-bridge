package bridge.config.io;

import bridge.config.io.writer.WriterConfig;
import bridge.io.output.OutputParser;
import bridge.io.output.OutputView;

public class OutputViewConfig {
	
	private final OutputView outputView;
	
	public OutputViewConfig(WriterConfig writerConfig) {
		this.outputView = new OutputView(
				writerConfig.getWriter(),
				new OutputParser()
		);
	}
	
	public OutputView getOutputView() {
		return outputView;
	}
}
