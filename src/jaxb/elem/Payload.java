package jaxb.elem;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(namespace = Namespace.NAMESPACE)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Payload", propOrder = {
        "any"
})
@XmlSeeAlso(value ={SerializableElement.class, ObjectFactory.class})
public class Payload {

    @XmlJavaTypeAdapter(AnyTypeAdapter.class)
    @XmlAnyElement(lax = true)
    public Object any;





}