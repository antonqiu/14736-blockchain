package lib;

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
            res = bos.toByteArray();
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
            ByteArrayInputStream bis = new ByteArrayInputStream(byteArray);
            ObjectInputStream ois = new ObjectInputStream(bis);
            res = ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return res;
    }

}
