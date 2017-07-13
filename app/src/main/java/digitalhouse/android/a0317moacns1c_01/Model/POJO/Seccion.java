package digitalhouse.android.a0317moacns1c_01.Model.POJO;

/**
 * Created by andreslauga on 6/12/17.
 */

public class Seccion {

    private String nombre;
    private String canal;

    public String getCanal() {
        return canal;
    }

    public Seccion(String nombre, String canal) {
        this.nombre = nombre;
        this.canal = canal;
    }

    public String getNombre() {
        return nombre;
    }
}
