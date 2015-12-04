package com.example.lidiamartin.pmdm_lib.QBAdmin.JSONAdmin;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by hector.navarro on 19/11/2015.
 */
public class JSONParse extends AsyncTask<String,String,String> {
    HttpURLConnection urlConnection;

    @Override
    protected void onPreExecute(){
        super.onPreExecute();
    }

    @Override
    protected  String doInBackground(String... args){
        StringBuilder result = new StringBuilder();

        try{
            //URL url = new URL("http://10.0.2.2/testJony.php");
            URL url = new URL("http://10.0.2.2/PHPJSONJAVA/getUsuariosJSON.php");
            Log.v("JSONParse", "1. " + url);
            publishProgress("10%");
            urlConnection = (HttpURLConnection) url.openConnection();
            publishProgress("50%");
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            String line;
            while((line=reader.readLine()) != null) {
                result.append(line);
            }

            publishProgress("90%");
        } catch (Exception e){
            Log.v("JSONParse", "2. "+e);
            e.printStackTrace();
        } finally {
            urlConnection.disconnect();
            publishProgress("100%");
        }

        return result.toString();
    }

    @Override
    protected void onProgressUpdate(String... values){
        super.onProgressUpdate(values);
        Log.v("JSONParse",values[0]);
    }

    @Override
    protected void onPostExecute(String json) {
        Log.v("JSONParse","3. " +json);
    }
}
