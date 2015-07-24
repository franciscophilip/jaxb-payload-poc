package jaxb.test;

import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * @author fphilip@houseware.es
 */
@XmlRegistry
@XmlSeeAlso(Foo.class)
public class MyObjectFactory {

//    @XmlElementDecl(name = "bar", namespace = Test.NAMESPACE)
//    public JAXBElement<Bar> createBar(Bar bar) {
//        return new JAXBElement<Bar>(new QName("bar"), Bar.class, bar);
//    }

}
