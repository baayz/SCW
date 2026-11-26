package daniillnull.scw.util;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class ScwInputStream extends DataInputStream {
	private final ScwConfig config;

	public ScwInputStream(byte[] data) {
		this(new ByteArrayInputStream(data));
	}

	public ScwInputStream(InputStream in) {
		super(in);
		config = new ScwConfig();
	}

	public String readSectionName() throws IOException {
		byte[] tmp = new byte[4];
		readFully(tmp);
		return new String(tmp, StandardCharsets.US_ASCII);
	}

	public int readCustomType(int size) throws IOException {
		int result = 0;
		for (int i = 0; i < size; i++) {
			result <<= 8;
			result |= readByte() & 0xFF;
		}
		return result;
	}

	public boolean hasAvailable() throws IOException {
		return (available() > 0);
	}

	public ScwConfig getConfig() {
		return config;
	}

	public void updateConfig(ScwConfig source) {
		config.version = source.version;
		config.frameRate = source.frameRate;
	}
}
