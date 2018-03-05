package newandroid.com.sqlite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

/**
 * Created by Alvaro on 2/28/18.
 */

class PersonasSQLiteOpenHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(CREATE_TABLE)
        Log.i("LOGTAG", "Tabla creada personas")

    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXIST " + TABLE_PERSONAS)
        onCreate(db)

    }

    companion object {

        private val DATABASE_NAME = "personas.db"
        private val DATABASE_VERSION = 1

        val TABLE_PERSONAS = "personas"
        val COLUMN_ID = "id"
        val COLUMN_NOMBRE = "nombre"
        val COLUMN_APELLIDO = "apellido"
        val COLUMN_ID_DEP = "id_dep"

        val CREATE_TABLE = "CREATE TABLE " + TABLE_PERSONAS + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NOMBRE + " TEXT, " +
                COLUMN_APELLIDO + " TEXT, " +
                COLUMN_ID_DEP + " INTEGER " + ")"
    }
}
