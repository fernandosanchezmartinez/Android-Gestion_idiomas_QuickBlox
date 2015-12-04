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

        private QBAdminListener listener;

        public void addListeners(QBAdminListener Listener) {
            this.listener = Listener;
        }

        /**
         * Obtiene los datos según el idioma
         */
        public void getData(String idioma) {
            QBRequestGetBuilder requestBuilder = new QBRequestGetBuilder();

            requestBuilder.eq("idi", idioma);


            QBCustomObjects.getObjects("actividad04T", requestBuilder, new QBEntityCallbackImpl<ArrayList<QBCustomObject>>() {
                @Override
                public void onSuccess(ArrayList<QBCustomObject> arrCustomObjects, Bundle params) {
                    Log.v("QBAdminTabla", "Conx. Data correcto");
                  //  listener.getIdioma(arrCustomObjects);
                }

                @Override
                public void onError(List<String> errors) {
                    Log.v("QBAdminTabla", "Error Conx. Data "+errors);
                  //  listener.getIdioma(null);

                }
            });
        }

}
