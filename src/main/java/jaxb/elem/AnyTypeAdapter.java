package jaxb.elem;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.io.*;

/**
 * @author fphilip@houseware.es
 */
public class AnyTypeAdapter extends XmlAdapter<Object, Object> {

    //    private ObjectFactory objectFactory = new ObjectFactory();
    private HexBinaryAdapter hexAdapter = new HexBinaryAdapter();

    @Override
    public Object unmarshal(Object v) throws Exception {
        if (v instanceof JAXBElement) {
            return ((JAXBElement) v).getValue();
        }
        if(v instanceof SerializableElement){
           return f_unmarshal(((SerializableElement) v).hexa) ;
        }
        return v;
    }


    @Override
    public Object marshal(Object v) throws Exception {

        if (v != null && !isXMLRoot(v)) {
            if (ObjectFactory.isProcessable(v)) {
                return ObjectFactory.element(v);
            } else {
                if (v instanceof Serializable) {
                    return new SerializableElement(f_marshal((Serializable) v));
//                    return element_marshal((Serializable) v);
                }
            }

        }

        return v;
    }

//
//    private JAXBElement<String> element_marshal(Serializable z) throws IOException {
//        if (z != null) {
//            //todo
//            return new JAXBElement<>(new QName(Namespace.NAMESPACE, "serializable"), String.class, f_marshal(z));
//        }
//        return null;
//    }
//

    public String f_marshal(Serializable z) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(z);
        oos.close();
        byte[] serializedBytes = baos.toByteArray();
        return hexAdapter.marshal(serializedBytes);
    }


    public Serializable f_unmarshal(String z) throws IOException, ClassNotFoundException {
        byte[] serializedBytes = hexAdapter.unmarshal(z);
        ByteArrayInputStream bais = new ByteArrayInputStream(serializedBytes);
        ObjectInputStream ois = new ObjectInputStream(bais);
        return (Serializable) ois.readObject();
    }


    public boolean isXMLRoot(Object t) {
        if (t != null) {
            XmlRootElement z = t.getClass().getAnnotation(XmlRootElement.class);
            return z != null;
        }
        return false;

    }


}
