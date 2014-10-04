import com.skoky.client.MsgConverter;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by ladislav.skokan on 30.6.2014.
 */
public class TestP3Conversion {

    @Test
    public void simpleConvert() {
        String bytes = "8E0136003833000001000104110000000304377747000502450006026C00020101080200000408400D72A9000000008104540202008F";
        String json = new MsgConverter().toJson("P3", bytes);
        System.out.println("Result JSON:" + json);
        assertTrue(json.contains("true"));
    }

    @Test
    public void testInvalidType() {
        String bytes = "8E0136003833000001000104110000000304377747000502450006026C00020101080200000408400D72A9000000008104540202008F";
        String json = new MsgConverter().toJson("P33", bytes);
        System.out.println("Result JSON:" + json);
        assertTrue(json.contains("Unexpected message type P33"));

    }

    @Test
    public void testInvalidData() {
        String json = new MsgConverter().toJson("P3", "invalid data");
        System.out.println("Result JSON:" + json);
        assertTrue(json.contains("Unable"));

    }

}
