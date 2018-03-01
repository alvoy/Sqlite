package newandroid.com.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alvaro on 2/28/18.
 */

public class DataSource {
    SQLiteOpenHelper dbhelper, dbhelper2;
    SQLiteDatabase sqLiteDatabase,sqLiteDatabase2;

    private static String[] allColumns = {
            PersonasSQLiteOpenHelper.COLUMN_ID,
            PersonasSQLiteOpenHelper.COLUMN_NOMBRE,
            PersonasSQLiteOpenHelper.COLUMN_APELLIDO,
            PersonasSQLiteOpenHelper.COLUMN_ID_DEP


    };

    private static String[] allColumns2 = {
            DepartamentosSQLiteOpenHelper.COLUMN_ID_DEP,
            DepartamentosSQLiteOpenHelper.COLUMN_DEPARTAMENTO

    };

    public DataSource(Context context){

        dbhelper = new PersonasSQLiteOpenHelper(context);
        dbhelper2 = new DepartamentosSQLiteOpenHelper(context);

    }

    public void open(){
        sqLiteDatabase = dbhelper.getWritableDatabase();
        sqLiteDatabase2 = dbhelper2.getWritableDatabase();
    }

    public void close(){
        dbhelper.close();
        dbhelper2.close();
    }

    public void create(Persona persona){
        ContentValues contentValues = new ContentValues();
        contentValues.put(PersonasSQLiteOpenHelper.COLUMN_NOMBRE, persona.getNombre());
        contentValues.put(PersonasSQLiteOpenHelper.COLUMN_APELLIDO, persona.getApellido());
        contentValues.put(PersonasSQLiteOpenHelper.COLUMN_ID_DEP, persona.getId_dep());
        sqLiteDatabase.insert(PersonasSQLiteOpenHelper.TABLE_PERSONAS, null, contentValues);


    }

    public void create2(Departamento departamento){
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put(DepartamentosSQLiteOpenHelper.COLUMN_DEPARTAMENTO, departamento.getDepartamento());
        sqLiteDatabase2.insert(DepartamentosSQLiteOpenHelper.TABLE_DEPTOS, null, contentValues2);

    }

    public List<Persona> findAllPersons(){
        Cursor cursor = sqLiteDatabase.query(PersonasSQLiteOpenHelper.TABLE_PERSONAS,allColumns,null,null,null,null,null);
        List <Persona> personas = cursortoList(cursor);
        return  personas;
    }

    public List<Persona> cursortoList(Cursor cursor){
        List <Persona> personas = new ArrayList<>();
        if(cursor.getCount()>0){
            while (cursor.moveToNext()){
                Persona persona = new Persona();
                persona.setId(cursor.getInt(cursor.getColumnIndex(PersonasSQLiteOpenHelper.COLUMN_ID)));
                persona.setNombre(cursor.getString(cursor.getColumnIndex(PersonasSQLiteOpenHelper.COLUMN_NOMBRE)));
                persona.setApellido(cursor.getString(cursor.getColumnIndex(PersonasSQLiteOpenHelper.COLUMN_APELLIDO)));
                persona.setId_dep(cursor.getInt(cursor.getColumnIndex(PersonasSQLiteOpenHelper.COLUMN_ID_DEP)));
                personas.add(persona);
            }
        }

        return personas;


    }

    public List<Departamento> findAllDeptos(){
        Cursor cursor2 = sqLiteDatabase2.query(DepartamentosSQLiteOpenHelper.TABLE_DEPTOS,allColumns2,null,null,null,null,null);
        List <Departamento> departamentos = cursortoList2(cursor2);
        return  departamentos;
    }

    public List<Departamento> cursortoList2(Cursor cursor){
        List <Departamento> departamentos = new ArrayList<>();
        if(cursor.getCount()>0){
            while (cursor.moveToNext()){
                Departamento departamento = new Departamento();
                departamento.setId_dep(cursor.getInt(cursor.getColumnIndex(DepartamentosSQLiteOpenHelper.COLUMN_ID_DEP)));
                departamento.setDepartamento(cursor.getString(cursor.getColumnIndex(DepartamentosSQLiteOpenHelper.COLUMN_DEPARTAMENTO)));
                departamentos.add(departamento);
            }
        }

        return departamentos;

    }


    public void queryJoin(){
        sqLiteDatabase.execSQL("attach database ? as deptosdb", new String[]{"/data/data/newandroid.com.sqlite/databases/departamentos.db"});

       // sqLiteDatabase.execSQL("ATTACH 'departamentos.db' AS deptos_DB");
        String query = "SELECT departamento FROM deptosdb.departamentos INNER JOIN personas ON personas.id_dep = deptosdb.departamentos.id_dep";
        Cursor cursor = sqLiteDatabase.rawQuery(query,null);
        while (cursor.moveToNext()) {
                Log.i("cursor", cursor.getString(0));
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


}
