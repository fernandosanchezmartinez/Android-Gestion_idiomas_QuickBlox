package utad_dam.actividad_5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lidiamartin.pmdm_lib.QBAdmin.JSONAdmin.JSONParse;
import com.example.lidiamartin.pmdm_lib.QBAdmin.QBAdmin;
import com.example.lidiamartin.pmdm_lib.QBAdmin.QBAdminListener;
import com.example.lidiamartin.pmdm_lib.QBAdmin.QBAdminTabla;
import com.example.lidiamartin.pmdm_lib.QBAdmin.QBUsersLogin;
import com.quickblox.customobjects.model.QBCustomObject;
import com.quickblox.users.model.QBUser;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements QBAdminListener {
    private QBAdmin qbAdmin;
    private QBAdminTabla qbAdminTabla;
    private JSONParse jsonParse;
    private QBUsersLogin qbUsersLogin;
    private ArrayList<QBCustomObject> dataLang;
    private TextView tv1;
    private TextView tv2;
    private EditText et1;
    private EditText et2;

    private String idioma="1";

    // Datos para logearse al QBX
    private String apId ="31577";
    private String apKey="TDOPDrKwaDCbV3M";
    private String apSecret="5LKVsTdxbdTmZ-c";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = (TextView) findViewById(R.id.textView1);
        tv2 = (TextView) findViewById(R.id.textView2);
        et1 = (EditText) findViewById(R.id.editText3);
        et2 = (EditText) findViewById(R.id.editText4);
        qbAdmin = new QBAdmin(apId, apKey, apSecret);

        qbAdmin.addQBAdminListener(this);
        qbAdmin.sessionSimple();

        //


       /* qbAdminTabla = new QBAdminTabla();
        qbAdminTabla.addListeners(this);*/

        //jsonParse = new JSONParse();

      //  Log.v("MainActivity", " json ");

        //jsonParse.execute();

    }


    @Override
    public void sessionCreada(boolean esCreada) {
        if (esCreada) {
            Log.v("sessionCreada", " session creada " + esCreada);
            qbAdminTabla.getData(idioma);


        } else {
            Log.v("sessionCreada", " session NO creada " + esCreada);
        }
    }

    @Override
    public void getIdioma(ArrayList<QBCustomObject> arrCustomObjects) {
        ArrayList<String> arrValor = new ArrayList<>();
        this.dataLang = arrCustomObjects;
        if (arrCustomObjects != null) {


            Log.v("MainActivity", "cargando datos");
            for (int i = 0; i < dataLang.size(); i++) {
                HashMap<String, Object> fields = dataLang.get(i).getFields();

                Log.v("MainActivity", "Los datos son: " + fields.get("valor"));
                arrValor.add(fields.get("valor").toString());

            }
        }
        tv1.setText(arrValor.get(0).toString());
        tv2.setText(arrValor.get(1).toString());
    }

    @Override
    public void login(boolean logeado) {

        if (logeado == true){
            // Lanzar al otro activity
        } else {
            // Usuario contraseña invalidos
        }

    }


    public TextView getTv1() {
        return tv1;
    }

    public void setTv1(TextView tv1) {
        this.tv1 = tv1;
    }

    public TextView getTv2() {
        return tv2;
    }

    public void setTv2(TextView tv2) {
        this.tv2 = tv2;
    }


}
