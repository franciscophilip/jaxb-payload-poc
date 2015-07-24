package jaxb.elem;

import java.io.InputStream;
import java.lang.reflect.Array;

/**
 * @author fphilip@houseware.es
 */
public class Utils {

    public static <T> T[] add(T[] array, T element) {
        Class type;
        if (array != null) {
            type = array.getClass();
        } else if (element != null) {
            type = element.getClass();
        } else {
            type = Object.class;
        }
        return (T[]) add(type, array, element);
    }

    public static <T> T[] add(Class<T> type, T[] array, T... element) {

        T[] newArray = copyArrayGrow1(type, array, element);
        return newArray;
    }


    private static <T> T[] copyArrayGrow1(Class type, T[] array1, T... array2) {
        Object newArray = Array.newInstance(type, array1.length + array2.length);
        System.arraycopy(array1, 0, newArray, 0, array1.length);
        System.arraycopy(array2, 0, newArray, array1.length, array2.length);
        return (T[]) newArray;
    }


    public static InputStream openResource(String recurso) {
        return openResource(recurso, Thread.currentThread().getContextClassLoader());
    }


    public static InputStream openResource(String name, ClassLoader classLoader) {
        InputStream stream = classLoader.getResourceAsStream(name);

        return stream;
    }


}
