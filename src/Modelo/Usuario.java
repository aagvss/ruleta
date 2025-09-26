package Modelo;

public class Usuario {
    private String username;
    private String password;
    private String nombre;
    private int saldo;

    public Usuario(String username, String password, String nombre){
        this.username = username;
        this.password = password;
        this.nombre = (nombre==null || nombre.isBlank()) ? "Invitado" : nombre;
        this.saldo = 10000;
    }

    public String getUsername() {return username;}
    public String getPassword() {return password;}

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {
        if (nombre==null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre es obligatorio");
        }
        this.nombre = nombre;
    }
    public int getSaldo() {return saldo;}

    public void depositar(int monto) {
        if (monto<=0) throw new IllegalArgumentException("Monto invalido");
        saldo+=monto;
    }
    public boolean retirar(int monto) {
        if (monto>saldo) return false;
        saldo -= monto;
        return true;
    }
    public boolean validarCredenciales(String u, String p) {
        return username.equals(u) && password.equals(p);
    }

}
