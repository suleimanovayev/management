package employees.util;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;


public class HashUtil {

    private static final int LENGHT_BYTES = 16;
    private static final int ITERATION_COUNT = 65536;
    private static final int KEY_LENGTH = 36;
    private static final String ALGORITHM = "PBKDF2WithHmacSHA1";

    private static byte[] getSalt() {
        byte[] salt = new byte[LENGHT_BYTES];
        for (int i = 0, k = 0; i < LENGHT_BYTES; k += 2, i++) {
            salt[i] = (byte) k;
        }
        return salt;
    }

    public static String hashPassword(String password) {
        try {
            KeySpec keySpec = new PBEKeySpec(password.toCharArray(), getSalt(), ITERATION_COUNT, KEY_LENGTH);
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(ALGORITHM);
            byte[] hash = secretKeyFactory.generateSecret(keySpec).getEncoded();
            return new String(hash);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean isPasswordCorrect(String password, String hashFromDatabase) {
        return hashPassword(password).equals(hashFromDatabase);
    }
}
