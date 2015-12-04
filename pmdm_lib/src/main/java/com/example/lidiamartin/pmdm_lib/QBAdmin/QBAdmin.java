package com.example.lidiamartin.pmdm_lib.QBAdmin;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.quickblox.auth.QBAuth;
import com.quickblox.auth.model.QBSession;
import com.quickblox.core.QBEntityCallbackImpl;
import com.quickblox.core.QBSettings;

import java.util.List;

/**
 * Created by lidia.martin on 06/11/2015.
 */
public class QBAdmin {

    private boolean sessionCreada;
    private QBAdminListener listener;


    public QBAdmin(String id, String key, String secret) {

        QBSettings.getInstance().fastConfigInit(id, key, secret);

    }

    public void addQBAdminListener(QBAdminListener list) {
        listener = list;
    }

    public void sessionSimple() {
        QBAuth.createSession(new QBEntityCallbackImpl<QBSession>() {
            @Override
            public void onSuccess(QBSession session, Bundle params) {
                // success
                sessionCreada = true;
                listener.sessionCreada(sessionCreada);
                Log.v("QBADMIN", "DEBERIA EN LA SESION");
            }

            @Override
            public void onError(List<String> errors) {
                // errors
                sessionCreada = false;
                listener.sessionCreada(sessionCreada);

            }
        });
    }

}
