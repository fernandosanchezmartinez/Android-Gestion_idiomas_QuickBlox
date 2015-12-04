package com.example.lidiamartin.pmdm_lib.QBAdmin;

import android.os.Bundle;
import android.util.Log;

import com.quickblox.core.QBEntityCallbackImpl;
import com.quickblox.core.request.QBRequestGetBuilder;
import com.quickblox.customobjects.QBCustomObjects;
import com.quickblox.customobjects.model.QBCustomObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hector.navarro on 04/12/2015.
 */
public class QBAdminIdioma {

    private QBAdminIdiomaListener listener;

    public void addIdiomaListener(QBAdminIdiomaListener Listener) {
        this.listener = Listener;
    }

    /**
     * Obtiene los datos según el idioma
     */
    public void getData(String idioma) {
        QBRequestGetBuilder requestBuilder = new QBRequestGetBuilder();

        requestBuilder.eq("idi", idioma);


        QBCustomObjects.getObjects("Strings", requestBuilder, new QBEntityCallbackImpl<ArrayList<QBCustomObject>>() {
            @Override
            public void onSuccess(ArrayList<QBCustomObject> arrCustomObjects, Bundle params) {
                Log.v("QBAdminTabla", "Conx. Data correcto " + arrCustomObjects);
                listener.getIdioma(arrCustomObjects);

            }

            @Override
            public void onError(List<String> errors) {
                Log.v("QBAdminTabla", "Error Conx. Data " + errors);
                listener.getIdioma(null);

            }
        });
    }
}
