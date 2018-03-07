package newandroid.com.sqlite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import org.jetbrains.anko.db.*

/**
 * Created by Alvaro on 2/28/18.
 */

class DepartamentoSQLiteOpenHelper(context: Context) : ManagedSQLiteOpenHelper(context, "departamentos.db", null, 1) {

    companion object {

        private var instance: DepartamentoSQLiteOpenHelper? = null

        @Synchronized
        fun getInstance(context: Context): DepartamentoSQLiteOpenHelper {
            if (instance == null) {
                instance = DepartamentoSQLiteOpenHelper(context.applicationContext)
            }
            return instance!!
        }

    }
    override fun onCreate(db: SQLiteDatabase) {
        db.createTable(Departamento.NOMBRE_TABLA,true,
                Departamento.ID_DEP to INTEGER + PRIMARY_KEY,
                Departamento.DEPARTAMENTO to TEXT)
        Log.i("LOGTAG", "Tabla creada departamento")

    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.dropTable(Departamento.NOMBRE_TABLA, true)
        onCreate(db)

    }


}


val Context.database2: DepartamentoSQLiteOpenHelper
    get() = DepartamentoSQLiteOpenHelper.getInstance(applicationContext)

