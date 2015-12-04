package utad_dam.actividad_5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lidiamartin.pmdm_lib.QBAdmin.JSONAdmin.JSONParse;
import com.example.lidiamartin.pmdm_lib.QBAdmin.QBAdmin;
import com.example.lidiamartin.pmdm_lib.QBAdmin.QBAdminIdioma;
import com.example.lidiamartin.pmdm_lib.QBAdmin.QBAdminIdiomaListener;
import com.example.lidiamartin.pmdm_lib.QBAdmin.QBAdminListener;
import com.example.lidiamartin.pmdm_lib.QBAdmin.QBAdminTabla;
import com.example.lidiamartin.pmdm_lib.QBAdmin.QBUsersLogin;
import com.example.lidiamartin.pmdm_lib.QBAdmin.QBUsersLoginListener;
import com.quickblox.customobjects.model.QBCustomObject;
import com.quickblox.users.model.QBUser;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements QBAdminListener, QBUsersLoginListener, QBAdminIdiomaListener{
    private QBAdmin qbAdmin;
    private QBAdminTabla qbAdminTabla;
    private QBAdminIdioma qbAdminIdioma;

    private JSONParse jsonParse;
    private QBUsersLogin qbUsersLogin;
    private ArrayList<QBCustomObject> dataLang;
    private TextView tv1;
    private TextView tv2;
    private EditText et1;
    private EditText et2;
    private Button botonLogin;
    private String idioma="1";
    private String nombre;
    private String password;


    buttonListener botonListener;

    // Datos para logearse al QBX
    private String apId ="31577";
    private String apKey="TDOPDrKwaDCbV3M";
    private String apSecret="5LKVsTdxbdTmZ-c";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonListener = new buttonListener(this);

        tv1 = (TextView) findViewById(R.id.textView1);
        tv2 = (TextView) findViewById(R.id.textView2);
        et1 = (EditText) findViewById(R.id.editText3);
        et2 = (EditText) findViewById(R.id.editText4);
        botonLogin = (Button) findViewById(R.id.button2);
        botonLogin.setOnClickListener(botonListener);

        qbAdmin = new QBAdmin(apId, apKey, apSecret);
        qbUsersLogin=new QBUsersLogin();
        qbAdminIdioma=new QBAdminIdioma();

        qbUsersLogin.addQBUserLoginListener(this);
        qbAdminIdioma.addIdiomaListener(this);

        qbAdmin.addQBAdminListener(this);
        qbAdmin.sessionSimple();




        //


       /* qbAdminTabla = new QBAdminTabla();
        qbAdminTabla.addListeners(this);*/

        //jsonParse = new JSONParse();

      //  Log.v("MainActivity", " json ");

        //jsonParse.execute();

    }

    public void logear(){

        nombre = String.valueOf(et1.getText());
        password = String.valueOf(et2.getText());

        qbUsersLogin.loginUsuario(nombre, password);
    }

   @Override
    public void sessionCreada(boolean esCreada) {
        if (esCreada) {
            Log.v("sessionCreada", " session creada " + esCreada);
           // qbAdminTabla.getData(idioma);


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
        botonLogin.setText(arrValor.get(2).toString());
    }



    @Override
    public void login(boolean logeado) {

        if (logeado == true){

            lanzar1();

            Toast.makeText(MainActivity.this, et1.getText() + " Ha logueado con éxito ", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, " Usuario o contraseña inválidos ", Toast.LENGTH_SHORT).show();
        }

    }

    public void lanzar1() {
        Intent i = new Intent(this, Activity1.class );
        startActivity(i);
    }


    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioButton:
                if (checked)
                    idioma = "1";
                break;
            case R.id.radioButton2:
                if (checked)
                    idioma = "2";
                break;
           /* case R.id.radioButton3:
                if (checked)
                    idioma = "3";
                break;*/
        }

        if (idioma.equals("1")){
            qbAdminIdioma.getData(idioma);
        } else   if (idioma.equals("2")){
            qbAdminIdioma.getData(idioma);
        } /*else   if (idioma.equals("3")){
            qbAdminIdioma.getData(idioma);
        }*/
    }

    /*public TextView getTv1() {
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
    }*/




}
