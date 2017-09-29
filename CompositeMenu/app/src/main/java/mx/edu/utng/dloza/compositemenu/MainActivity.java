package mx.edu.utng.dloza.compositemenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    Spinner cmbMenus;
    Spinner cmbMenuSeleccionado;
    Button btnMostrarOrden;
    Button btnAgregarPlatillo;
    String[] desayunos={"Huevos a la Mexicana","Chilauiles","Juego de Naranja","Coctel de Frtutas",
        "Malteada","Hotcakes","Crepas"};
    String[] comidas={"Enchiladas Rojas","Tacos","Pizza","Pollo empanizado","Enchiladas Verdes",
            "Mole de olla","Pozole"};
    String[] cenas={"Tacos de Costilla","Tacos de pastor","Quesadilla","Ensalada","Pozole",
            "Chocolate","Champurrado","Atole de Champurrado"};
    ArrayAdapter<String> adapter;
    MenuComponent desayunosMenu= new Menu("Menu desayunos","Desayunos");
    MenuComponent comidasMenu= new Menu("Menu comidas","Comidas");
    MenuComponent cenasMenu= new Menu("Menu cenas","Cenas");
    MenuComponent allMenus=new Menu("Todos los Menus","Menu combinado");
    TextView txtOrden;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cmbMenuSeleccionado=(Spinner)findViewById(R.id.cmb_menu_disponible);
        cmbMenus=(Spinner)findViewById(R.id.cmb_menus);
        btnAgregarPlatillo=(Button)findViewById(R.id.btn_agregar);
        btnMostrarOrden=(Button)findViewById(R.id.btn_mostrar_orden);
        txtOrden=(TextView)findViewById(R.id.txt_orden);

         adapter= new ArrayAdapter<String>
                (this,R.layout.spinner_item,desayunos);
        cmbMenuSeleccionado.setAdapter(adapter);
       cmbMenuSeleccionado.setOnItemSelectedListener(this);
        //cmbMenus.setAdapter(adapter);
        cmbMenus.setOnItemSelectedListener(this);

        btnAgregarPlatillo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int m=(int)cmbMenus.getSelectedItemId();
                int p=(int)cmbMenuSeleccionado.getSelectedItemId();
                MenuItem menuItem=null;
                switch(m) {//tipo de menu
                    case 0://desayunos
                        switch (p) {//platillo
                            case 0://huevos a la mexicana
                                menuItem = new MenuItem("Huevos a la Mexicana", "Huevos estrellados" +
                                        "con salsa verde", false, 25.0);
                                break;
                            case 1:
                                menuItem = new MenuItem("Chilaquiles", "Chilaquiles en salsa roja"
                                        , true, 25.0);
                                break;
                        }//fin del switch desayunos
                        desayunosMenu.add(menuItem);//para agregar el el emento al menu
                        //Toast.makeText(getApplicationContext(),"Se agrego platillo!!",
                               // Toast.LENGTH_SHORT).show();
                        txtOrden.setText(allMenus.print());
                        break;
                    case 1://comidas
                        switch (p) {//platillo
                            case 0://chiles rellenos
                                menuItem = new MenuItem("Chiles Rellenos", "Chile rellenos de " +
                                        "queso panela", true, 25.0);
                                break;
                            case 1://Pollo empanizado
                                menuItem = new MenuItem("Pollo Empanizado", "Milanes de pollo con papas",
                                        true, 40.0);
                                break;
                        }
                        comidasMenu.add(menuItem);
                        //Toast.makeText(getApplicationContext(),"Se agrego platillo!!",
                          //      Toast.LENGTH_SHORT).show();
                        txtOrden.setText(allMenus.print());
                        break;
                    case 2://cenas
                        switch (p) {//platillo
                            case 0://Tacos al pastor
                                menuItem = new MenuItem("Tacos al Pastor", "Orden de 4 tacos",
                                        false, 25.0);
                                break;
                            case 1://Quesadillas
                                menuItem = new MenuItem("Quesadillas","Orden de 2 quesadillas de flor" +
                                        "de calabaza", false, 20.0);
                                break;
                        }
                        comidasMenu.add(menuItem);
                        //Toast.makeText(getApplicationContext(),"Se agrego platillo!!",
                          //      Toast.LENGTH_SHORT).show();
                        txtOrden.setText(allMenus.print());
                        break;
                }

            }
        });

        btnMostrarOrden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allMenus.add(desayunosMenu);
                allMenus.add(comidasMenu);
                allMenus.add(cenasMenu);
                Toast.makeText(getApplicationContext(),allMenus.print(),Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        int m=0;//menu
        if(adapterView.getId()==R.id.cmb_menus){// menu principal
            m=(int)cmbMenus.getSelectedItemId();

            switch((int)cmbMenus.getSelectedItemId()){
                case 0:
             adapter= new ArrayAdapter<String>
                    (this,R.layout.spinner_item,desayunos);
            cmbMenuSeleccionado.setAdapter(adapter);
                    break;
                case 1:
                    adapter= new ArrayAdapter<String>
                            (this,R.layout.spinner_item,comidas);
                    cmbMenuSeleccionado.setAdapter(adapter);
                    break;
                case 2:
                    adapter= new ArrayAdapter<String>
                            (this,R.layout.spinner_item,cenas);
                    cmbMenuSeleccionado.setAdapter(adapter);
                    break;
            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
