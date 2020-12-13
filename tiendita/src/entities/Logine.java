
package entities;

import java.nio.charset.StandardCharsets;
import util.EncryptorAesGcmPassword;

public class Logine {
    
    private int id;
    private String nombre;
    private String apellido_paterno;
    private String apellido_materno;
    private String usuario;
    private String password;
    
    public void encriptarPass() throws Exception
    {
        this.password=EncryptorAesGcmPassword.encrypt(this.password.getBytes(StandardCharsets.UTF_8), "");
    }
    
    public void desencriptarPass() throws Exception
    {          
        String desEncrypted  = EncryptorAesGcmPassword.decrypt(this.password, "");
        this.password=desEncrypted;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
