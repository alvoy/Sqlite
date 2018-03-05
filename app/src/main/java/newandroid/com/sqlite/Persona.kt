package newandroid.com.sqlite

/**
 * Created by Alvaro on 2/28/18.
 */

class Persona {
    var id: Int = 0
    var nombre: String = ""
    var apellido: String = ""
    var id_dep: Int = 0

    constructor() {}

    constructor(id: Int, nombre: String, apellido: String, id_dep: Int) {
        this.id = id
        this.nombre = nombre
        this.apellido = apellido
        this.id_dep = id_dep
    }

    override fun toString(): String {
        return "$nombre $apellido $id $id_dep"
    }


}
