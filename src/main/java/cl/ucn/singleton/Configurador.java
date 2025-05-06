package cl.ucn.singleton;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class Configurador {

    private Configurador(){}

    private static Configurador instance;

    public static Configurador getInstance(){
        if(instance == null)
            instance = new Configurador();
        return instance;
    }
    public String getFechaActual(){

        LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter formato = DateTimeFormat.forPattern("yyyy-MM-dd");
        String fechaFormateada = fechaActual.toString(formato);
        return fechaFormateada;
    }
}
