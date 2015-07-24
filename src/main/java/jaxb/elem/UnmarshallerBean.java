package jaxb.elem;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;

public class UnmarshallerBean {


    private javax.xml.bind.Unmarshaller unmarshaller;

    public UnmarshallerBean(Class... classesToBeBound) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(Utils.add(Class.class, classesToBeBound, Payload.class, ObjectFactory.class));
        unmarshaller = jc.createUnmarshaller();
    }

    public Payload unmarshal(InputStream inputStream) throws JAXBException {
        return (Payload) unmarshaller.unmarshal(inputStream);
    }

    public Payload unmarshal(File file) throws JAXBException {
        return (Payload) unmarshaller.unmarshal(file);
    }

    public Payload unmarshal(String s) throws JAXBException {
        return (Payload) unmarshaller.unmarshal(new ByteArrayInputStream(s.getBytes()));
    }
}
