package newandroid.com.sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;


import java.util.List;


public class MainActivity extends AppCompatActivity {

    Button inserta,join;
    ListView listView,listView2;
    List<Persona> personas;
    List<Departamento> departamentos;
    DataSource dataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inserta = (Button)findViewById(R.id.button);
        join = (Button)findViewById(R.id.button2);
        listView = (ListView) findViewById(R.id.listview);
        listView2 = (ListView) findViewById(R.id.listview2);


        dataSource = new DataSource(this);
        dataSource.open();
        createData();

        inserta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                personas = dataSource.findAllPersons();
                departamentos = dataSource.findAllDeptos();
                refreshDisplay();

            }
        });

        join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 dataSource.queryJoin();
                //departamentos = dataSource.queryJoin();
            }
        });
    }

    public void createData(){
        dataSource.create(new Persona(1,"Alvaro","Moya",3));
        dataSource.create(new Persona(2,"Arturo","Sanhueza",2));
        dataSource.create2(new Departamento(1, "Administración"));
        dataSource.create2(new Departamento(2, "Informática"));
        dataSource.create2(new Departamento(3, "Comercial"));

    }

    public void refreshDisplay(){
        ArrayAdapter<Persona> adapter = new ArrayAdapter<>(this,android.R.layout.simple_expandable_list_item_1, personas);
        listView.setAdapter(adapter);

        ArrayAdapter<Departamento> adapter1 = new ArrayAdapter<>(this,android.R.layout.simple_expandable_list_item_1,departamentos);
        listView2.setAdapter(adapter1);
    }

}
