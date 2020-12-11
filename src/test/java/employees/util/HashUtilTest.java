package employees.util;

import employees.util.HashUtil;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class HashUtilTest {


    @Test
    public void checkHashTest() {
        String password = "hello world";
        password = HashUtil.hashPassword(password);

        assertNotEquals(password, "hello world");
    }

    @Test
    public void isValidTest() {
        String password = "hello world";
        password = HashUtil.hashPassword(password);

        assertEquals(HashUtil.isPasswordCorrect("hello world", password), true);
    }
}
