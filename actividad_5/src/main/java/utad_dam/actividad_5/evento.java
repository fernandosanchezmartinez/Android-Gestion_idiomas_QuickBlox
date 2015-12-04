package utad_dam.actividad_5;

import android.graphics.drawable.Drawable;

/**
 * Created by hector.navarro on 22/10/2015.
 */
public class evento {

    private String ID = "";
    private String Evento= "";
    private String Fecha = "";


    public evento (String ID, String Evento, String Fecha)
    {

        this.ID = ID;
        this.Evento = Evento;
        this.Fecha = Fecha;

    }

    public String getID() { return ID; }

    public void setID(String ID) { this.ID = ID; }

    public String getEvento() {
        return Evento;
    }

    public void setEvento(String Evento) {
        this.Evento = Evento;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }


}
