package digitalhouse.android.a0317moacns1c_01.View.Adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import digitalhouse.android.a0317moacns1c_01.Model.POJO.Noticia;
import digitalhouse.android.a0317moacns1c_01.R;

/**
 * Created by andreslauga on 5/29/17.
 */

public class AdapterListNoticias extends RecyclerView.Adapter implements View.OnClickListener {

    private List<Noticia> listaDeNoticias;
    private Context context ;
    private View.OnClickListener listener;

    public void setListaDeNoticias(List<Noticia> listaDeNoticias) {
        this.listaDeNoticias = listaDeNoticias;
        notifyDataSetChanged();
    }

    public AdapterListNoticias(List<Noticia> listaDeNoticias, Context context) {
        this.listaDeNoticias = listaDeNoticias;
        this.context = context;
    }

    public List<Noticia> getNoticia() {
        return listaDeNoticias;
    }

    //Devuelve un ViewHolder con la View
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View viewDeLaCelda = layoutInflater.inflate(R.layout.listview_detalle_celda,parent,false);
        NoticiaViewHolder noticiaViewHolder = new NoticiaViewHolder(viewDeLaCelda);

        //Aca declaro que voy a responder a cuando un usuario haga click en una de las celdas
        //Para esto declare arriba de to-do
        viewDeLaCelda.setOnClickListener(this);

        return noticiaViewHolder;
    }

    //Acá es donde se une el ViewHolder con el elemento a mostrar
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        Noticia unaNoticia = listaDeNoticias.get(position);
        NoticiaViewHolder noticiaViewHolder = (NoticiaViewHolder) holder;
        noticiaViewHolder.cargarNoticia(unaNoticia);

    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return listaDeNoticias.size();
    }


    public void setListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    public void removerPersonaje(Noticia noticia){
        listaDeNoticias.remove(noticia);
        notifyDataSetChanged();
    }

    //Aca hago el pasamanos, por un lado el recycler escucha cuando una celda
    //es clickeada y este le avisa a su escuchador que una vista fue clickeada
    @Override
    public void onClick(View v) {
        listener.onClick(v);
    }



    //Aca creo al viewHolder que va a mantener las referencias
    //de los elementos de la celda y va a saber cargarla
    private class NoticiaViewHolder extends RecyclerView.ViewHolder{

        private TextView textViewNoticia;
        private TextView textViewContenido;
        private ImageView imageView;

        public NoticiaViewHolder(View itemView) {
            super(itemView);
            textViewNoticia = (TextView) itemView.findViewById(R.id.textViewTitulo);
            textViewContenido = (TextView) itemView.findViewById(R.id.textViewContenido);
            imageView = (ImageView) itemView.findViewById(R.id.imageViewNoticia);
        }

        public void cargarNoticia(Noticia noticiaAmostrar){

            textViewNoticia.setText(noticiaAmostrar.getTitulo());
            Typeface face= Typeface.createFromAsset(context.getAssets(),"fonts/gothamultra.otf");
            textViewNoticia.setTypeface(face);
            textViewContenido.setText(noticiaAmostrar.getContenido());
            Picasso.with(context)
                    .load(noticiaAmostrar.getImagen())
                    .into(imageView);
        }
    }

}
