package utad_dam.actividad_5;

import android.app.ListActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.lidiamartin.pmdm_lib.QBAdmin.QBAdminTabla;
import com.example.lidiamartin.pmdm_lib.QBAdmin.QBAdminTablaListener;
import com.quickblox.customobjects.model.QBCustomObject;

import java.util.ArrayList;

/**
 * Created by hector.navarro on 04/12/2015.
 */
public class Activity1 extends ListActivity implements QBAdminTablaListener{

    private QBAdminTabla qbAdminTabla;
    ArrayList alumnos = new ArrayList<evento>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        qbAdminTabla = new QBAdminTabla();
        qbAdminTabla.addListeners(this);
        qbAdminTabla.getData();




        //cargadorEventos();
        /* alumnos.add(new evento("1", "teawsad" , "12/12/1221"));
        alumnos.add(new evento("2", "teawsad" , "15/14/1654"));
        alumnos.add(new evento("3", "teawsad" , "20/85/1541"));
        alumnos.add(new evento("4", "teawsad" , "1/1/1221"));*/

        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_lista_completa);



    }
   // eventos.put(customObjects2.get(i).getFields().get("ids").toString(), customObjects2.get(i).getFields().get("descripcion").toString());



    @Override
    public void cargarEventos(ArrayList<QBCustomObject> customObjects2) {
        for (int i = 0; i < customObjects2.size(); i++) {

            alumnos.add(new evento(customObjects2.get(i).getFields().get("ids").toString(), customObjects2.get(i).getFields().get("descripcion").toString(), customObjects2.get(i).getFields().get("fecha").toString()));
            setListAdapter(new AdaptadorLista(this, alumnos));
        }
    }
}
