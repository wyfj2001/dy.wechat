package dy.wechat.common;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.Writer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public enum JsonMapper {

	instance;
	
	private ObjectMapper mapper = new ObjectMapper();
	
	public void initial(ObjectMapper mapper) {
		this.mapper = mapper;
	}

	public <T> T readValue(String content, Class<T> valueType) throws IOException, JsonParseException, JsonMappingException {
		return mapper.readValue(content, valueType);
	}

	public <T> T readValue(String content, JavaType valueType) throws IOException, JsonParseException, JsonMappingException {
		return mapper.readValue(content, valueType);
	}

	public <T> T readValue(Reader src, Class<T> valueType) throws IOException, JsonParseException, JsonMappingException {
		return mapper.readValue(src, valueType);
	}

	public <T> T readValue(Reader src, JavaType valueType) throws IOException, JsonParseException, JsonMappingException {
		return mapper.readValue(src, valueType);
	}

	public <T> T readValue(InputStream src, Class<T> valueType) throws IOException, JsonParseException, JsonMappingException {
		return mapper.readValue(src, valueType);
	}

	public <T> T readValue(InputStream src, JavaType valueType) throws IOException, JsonParseException, JsonMappingException {
		return mapper.readValue(src, valueType);
	}

	public String writeValueAsString(Object value) throws JsonProcessingException {
		return mapper.writeValueAsString(value);
	}

	public <T> T convertValue(Object fromValue, Class<T> toValueType) throws IllegalArgumentException {
		return mapper.convertValue(fromValue, toValueType);
	}

	public <T> T convertValue(Object fromValue, JavaType toValueType) throws IllegalArgumentException {
		return mapper.convertValue(fromValue, toValueType);
	}

	public void writeValue(Writer w, Object value) throws IOException, JsonGenerationException, JsonMappingException {
		mapper.writeValue(w, value);
	}
	
	
}
