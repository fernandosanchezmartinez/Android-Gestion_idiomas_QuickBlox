package com.example.lidiamartin.pmdm_actividad04;


import android.util.Log;
import android.view.View;

/**
 * Created by lidia.martin on 13/11/2015.
 */
public class Main2AcivityUI implements Runnable   {
    Main2Activity ma2;
    public Main2AcivityUI(Main2Activity ma2){
        this.ma2=ma2;
    }
    @Override
    public void run(){
        Log.v("Main2AcivityUI","Entra");
        ma2.getIv1().setVisibility(View.GONE);
        ma2.getIv2().setVisibility(View.VISIBLE);
    }
}
