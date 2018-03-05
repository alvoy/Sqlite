package newandroid.com.sqlite

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView


 class MainActivity : AppCompatActivity() {

      lateinit var inserta: Button
      lateinit var join: Button
      lateinit var listView: ListView
      lateinit var listView2: ListView
      lateinit var personas: List<Persona>
      lateinit var departamentos: List<Departamento>
      lateinit var dataSource: DataSource

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inserta = findViewById(R.id.button) as Button
        join = findViewById(R.id.button2) as Button
        listView = findViewById(R.id.listview) as ListView
        listView2 = findViewById(R.id.listview2) as ListView


        dataSource = DataSource(this)
        dataSource.open()
        createData()

        inserta.setOnClickListener {
            personas = dataSource.findAllPersons()
            departamentos = dataSource.findAllDeptos()
            refreshDisplay()
        }

        join.setOnClickListener {
            dataSource.queryJoin()
            //departamentos = dataSource.queryJoin();
        }
    }

    fun createData() {
        dataSource.create(Persona(1, "Alvaro", "Moya", 3))
        dataSource.create(Persona(2, "Arturo", "Sanhueza", 2))
        dataSource.create2(Departamento(1, "Administración"))
        dataSource.create2(Departamento(2, "Informática"))
        dataSource.create2(Departamento(3, "Comercial"))

    }

    fun refreshDisplay() {
        val adapter = ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, personas)
        listView.adapter = adapter

        val adapter1 = ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, departamentos)
        listView2.adapter = adapter1
    }

}
