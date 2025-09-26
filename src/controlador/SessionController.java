package controlador;
import Modelo.Usuario;
import java.util.ArrayList;
import java.util.List;

public class SessionController {
    private final List<Usuario> usuarios= new ArrayList<>();
    private Usuario usuarioActual;

    public void registrarUsuario(String username, String password, String nombre) {
       if (username == null || username.isBlank() || password == null || password.isBlank() || nombre == null || nombre.isBlank()) {
           throw new IllegalArgumentException("Datos invalidos");
       }
       for (Usuario u : usuarios) {
           if (u.getUsername().equals(username)) {
               throw new IllegalArgumentException("Usuario existente");
           }
       }
       usuarios.add(new Usuario(username, password, nombre));
    }
    public boolean iniciarSesion(String username, String password) {
        for (Usuario u : usuarios) {
            if (u.validarCredenciales(username, password)){
                usuarioActual = u;
                return true;
            }
        }
        return false;
    }
    public void cerrarSesion() {
        usuarioActual = null;
    }
    public Usuario getUsuarioActual() {
        return usuarioActual;
    }
    public boolean hayUsuario(){
        return usuarioActual!=null;
    }
}
