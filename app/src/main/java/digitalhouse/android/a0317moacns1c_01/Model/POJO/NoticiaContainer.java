package digitalhouse.android.a0317moacns1c_01.Model.POJO;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by santibodino on 3/7/17.
 */

public class NoticiaContainer {

    @SerializedName("articles")
    private List<Noticia> listaDeNoticias;


    public List<Noticia> getListaDeNoticias() {
        return listaDeNoticias;
    }

    public void setListaDeNoticias(List<Noticia> listaDeNoticias) {
        this.listaDeNoticias = listaDeNoticias;
    }
}
