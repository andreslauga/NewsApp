package digitalhouse.android.a0317moacns1c_01.Model.DAO;

import android.content.Context;
import android.content.res.AssetManager;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import digitalhouse.android.a0317moacns1c_01.Model.POJO.Noticia;
import digitalhouse.android.a0317moacns1c_01.Model.POJO.NoticiaContainer;

public class DaoNoticia {



    public List<Noticia> getListaDeNoticia(Context context){
        List<Noticia> listaDeNoticia = new ArrayList<>();
        //listaDeNoticia = getListaDeNoticia();


        return listaDeNoticia;
    }

    //Creo un método para pedir la lista de productos del archivo Json
    public List<Noticia> getListaDeNoticiasFromArchivo(Context context){
        List<Noticia> listaDeNoticia = new ArrayList<>();

        //Pedimos el assetManager para acceder a los archivos dentro de la carpeta assets
        AssetManager assetManager = context.getAssets();
        InputStream archivoJsonNoticias = null;
        BufferedReader bufferedReader = null;

        try {
            //Creamos un stream para leer el archivo Json.
            archivoJsonNoticias = assetManager.open("listadetracks.json");
            bufferedReader = new BufferedReader(new InputStreamReader(archivoJsonNoticias));

            //Creamos un Objeto de la clase Gson que me permitirá sencillamente parsear el Json.
            Gson gson = new Gson();

            //Utilizando el objeto gson y el método fromJson, realizamos el parsing el archivo
            // que tenemos en el bufferReaderIn y utilizando como “molde” la clase ProductoContainer.
            NoticiaContainer noticiaContainer = gson.fromJson(bufferedReader, NoticiaContainer.class);

            // Devuelvo la lista de productos
            listaDeNoticia = noticiaContainer.getListaDeNoticias();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Cierro el Buffer
                if (bufferedReader != null) {
                    bufferedReader.close();
                } else if (archivoJsonNoticias != null) {
                    archivoJsonNoticias.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        //Devuelvo null si no se pudo leer el archivo
        return listaDeNoticia;
    }




    /*private List<Noticia> getListaDeNoticia() {

        List<Noticia> unaListaNoticia = new ArrayList();
        Noticia donald = new Noticia("El inesperado invento de Apple", "La nueva sede central de Apple en Silicon Valley, California, fue presentada a la prensa ayer por la mañana.  La compañia espera tomar la delantera de la competencia en la intelegencia artificial con este nueve invento.  Las acciones comenzar a subir abruptamente ya que los inversores confian en que la compañia seguira creciendo a largo y corto plazo.  ya que los inversores confian en que la compañia seguira creciendo a largo y corto plazo.", R.drawable.applecampus, "Como para hacer frente a los continuos avanzes de Google, Apple lanza este nuevo producto al mercado:", "Por Mike Forster", "31 de mayo del 2017", "foto del nuevo producto");
        Noticia messi = new Noticia("El motivo del viaje a China de Lionel Messi", "Lionel Messi cerró su temporada con Barcelona con un sabor agridulce, pese a que el sábado pasado se alzó con la Copa del Rey tras vencer en la final al Alavés. Los catalanes finalmente sucumbieron en la batalla con Real Madrid por La Liga y quedaron lejos en la puja por la Champions League. Pero la agenda del rosarino continúa. Los próximos dos desafíos de la Pulga serán con la camiseta de la Selección argentina: el 9 de junio ante Brasil, en Melbourne, y el 13 del mismo mes contra Singapur, en Singapur. Estos dos juegos marcarán el inicio de la era Jorge Sampaoli al frente de la Albiceleste.", R.drawable.messi, "El futbolista del Barcelona hará una escala en Asia, antes de desembarcar en Oceanía para vestir la camiseta albiceleste", "Por Martin Flores ", "31 de mayo de 2017", "Festejo de Lionel en el segundo gol del partido. ");
        Noticia spinner = new Noticia("¿Sirven para algo los \"fidget spinners\"?", "Los fidget spinners se componen de una pieza de plástico con un eje central giratorio y tres prolongaciones, cada una, a su vez, equipada con un cojinete en el extremo. Si sujetas el dispositivo por el centro y haces girar uno de los cojinetes de los extremos, todo el conjunto se pondrá a girar por inercia durante unos 30 segundos, proporcionando una sensación placentera. ¡Eso es todo!", R.drawable.spinner, "Una reseña sincera sobre estos juguetes.","Por Katherine Gillespie; traducido por Mario Abad", "31 de mayo de 2017", "Una reseña sincera sobre estos juguetes.");
        Noticia jupiter = new Noticia("La NASA reveló la primera imagen de Júpiter desde adentro", "La agencia espacial estadounidense se decidió a por fin publicar la primera imagen de la historia de Júpiter desde adentro. La fotografía había sido captada el 27 de agosto de 206 durante el primer sobrevuelo de la sonda.", R.drawable.jupiter, "La agencia espacial estadounidense publicó la fotografía obtenida gracias a la misión de la sonda Juno. Tomada el año pasado, muestra los impactantes anillos y las estrellas de Orión en torno al planeta más grande del sistema solar", "Por Lucas Smith ", "30 de mayo de 2017", "Juno captó la primera fotografía de Júpiter (iStock)");

        unaListaNoticia.add(donald);
        unaListaNoticia.add(messi);
        unaListaNoticia.add(spinner);
        unaListaNoticia.add(jupiter);
        unaListaNoticia.add(donald);
        unaListaNoticia.add(messi);
        unaListaNoticia.add(spinner);
        unaListaNoticia.add(jupiter);
        unaListaNoticia.add(donald);
        unaListaNoticia.add(messi);
        unaListaNoticia.add(spinner);
        unaListaNoticia.add(jupiter);

        return unaListaNoticia;

    }*/
}
