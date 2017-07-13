package digitalhouse.android.a0317moacns1c_01.View.Fragments;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import digitalhouse.android.a0317moacns1c_01.R;
import digitalhouse.android.a0317moacns1c_01.Model.POJO.Seccion;
import digitalhouse.android.a0317moacns1c_01.View.Adapters.AdapterViewPager;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentViewPager extends Fragment {


    public FragmentViewPager (){
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_view_pager, container, false);

        List<Seccion> listaDeSecciones = new ArrayList<>();
        listaDeSecciones.add(new Seccion("DESTACADAS", "abc-news-au"));
        listaDeSecciones.add(new Seccion("TECNOLOGIA", "the-verge"));
        listaDeSecciones.add(new Seccion("DEPORTES", "the-sport-bible"));
        listaDeSecciones.add(new Seccion("NEGOCIOS", "bloomberg"));
        listaDeSecciones.add(new Seccion("ESPECTACULOS", "mashable"));


        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);

        AdapterViewPager miAdapter = new AdapterViewPager(getActivity().getSupportFragmentManager(), listaDeSecciones);
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        viewPager.setAdapter(miAdapter);

        tabLayout.setupWithViewPager(viewPager);

        return view;
    }

}
