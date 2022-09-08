package testes;

public class Login {
    public static void logar(String usuario, String senha) throws LoginInvalidoException {
        if(((usuario == null) || usuario.isEmpty()) || ((senha == null) || senha.isEmpty())) {
            throw new LoginInvalidoException();
    }
    }
}
