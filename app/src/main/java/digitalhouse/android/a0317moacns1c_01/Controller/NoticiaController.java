package digitalhouse.android.a0317moacns1c_01.Controller;

import android.content.Context;

import java.util.List;

import digitalhouse.android.a0317moacns1c_01.Model.DAO.DaoNoticia;
import digitalhouse.android.a0317moacns1c_01.Model.DAO.DaoNoticiaInternet;
import digitalhouse.android.a0317moacns1c_01.Model.POJO.Noticia;
import digitalhouse.android.a0317moacns1c_01.util.HTTPConnectionManager;
import digitalhouse.android.a0317moacns1c_01.util.ResultListener;

/**
 * Created by santibodino on 3/7/17.
 */

public class NoticiaController {


    public List<Noticia> getListaDeNoticia(Context context) {
        DaoNoticia daoNoticia = new DaoNoticia();

        //List<Noticia> listaDeNoticias = daoNoticia.getListaDeNoticia(context);

        return null;


    }

    public void getListaDeNoticiasFromInternet(Context context, final ResultListener<List<Noticia>> listenerDeLaView, String fuente) {
        if (HTTPConnectionManager.isNetworkingOnline(context)) {

            DaoNoticiaInternet daoNoticiaInternet = new DaoNoticiaInternet();


            daoNoticiaInternet.getListaDeNoticiasFromInternet(new ResultListener<List<Noticia>>() {
                @Override
                public void finish(List<Noticia> resultado) {
                    listenerDeLaView.finish(resultado);
                }
            }, fuente);
        }
    }


}
