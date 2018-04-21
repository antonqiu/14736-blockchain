package lib;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

import java.io.*;

/**
 * Util to serialize and deserialize objects
 */
public class ObjectSerializer {

    public static byte[] serialize (Object obj) {
        byte[] res = null;
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(bos);
            out.writeObject(obj);
            res = Hex.encodeHexString(bos.toByteArray()).getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    public static Object deserialize (byte[] byteArray) {
        Object res = null;
        if (byteArray == null) {
            return res;
        }
        try {
            byte[] cur = Hex.decodeHex(new String(byteArray));
            ByteArrayInputStream bis = new ByteArrayInputStream(cur);
            ObjectInputStream ois = new ObjectInputStream(bis);
            res = ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (DecoderException e){
            e.printStackTrace();
        }
        return res;
    }

}
