package digitalhouse.android.a0317moacns1c_01.View.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import digitalhouse.android.a0317moacns1c_01.Model.POJO.Noticia;
import digitalhouse.android.a0317moacns1c_01.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentDetalle extends Fragment {

    private Context context;

    public static final String TITULO_NOTICIA = "tituloNoticia";
    public static final String CONTENIDO_NOTICIA = "contenidoNoticia";
    public static final String IMAGEN_NOTICIA = "imagenNoticia";
    public static final String AUTOR_NOTICIA = "autorNoticia";
    public static final String FECHA_NOTICIA = "fechaNoticia";



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detalle, container, false);

        //EXTRAER EL BUNDLE
        Bundle bundle = getArguments();

        String title = bundle.getString(TITULO_NOTICIA);
        String description = bundle.getString(CONTENIDO_NOTICIA);
        String urlToImage = bundle.getString(IMAGEN_NOTICIA);
        String author = bundle.getString(AUTOR_NOTICIA);
        String publishedAt = bundle.getString(FECHA_NOTICIA);





        Noticia unaNoticia = new Noticia(title, description, urlToImage, author, publishedAt);

        TextView textViewTitulo = (TextView) view.findViewById(R.id.textViewDetalleTituloNoticia);
        textViewTitulo.setText(unaNoticia.getTitulo());

        TextView textViewContenido = (TextView) view.findViewById(R.id.textViewDetallePContenidoNoticia);
        textViewContenido.setText(unaNoticia.getContenido());

        ImageView imageView = (ImageView) view.findViewById(R.id.imageViewDetalleNoticia);
        //imageView.setImageResource(unaNoticia.getImagen());
        Picasso.with(context)
                .load(unaNoticia.getImagen())
                .into(imageView);



        TextView textViewAutor = (TextView) view.findViewById(R.id.textViewDetalleAutor);
        textViewAutor.setText(unaNoticia.getAutor());

        TextView textViewFecha= (TextView) view.findViewById(R.id.textViewDetalleFecha);
        textViewFecha.setText(unaNoticia.getFecha());



        return view;
    }

}
