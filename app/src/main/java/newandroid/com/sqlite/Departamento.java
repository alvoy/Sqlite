package newandroid.com.sqlite;

/**
 * Created by Alvaro on 2/28/18.
 */

public class Departamento {
    int id_dep;
    String departamento;

    public Departamento(){}

    public Departamento(int id_dep, String departamento){
        this.id_dep = id_dep;
        this.departamento = departamento;

    }

    public int getId_dep() {
        return id_dep;
    }

    public void setId_dep(int id_dep) {
        this.id_dep = id_dep;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String toString(){
        return id_dep +" "+ departamento;
    }



}
