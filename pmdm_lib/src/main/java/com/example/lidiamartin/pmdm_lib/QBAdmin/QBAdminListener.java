package com.example.lidiamartin.pmdm_lib.QBAdmin;

import com.quickblox.customobjects.model.QBCustomObject;

import java.util.ArrayList;

/**
 * Created by lidia.martin on 06/11/2015.
 */
public interface QBAdminListener {

    public void sessionCreada(boolean esCreada);
    public void getIdioma(ArrayList<QBCustomObject> datos);
    public void login(boolean logeado);



}
