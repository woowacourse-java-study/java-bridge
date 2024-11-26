package bridge.config.io.writer;

import bridge.io.writer.ConsoleWriter;
import bridge.io.writer.Writer;

public class DefaultWriterConfig implements WriterConfig {
	
	private final Writer writer;
	
	public DefaultWriterConfig() {
		this.writer = new ConsoleWriter();
	}
	
	@Override
	public Writer getWriter() {
		return writer;
	}
}
