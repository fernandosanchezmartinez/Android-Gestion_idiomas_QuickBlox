package utad_dam.actividad_5;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by hector.navarro on 04/12/2015.
 */

public class AdaptadorLista extends BaseAdapter {

    private Activity actividad;
    private ArrayList<evento> alumnos = new ArrayList();


    public AdaptadorLista (Activity actividad, ArrayList alumnos)
    {
        this.alumnos = alumnos;

        this.actividad = actividad;
        if (getCount() == 0){

        }
    }

    @Override
    public int getCount() {
        return alumnos.size();
    }

    @Override
    public Object getItem(int i) {
        return alumnos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        Log.v("MILISTA", "Inflando... pos:" + position + " alumno " + alumnos.get(position)) ;

        LayoutInflater lf =  actividad.getLayoutInflater();
        View v = lf.inflate(R.layout.layout_elemento, null, true);

        TextView ID = (TextView)v.findViewById(R.id.id);
        TextView Evento = (TextView)v.findViewById(R.id.evento);
        TextView Fecha = (TextView)v.findViewById(R.id.fecha);




        ID.setText(alumnos.get(position).getID());
        Evento.setText(alumnos.get(position).getEvento());
        Fecha.setText(alumnos.get(position).getFecha());


        return v;
    }




}
