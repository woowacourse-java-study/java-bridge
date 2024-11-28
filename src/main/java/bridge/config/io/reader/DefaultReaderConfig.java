package bridge.config.io.reader;

import bridge.io.reader.MissionUtilsReader;
import bridge.io.reader.Reader;

public class DefaultReaderConfig implements ReaderConfig {
	
	private final Reader reader;
	
	public DefaultReaderConfig() {
		this.reader = new MissionUtilsReader();
	}
	
	@Override
	public Reader getReader() {
		return reader;
	}
}
