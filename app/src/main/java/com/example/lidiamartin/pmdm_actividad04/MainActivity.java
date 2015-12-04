package com.example.lidiamartin.pmdm_actividad04;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.lidiamartin.pmdm_lib.QBAdmin.JSONAdmin.JSONParse;
import com.example.lidiamartin.pmdm_lib.QBAdmin.QBAdmin;
import com.example.lidiamartin.pmdm_lib.QBAdmin.QBAdminListener;
import com.example.lidiamartin.pmdm_lib.QBAdmin.QBAdminTabla;
import com.quickblox.customobjects.model.QBCustomObject;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements QBAdminListener {
    private QBAdmin qbAdmin;
    private QBAdminTabla qbAdminTabla;
    private JSONParse jsonParse;
    private ArrayList<QBCustomObject> dataLang;
    private TextView tv1;
    private TextView tv2;
    private String idioma="1";

    // Datos para logearse al QBX
    private String apId ="31577";
    private String apKey="TDOPDrKwaDCbV3M";
    private String apSecret="5LKVsTdxbdTmZ-c";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        qbAdmin = new QBAdmin(apId, apKey, apSecret);
        qbAdmin.addQBAdminListener(this);
        qbAdmin.sessionSimple();
        qbAdminTabla = new QBAdminTabla();
        qbAdminTabla.addListeners(this);

        jsonParse = new JSONParse();
        Log.v("MainActivity", "################################ JSON #################################################@@@@@@@@@@@@@@@@@#@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@######## ");
        jsonParse.execute();

    }


    @Override
    public void sessionCreada(boolean esCreada) {
        if (esCreada) {
            Log.v("MainActivity", "session creada " + esCreada);
            qbAdminTabla.getData(idioma);


        } else {
            Log.v("MainActivity", "session NO creada " + esCreada);
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

    //@Override
    public void login(boolean logeado) {

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
            case R.id.radioButton3:
                if (checked)
                    idioma = "3";
                    break;
        }

        if (idioma.equals("1")){
            qbAdminTabla.getData(idioma);
        } else   if (idioma.equals("2")){
            qbAdminTabla.getData(idioma);
        } else   if (idioma.equals("3")){
            qbAdminTabla.getData(idioma);
        }
    }

}
