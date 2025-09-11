public class Usuario {
    private String username;
    private String password;

    public Usuario(String username, String password){
        this.username = username;
        this.password = password;
    }
    public String getusername() {
        return this.username;
    }
    public String getClave(){
        return this.password;
    }
}
