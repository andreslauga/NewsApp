package digitalhouse.android.a0317moacns1c_01.Model.DAO;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import digitalhouse.android.a0317moacns1c_01.Model.POJO.Noticia;
import digitalhouse.android.a0317moacns1c_01.Model.POJO.NoticiaContainer;
import digitalhouse.android.a0317moacns1c_01.util.DAOException;
import digitalhouse.android.a0317moacns1c_01.util.HTTPConnectionManager;
import digitalhouse.android.a0317moacns1c_01.util.ResultListener;

/**
 * Created by santibodino on 3/7/17.
 */


    public class TareaNoticiaInternet extends android.os.AsyncTask<String, Void, List<Noticia>> {
        private ResultListener<List<Noticia>> controllerListener;

        public TareaNoticiaInternet(ResultListener<List<Noticia>> controllerListener){
            this.controllerListener = controllerListener;
        }

        @Override
        protected List<Noticia> doInBackground(String... params) {
            List<Noticia> noticiaList = new ArrayList<>();

            String url = params[0];

            HTTPConnectionManager httpConnectionManager = new HTTPConnectionManager();
            InputStream inputStream = null;
            BufferedReader bufferedReader = null;

            try {
                inputStream = httpConnectionManager.getRequestStream(url);
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

                Gson gson = new Gson();
                NoticiaContainer noticiaContainer = gson.fromJson(bufferedReader, NoticiaContainer.class);
                noticiaList = noticiaContainer.getListaDeNoticias();


            } catch (DAOException e){
                e.printStackTrace();
            } finally {

                // Trato de cerrar el buffer reader
                try {
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                } catch (IOException e2){
                    e2.printStackTrace();
                    // Si no pude cerrarlo, trato de cerrar el input stream
                    try {
                        if (inputStream != null) {
                            inputStream.close();
                        }
                    } catch (IOException e3){
                        e3.printStackTrace();
                    }
                }

                // cierro la conexion
                httpConnectionManager.closeConnection();
            }


            return noticiaList;
        }

        @Override
        protected void onPostExecute(List<Noticia> noticiaList) {
            controllerListener.finish(noticiaList);
        }
    }

