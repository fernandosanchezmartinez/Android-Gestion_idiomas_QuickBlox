package com.example.lidiamartin.pmdm_lib.QBAdmin;

import android.os.Bundle;

import com.quickblox.core.QBEntityCallbackImpl;
import com.quickblox.users.QBUsers;
import com.quickblox.users.model.QBUser;

import java.util.List;

/**
 * Created by hector.navarro on 27/11/2015.
 */
public class QBUsersLogin {

    boolean exito;
    private QBUsersLoginListener listener;

    public void addQBUserLoginListener(QBUsersLoginListener list) {
        listener = list;
    }

    // hay que pasar por parametro el ID y password
    public void loginUsuario(String usuario, String password) {

        QBUser user = new QBUser(usuario, password);

        QBUsers.signIn(user, new QBEntityCallbackImpl<QBUser>() {
            @Override
            public void onSuccess(QBUser user, Bundle params) {
                exito = true;
                listener.login(exito);
            }

            @Override
            public void onError(List<String> errors) {
                exito = false;
                listener.login(exito);
            }
        });
    }
}
