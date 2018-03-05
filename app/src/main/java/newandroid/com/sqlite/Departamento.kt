package newandroid.com.sqlite

/**
 * Created by Alvaro on 2/28/18.
 */

class Departamento {
    var id_dep: Int = 0
    var departamento: String = ""

    constructor() {}

    constructor(id_dep: Int, departamento: String) {
        this.id_dep = id_dep
        this.departamento = departamento

    }

    override fun toString(): String {
        return id_dep.toString() + " " + departamento
    }


}
