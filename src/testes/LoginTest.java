package testes;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoginTest {
    @Test
    public void logarTest() throws Exception, LoginInvalidoException {

        assertThrows(LoginInvalidoException.class,() -> Login.logar("2313",""));

    }
}
