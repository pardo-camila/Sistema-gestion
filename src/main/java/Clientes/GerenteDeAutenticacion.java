package Clientes;

import java.util.HashMap;
import java.util.Map;

public class GerenteDeAutenticacion {
    private Map<String, Usuario> usuarios;
    private Usuario usuarioActivo;

    public GerenteDeAutenticacion() {
        usuarios = new HashMap<>();
    }

    public void registrarUsuario(Usuario usuario) {
        usuarios.put(usuario.getNombreUsuario(), usuario);
        System.out.println("Usuario registrado con éxito.");
    }

    public void iniciarSesion(String nombreUsuario) {
        usuarioActivo = usuarios.get(nombreUsuario);
        if (usuarioActivo != null) {
            System.out.println("Sesión iniciada con éxito.");
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }

    public void cerrarSesion() {
        usuarioActivo = null;
        System.out.println("Sesión cerrada.");
    }

    public Usuario getUsuarioActivo() {
        return usuarioActivo;
    }
}
