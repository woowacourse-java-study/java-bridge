package bridge.config.exceptionHandler;

import bridge.common.exception.ExceptionHandler;
import bridge.config.io.writer.WriterConfig;

public class ExceptionHandlerConfig {
	
	private final ExceptionHandler exceptionHandler;
	
	public ExceptionHandlerConfig(WriterConfig writerConfig) {
		this.exceptionHandler = new ExceptionHandler(writerConfig.getWriter());
	}
	
	public ExceptionHandler getExceptionHandler() {
		return exceptionHandler;
	}
}
