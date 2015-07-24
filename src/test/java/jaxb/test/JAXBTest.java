package jaxb.test;

import jaxb.elem.MarshallerBean;
import jaxb.elem.Payload;
import jaxb.elem.UnmarshallerBean;
import jaxb.elem.Utils;
import org.junit.Assert;
import org.junit.Test;

import javax.xml.bind.JAXBException;
import javax.xml.bind.MarshalException;
import java.io.InputStream;

/**
 * @author fphilip@houseware.es
 */
public class JAXBTest {

    @Test(expected = MarshalException.class)
    public void test_marshal_bar_error() throws JAXBException {
        Payload payload = new Payload();
        payload.any = new Bar();
        String z = new MarshallerBean().marshal(payload);
    }

    @Test
    public void test_marshal_bar_serializable() throws JAXBException {
        Payload payload = new Payload();
        payload.any = new BarSerializable("pepe");
        String z = new MarshallerBean().marshal(payload);
        System.out.println(z);

//        Payload x = new UnmarshallerBean().unmarshal(new File("test_marshall_bar_serializable.xml"));
//        Assert.assertEquals(x, payload);
    }


    @Test
    public void test_marshal_foo() throws JAXBException {
        Payload payload = new Payload();
        payload.any = new Foo();
        String z = new MarshallerBean(Foo.class).marshal(payload);
        System.out.println(z);
//        XMLAssert.assertXpathNotExists();
    }

    @Test
    public void test_marshal_string() throws JAXBException {
        Payload payload = new Payload();
        payload.any = "pepe";
        String z = new MarshallerBean().marshal(payload);
        System.out.println(z);
    }

    @Test
    public void test_marshal_double() throws JAXBException {
        Payload payload = new Payload();
        payload.any = 1.3;
        String z = new MarshallerBean().marshal(payload);
        System.out.println(z);
    }

    @Test
    public void test_unmarshal_foo() throws JAXBException {
        InputStream inputStream = Utils.openResource("test_unmarshal_foo.xml");
        Payload payload = new UnmarshallerBean(Foo.class).unmarshal(inputStream);
        Assert.assertNotNull(payload);
        Assert.assertNotNull(payload.any);
        Assert.assertEquals(Foo.class, payload.any.getClass());
        System.out.println(payload.any);
    }

    @Test
    public void test_unmarshal_string() throws JAXBException {
        InputStream inputStream = Utils.openResource("test_unmarshal_string.xml");
        Payload payload = new UnmarshallerBean().unmarshal(inputStream);
        Assert.assertNotNull(payload);
        Assert.assertEquals("pepe", payload.any);
        System.out.println(payload.any);
    }


    @Test
    public void test_unmarshal_double() throws JAXBException {
        InputStream inputStream = Utils.openResource("test_unmarshal_double.xml");
        Payload payload = new UnmarshallerBean().unmarshal(inputStream);
        Assert.assertNotNull(payload);
        Assert.assertEquals(1.3, payload.any);
        System.out.println(payload.any);
    }

    @Test
    public void test_unmarshal_bar_serializable() throws JAXBException {

        InputStream inputStream = Utils.openResource("test_unmarshal_bar_serializable.xml");
        Payload<BarSerializable> payload = new UnmarshallerBean().unmarshal(inputStream);

        Assert.assertNotNull(payload);
        Assert.assertNotNull(payload.any);
        Assert.assertEquals(payload.any.getClass(), BarSerializable.class);
        Assert.assertEquals(payload.any, new BarSerializable("pepe"));

    }
}
