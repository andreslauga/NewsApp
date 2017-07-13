package digitalhouse.android.a0317moacns1c_01.Model.DAO;

import java.util.List;

import digitalhouse.android.a0317moacns1c_01.Model.POJO.Noticia;
import digitalhouse.android.a0317moacns1c_01.util.NewsHelper;
import digitalhouse.android.a0317moacns1c_01.util.ResultListener;

/**
 * Created by santibodino on 3/7/17.
 */

public class DaoNoticiaInternet {

    public void getListaDeNoticiasFromInternet(final ResultListener<List<Noticia>> listenerControllerCalamardo, String fuente) {
        TareaNoticiaInternet tarea = new TareaNoticiaInternet(listenerControllerCalamardo);
        tarea.execute(NewsHelper.getArticulos(fuente));
    }
}
