package utad_dam.actividad_5;

import android.view.View;
import android.widget.Button;

/**
 * Created by hector.navarro on 04/12/2015.
 */
public class buttonListener implements View.OnClickListener{

    MainActivity mainActivity;

    public buttonListener(MainActivity ma1){
        mainActivity=ma1;
    }

    @Override
    public void onClick(View v) {

        Button botonLogin = (Button)v;
        if(botonLogin.getId()==(R.id.button2))
        {
            mainActivity.logear();
        }
    }
}
