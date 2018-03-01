package newandroid.com.sqlite;

/**
 * Created by Alvaro on 2/28/18.
 */

public class Persona {
    int id;
    String nombre;
    String apellido;
    int id_dep;

    public Persona(){}

    public Persona(int id, String nombre, String apellido, int id_dep){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.id_dep = id_dep;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getId_dep() {
        return id_dep;
    }

    public void setId_dep(int id_dep) {
        this.id_dep = id_dep;
    }

    public String toString(){
        return nombre +" "+ apellido +" "+ id +" "+id_dep;
    }


}
