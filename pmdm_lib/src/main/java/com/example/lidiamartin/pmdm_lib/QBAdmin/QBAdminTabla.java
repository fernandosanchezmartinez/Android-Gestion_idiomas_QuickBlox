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
 * Created by lidia.martin on 13/11/2015.
 */
public class QBAdminTabla {

        private QBAdminTablaListener listener;

        public void addListeners(QBAdminTablaListener Listener) {
            this.listener = Listener;
        }

        /**
         * Obtiene los datos según el idioma
         */
        public void getData() {
            QBRequestGetBuilder requestBuilder = new QBRequestGetBuilder();




            QBCustomObjects.getObjects("Eventos", requestBuilder, new QBEntityCallbackImpl<ArrayList<QBCustomObject>>() {
                @Override
                public void onSuccess(ArrayList<QBCustomObject> arrCustomObjects, Bundle params) {
                    Log.v("QBAdminTabla", "Conx. Data correcto "+arrCustomObjects);

                    listener.cargarEventos(arrCustomObjects);
                }

                @Override
                public void onError(List<String> errors) {
                    Log.v("QBAdminTabla", "Error Conx. Data " + errors);


                }
            });
        }

}
