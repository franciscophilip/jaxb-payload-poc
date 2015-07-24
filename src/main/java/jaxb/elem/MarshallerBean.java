package jaxb.elem;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;

public class MarshallerBean {

    private Marshaller marshaller;

    public MarshallerBean(Class... classesToBeBound) throws JAXBException {

        JAXBContext jc = JAXBContext.newInstance(Utils.add(Class.class, classesToBeBound, Payload.class));
        marshaller = jc.createMarshaller();
        marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, true);
    }


    public String marshal(Payload payload) throws JAXBException {

        ByteArrayOutputStream pw = new ByteArrayOutputStream();

        marshaller.marshal(payload, new PrintWriter(pw));

        return pw.toString();
    }

}
