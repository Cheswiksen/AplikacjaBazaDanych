package backend.Utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Random;

public class LoginUtils {
    public static String hashPwd(String password, String salt) {
        String hashedPwd = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update((password+salt).getBytes());
            byte byteData[] = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte aByteData : byteData) {
                sb.append(Integer.toString((aByteData & 0xff) + 0x100, 16).substring(1));
            }
            hashedPwd = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return hashedPwd;
    }

    public static String GetSalt() {
        Random r = new SecureRandom();
        byte[] bytes = new byte[32];
        r.nextBytes(bytes);
        return Base64.getEncoder().encodeToString(bytes);
    }
}
