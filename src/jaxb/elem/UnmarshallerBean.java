package jaxb.elem;

import jaxb.test.Foo;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.ByteArrayInputStream;
import java.io.File;

public class UnmarshallerBean {



    private javax.xml.bind.Unmarshaller unmarshaller;

    public UnmarshallerBean() throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(Payload.class, Foo.class, ObjectFactory.class);
        unmarshaller = jc.createUnmarshaller();
    }

    public Payload unmarshal(File file) throws JAXBException {
        return (Payload) unmarshaller.unmarshal(file);
    }
    public Payload unmarshal(String s) throws JAXBException {
        return (Payload) unmarshaller.unmarshal(new ByteArrayInputStream(s.getBytes()));
    }
}
