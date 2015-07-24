package jaxb.elem;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


@XmlType(name = "serializable")
@XmlRootElement(namespace = Namespace.NAMESPACE, name = "serializable")
public class SerializableElement {
    @XmlValue
    public String hexa;

    public SerializableElement(String hexa) {
        this.hexa = hexa;
    }

    public SerializableElement() {
    }
}