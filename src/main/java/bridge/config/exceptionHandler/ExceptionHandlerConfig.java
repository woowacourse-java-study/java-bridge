package bridge.config.exceptionHandler;

import bridge.config.io.writer.WriterConfig;
import bridge.common.exception.ExceptionHandler;

public class ExceptionHandlerConfig {
	
	private final ExceptionHandler exceptionHandler;
	
	public ExceptionHandlerConfig(WriterConfig writerConfig) {
		this.exceptionHandler = new ExceptionHandler(writerConfig.getWriter());
	}
	
	public ExceptionHandler getExceptionHandler() {
		return exceptionHandler;
	}
}
