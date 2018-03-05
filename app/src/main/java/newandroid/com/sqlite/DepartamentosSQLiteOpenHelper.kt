package newandroid.com.sqlite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

/**
 * Created by Alvaro on 2/28/18.
 */

class DepartamentosSQLiteOpenHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(CREATE_TABLE)
        Log.i("LOGTAG", "Tabla creada deptos")

    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DEPTOS)
        onCreate(db)

    }

    companion object {

        private val DATABASE_NAME = "departamentos.db"
        private val DATABASE_VERSION = 1
        val TABLE_DEPTOS = "departamentos"
        val COLUMN_ID_DEP = "id_dep"
        val COLUMN_DEPARTAMENTO = "departamento"

        val CREATE_TABLE = "CREATE TABLE " + TABLE_DEPTOS + " (" +
                COLUMN_ID_DEP + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_DEPARTAMENTO + " TEXT " + ")"

    }
}
