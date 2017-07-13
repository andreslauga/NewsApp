package digitalhouse.android.a0317moacns1c_01.View.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import digitalhouse.android.a0317moacns1c_01.Controller.NoticiaController;
import digitalhouse.android.a0317moacns1c_01.Model.POJO.Noticia;
import digitalhouse.android.a0317moacns1c_01.Model.POJO.Seccion;
import digitalhouse.android.a0317moacns1c_01.R;
import digitalhouse.android.a0317moacns1c_01.View.Adapters.AdapterListNoticias;
import digitalhouse.android.a0317moacns1c_01.util.ResultListener;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentRecyclerView extends Fragment {

    private static final String CLAVE_FUENTE = "fuente";
    private List<Noticia> listaNoticia;
    private AdapterListNoticias adapter;
    private RecyclerView recyclerViewNoticias;
    private Notificable notificable;
    private Seccion seccion;
    private Context context;

    public static final String CLAVE_SECCION = "claveSeccion";

    public static FragmentRecyclerView fabricaDeFragmentsDeSecciones(Seccion seccion, String fuente) {
        FragmentRecyclerView fragmentRecyclerView = new FragmentRecyclerView();
        Bundle args = new Bundle();
        args.putString(CLAVE_SECCION, seccion.getNombre());
        args.putString(CLAVE_FUENTE, fuente);

        fragmentRecyclerView.setArguments(args);
        return fragmentRecyclerView;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recycler_view, container, false);
        context = getContext();
        listaNoticia = new ArrayList<>();

        Bundle bundle = getArguments();


        //Busco el RecyclerView para luego poder setearle el adaptador
        recyclerViewNoticias = (RecyclerView) view.findViewById(R.id.recyclerViewNoticias);

        //Le decimos que no va a variar el tamanio de la lista
        recyclerViewNoticias.setHasFixedSize(true);

        //Le pedimos que muestre las cosas en forma de lista
        recyclerViewNoticias.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        //Le pedimos que muestre las cosas en forma de grilla
        //recyclerViewPersonajes.setLayoutManager(new GridLayoutManager(this,2));


        //Aca creo el adapter que necesita tener un contexto y una lista de personajes
        adapter = new AdapterListNoticias(listaNoticia, getContext());

        NoticiaController noticiaController = new NoticiaController();
        noticiaController.getListaDeNoticiasFromInternet(context, new ResultListener<List<Noticia>>() {
            @Override
            public void finish(List<Noticia> resultado) {
                adapter.setListaDeNoticias(resultado);
            }
        }, bundle.getString(CLAVE_FUENTE));

        //Aca le paso un escuchador al recycler para poder subscribirme y enterarme de alguna notificacion
        View.OnClickListener listenerJuguetes = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ESTO SE UTILIZA PARA OBTENER LA POSITION DE LO QUE FUE CLICKEADO.
                int posicion = recyclerViewNoticias.getChildAdapterPosition(view);
                List<Noticia> listaNoticiasDestacada = adapter.getNoticia();

                Noticia noticiaClickeado = listaNoticiasDestacada.get(posicion);
                notificable.recibirNoticiaClickeado(noticiaClickeado);
            }
        };


        adapter.setListener(listenerJuguetes);
        recyclerViewNoticias.setAdapter(adapter);

        return view;
    }

    //CON EL METODO ON ATTACH ME GUARDO EL CONTEXTO EN DONDE ESTA INCRUSTADO EL FRAGMENT
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.notificable = (Notificable) context;
    }



    public interface Notificable {
        public void recibirNoticiaClickeado(Noticia noticia);
    }
}
