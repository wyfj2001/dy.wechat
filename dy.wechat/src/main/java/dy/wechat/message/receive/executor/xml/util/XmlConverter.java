package dy.wechat.message.receive.executor.xml.util;

import java.io.Reader;
import java.io.Writer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class XmlConverter {

	private final ConcurrentMap<Class<?>, JAXBContext> jaxbContexts = new ConcurrentHashMap<Class<?>, JAXBContext>(64);
	
	public void marshal(Object object, Writer writer) throws JAXBException {
		createMarshaller(object.getClass()).marshal(object, writer);
	}
	
	public Object unmarshal(Reader reader, Class<?> clazz) throws JAXBException {
		return createUnmarshaller(clazz).unmarshal(reader);
	}
	
	protected final Marshaller createMarshaller(Class<?> clazz) throws JAXBException {
		JAXBContext jaxbContext = getJaxbContext(clazz);
		return jaxbContext.createMarshaller();
	}
	
	protected final Unmarshaller createUnmarshaller(Class<?> clazz) throws JAXBException {
		JAXBContext jaxbContext = getJaxbContext(clazz);
		return jaxbContext.createUnmarshaller();
	}
	
	protected final JAXBContext getJaxbContext(Class<?> clazz) throws JAXBException {
		JAXBContext jaxbContext = this.jaxbContexts.get(clazz);
		if (jaxbContext == null) {
			jaxbContext = JAXBContext.newInstance(clazz);
			this.jaxbContexts.putIfAbsent(clazz, jaxbContext);
		}
		return jaxbContext;
	}

}