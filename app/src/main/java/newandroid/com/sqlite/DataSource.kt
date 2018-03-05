package newandroid.com.sqlite

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

import java.util.ArrayList

/**
 * Created by Alvaro on 2/28/18.
 */

class DataSource(context: Context) {
     var dbhelper: SQLiteOpenHelper
     var dbhelper2: SQLiteOpenHelper
     var dbhelper3: SQLiteOpenHelper
     lateinit var sqLiteDatabase: SQLiteDatabase
     lateinit var sqLiteDatabase2: SQLiteDatabase
     lateinit var sqLiteDatabase3: SQLiteDatabase

    init {

        dbhelper = PersonasSQLiteOpenHelper(context)
        dbhelper2 = DepartamentosSQLiteOpenHelper(context)
        dbhelper3 = ClaseAuxiliarSQLiteOpenHelper(context)

    }

    fun open() {
        sqLiteDatabase = dbhelper.writableDatabase
        sqLiteDatabase2 = dbhelper2.writableDatabase
        sqLiteDatabase3 = dbhelper3.writableDatabase
    }

    fun close() {
        dbhelper.close()
        dbhelper2.close()
    }

    fun create(persona: Persona) {
        val contentValues = ContentValues()
        contentValues.put(PersonasSQLiteOpenHelper.COLUMN_NOMBRE, persona.nombre)
        contentValues.put(PersonasSQLiteOpenHelper.COLUMN_APELLIDO, persona.apellido)
        contentValues.put(PersonasSQLiteOpenHelper.COLUMN_ID_DEP, persona.id_dep)
        sqLiteDatabase.insert(PersonasSQLiteOpenHelper.TABLE_PERSONAS, null, contentValues)


    }

    fun create2(departamento: Departamento) {
        val contentValues2 = ContentValues()
        contentValues2.put(DepartamentosSQLiteOpenHelper.COLUMN_DEPARTAMENTO, departamento.departamento)
        sqLiteDatabase2.insert(DepartamentosSQLiteOpenHelper.TABLE_DEPTOS, null, contentValues2)

    }

    fun findAllPersons(): List<Persona> {
        val cursor = sqLiteDatabase.query(PersonasSQLiteOpenHelper.TABLE_PERSONAS, allColumns, null, null, null, null, null)
        return cursortoList(cursor)
    }

    fun cursortoList(cursor: Cursor): List<Persona> {
        val personas = ArrayList<Persona>()
        if (cursor.count > 0) {
            while (cursor.moveToNext()) {
                val persona = Persona()
                persona.id = cursor.getInt(cursor.getColumnIndex(PersonasSQLiteOpenHelper.COLUMN_ID))
                persona.nombre = cursor.getString(cursor.getColumnIndex(PersonasSQLiteOpenHelper.COLUMN_NOMBRE))
                persona.apellido = cursor.getString(cursor.getColumnIndex(PersonasSQLiteOpenHelper.COLUMN_APELLIDO))
                persona.id_dep = cursor.getInt(cursor.getColumnIndex(PersonasSQLiteOpenHelper.COLUMN_ID_DEP))
                personas.add(persona)
            }
        }

        return personas


    }

    fun findAllDeptos(): List<Departamento> {
        val cursor2 = sqLiteDatabase2.query(DepartamentosSQLiteOpenHelper.TABLE_DEPTOS, allColumns2, null, null, null, null, null)
        return cursortoList2(cursor2)
    }

    fun cursortoList2(cursor: Cursor): List<Departamento> {
        val departamentos = ArrayList<Departamento>()
        if (cursor.count > 0) {
            while (cursor.moveToNext()) {
                val departamento = Departamento()
                departamento.id_dep = cursor.getInt(cursor.getColumnIndex(DepartamentosSQLiteOpenHelper.COLUMN_ID_DEP))
                departamento.departamento = cursor.getString(cursor.getColumnIndex(DepartamentosSQLiteOpenHelper.COLUMN_DEPARTAMENTO))
                departamentos.add(departamento)
            }
        }

        return departamentos

    }


    fun queryJoin() {
        /* sqLiteDatabase.execSQL("attach database ? as deptosdb", new String[]{"/data/data/newandroid.com.sqlite/databases/departamentos.db"});

       // sqLiteDatabase.execSQL("ATTACH 'departamentos.db' AS deptos_DB");
        String query = "SELECT departamento FROM deptosdb.departamentos INNER JOIN personas ON personas.id_dep = deptosdb.departamentos.id_dep";
        Cursor cursor = sqLiteDatabase.rawQuery(query,null);
        while (cursor.moveToNext()) {
                Log.i("cursor", cursor.getString(0));
        }*/

        sqLiteDatabase3.execSQL("attach database ? as personasdb", arrayOf("/data/data/newandroid.com.sqlite/databases/personas.db"))
        sqLiteDatabase3.execSQL("attach database ? as deptosdb", arrayOf("/data/data/newandroid.com.sqlite/databases/departamentos.db"))
        val query2 = "SELECT DISTINCT departamento FROM deptosdb.departamentos INNER JOIN personasdb.personas ON personasdb.personas.id_dep = deptosdb.departamentos.id_dep"
        val cursor2 = sqLiteDatabase3.rawQuery(query2, null)
        while (cursor2.moveToNext()) {
            Log.i("cursor", cursor2.getString(0))
        }
        ///Log.i("cursor",cursor.getString(1));
        /*   List <Departamento> departamentos = new ArrayList<>();
        if(cursor.getCount()>0){
            while (cursor.moveToNext()){
                Departamento departamento = new Departamento();
                departamento.setId_dep(cursor.getInt(cursor.getColumnIndex(DepartamentosSQLiteOpenHelper.COLUMN_ID_DEP)));
                departamento.setDepartamento(cursor.getString(cursor.getColumnIndex(DepartamentosSQLiteOpenHelper.COLUMN_DEPARTAMENTO)));
                departamentos.add(departamento);
            }
        }

        return departamentos;*/
    }

    companion object {

        private val allColumns = arrayOf(PersonasSQLiteOpenHelper.COLUMN_ID, PersonasSQLiteOpenHelper.COLUMN_NOMBRE, PersonasSQLiteOpenHelper.COLUMN_APELLIDO, PersonasSQLiteOpenHelper.COLUMN_ID_DEP)
        private val allColumns2 = arrayOf(DepartamentosSQLiteOpenHelper.COLUMN_ID_DEP, DepartamentosSQLiteOpenHelper.COLUMN_DEPARTAMENTO)
    }


}
