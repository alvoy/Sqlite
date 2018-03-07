package newandroid.com.sqlite

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import org.jetbrains.anko.db.*
import java.util.ArrayList

/**
 * Created by Alvaro on 2/28/18.
 */

class DataSource(context: Context) {

    val dbhelper = PersonaSQLiteOpenHelper(context)
    val dbhelper2 = DepartamentoSQLiteOpenHelper(context)




    fun create() {
        dbhelper.use {
            insert(Persona.NOMBRE_TABLA,
                        Persona.ID to 1,
                        Persona.NOMBRE to "Alvaro",
                        Persona.APELLIDO to "Moya",
                        Persona.ID_DEP to 1)

            insert(Persona.NOMBRE_TABLA,
                    Persona.ID to 2,
                    Persona.NOMBRE to "Arturo",
                    Persona.APELLIDO to "Sanhueza",
                    Persona.ID_DEP to 2)
        }

        dbhelper2.use {
            insert(Departamento.NOMBRE_TABLA,
                    Departamento.ID_DEP to 1,
                    Departamento.DEPARTAMENTO to "Informática")

            insert(Departamento.NOMBRE_TABLA,
                    Departamento.ID_DEP to 2,
                    Departamento.DEPARTAMENTO to "Comercial")

        }

    }

    fun create2(departamento: Departamento) {



    }

   /* fun findAllPersons(): List<Persona> {
        val cursor = sqLiteDatabase.query(PersonasSQLiteOpenHelper.TABLE_PERSONAS, allColumns, null, null, null, null, null)
        return cursortoList(cursor)
    }*/

 /*   fun cursortoList(cursor: Cursor): List<Persona> {
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


    }*/


/*
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
        *//* sqLiteDatabase.execSQL("attach database ? as deptosdb", new String[]{"/data/data/newandroid.com.sqlite/databases/departamentos.db"});

       // sqLiteDatabase.execSQL("ATTACH 'departamentos.db' AS deptos_DB");
        String query = "SELECT departamento FROM deptosdb.departamentos INNER JOIN personas ON personas.id_dep = deptosdb.departamentos.id_dep";
        Cursor cursor = sqLiteDatabase.rawQuery(query,null);
        while (cursor.moveToNext()) {
                Log.i("cursor", cursor.getString(0));
        }*//*

        sqLiteDatabase3.execSQL("attach database ? as personasdb", arrayOf("/data/data/newandroid.com.sqlite/databases/personas.db"))
        sqLiteDatabase3.execSQL("attach database ? as deptosdb", arrayOf("/data/data/newandroid.com.sqlite/databases/departamentos.db"))
        val query2 = "SELECT DISTINCT departamento FROM deptosdb.departamentos INNER JOIN personasdb.personas ON personasdb.personas.id_dep = deptosdb.departamentos.id_dep"
        val cursor2 = sqLiteDatabase3.rawQuery(query2, null)
        while (cursor2.moveToNext()) {
            Log.i("cursor", cursor2.getString(0))
        }
        ///Log.i("cursor",cursor.getString(1));
        *//*   List <Departamento> departamentos = new ArrayList<>();
        if(cursor.getCount()>0){
            while (cursor.moveToNext()){
                Departamento departamento = new Departamento();
                departamento.setId_dep(cursor.getInt(cursor.getColumnIndex(DepartamentosSQLiteOpenHelper.COLUMN_ID_DEP)));
                departamento.setDepartamento(cursor.getString(cursor.getColumnIndex(DepartamentosSQLiteOpenHelper.COLUMN_DEPARTAMENTO)));
                departamentos.add(departamento);
            }
        }

        return departamentos;*//*
    }

    companion object {

        private val allColumns = arrayOf(PersonasSQLiteOpenHelper.COLUMN_ID, PersonasSQLiteOpenHelper.COLUMN_NOMBRE, PersonasSQLiteOpenHelper.COLUMN_APELLIDO, PersonasSQLiteOpenHelper.COLUMN_ID_DEP)
        private val allColumns2 = arrayOf(DepartamentosSQLiteOpenHelper.COLUMN_ID_DEP, DepartamentosSQLiteOpenHelper.COLUMN_DEPARTAMENTO)
    }*/


}
