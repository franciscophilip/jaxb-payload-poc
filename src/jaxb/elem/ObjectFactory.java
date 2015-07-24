package jaxb.elem;

import jaxb.test.Bar;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import java.math.BigDecimal;

@XmlRegistry
public class ObjectFactory {

    private static Class classes[] = new Class[]{String.class, Double.class, Long.class, Integer.class, BigDecimal.class};

    public static boolean isProcessable(Object o) {
        if (o != null) {
            for (Class z : classes) {
                if(o.getClass() == z){
                    return true;
                }
            }
        }
        return false;
    }

//    WordUtils.capitalizeFully();

    @XmlElementDecl(name = "bar", namespace = Namespace.NAMESPACE)
    public JAXBElement<Bar> createBar(Bar bar) {
        return new JAXBElement<Bar>(new QName("bar"), Bar.class, bar);
    }


    @XmlElementDecl(name = "string", namespace = Namespace.NAMESPACE)
    public JAXBElement<String> create(String d) {
        return element(d);
    }

    @XmlElementDecl(name = "double", namespace = Namespace.NAMESPACE)
    public JAXBElement<Double> create(Double d) {
        return element(d);
    }

    @XmlElementDecl(name = "long", namespace = Namespace.NAMESPACE)
    public JAXBElement<Long> create(Long d) {
        return element(d);
    }




    public static <T> JAXBElement<T> element(T z) {
        return new JAXBElement(new QName( Namespace.NAMESPACE, name(z)), z.getClass(), z);
    }

    private static String name(Object z) {
        return z.getClass().getSimpleName().toLowerCase();
    }


}