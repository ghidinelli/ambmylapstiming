import com.skoky.client.MsgConverter;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.assertTrue;

/**
 * Created by ladislav.skokan on 30.6.2014.
 */
public class TestP3Conversion {

    @Test
    public void simpleConvert() {

        try {
            Class c = MsgConverter.class;
            final Object[] args = new Object[1];
            args[0] = new String[]{"-bytes", "8E0136003833000001000104110000000304377747000502450006026C00020101080200000408400D72A9000000008104540202008F"
                    , "-type", "P3"};
            c.getDeclaredMethod("main", String[].class).invoke(null, args);
            assertTrue(true);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testInvalidType() {

        try {
            Class c = MsgConverter.class;
            final Object[] args = new Object[1];
            args[0] = new String[]{"-bytes", "8E0136003833000001000104110000000304377747000502450006026C00020101080200000408400D72A9000000008104540202008F"
                    , "-type", "P399"};
            c.getDeclaredMethod("main", String[].class).invoke(null, args);
            assertTrue(true);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testInvalidData() {

        try {
            Class c = MsgConverter.class;
            final Object[] args = new Object[1];
            args[0] = new String[]{"-bytes", "hhhh"
                    , "-type", "P3"};
            c.getDeclaredMethod("main", String[].class).invoke(null, args);
            assertTrue(true);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

}
