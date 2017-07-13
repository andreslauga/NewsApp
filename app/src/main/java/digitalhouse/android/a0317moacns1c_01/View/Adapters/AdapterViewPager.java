package digitalhouse.android.a0317moacns1c_01.View.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

import digitalhouse.android.a0317moacns1c_01.View.Fragments.FragmentRecyclerView;
import digitalhouse.android.a0317moacns1c_01.Model.POJO.Seccion;



public class AdapterViewPager extends FragmentStatePagerAdapter{

    private List<FragmentRecyclerView> listadeFragments = new ArrayList<>();
    private List<Seccion> listaDeSecciones;

    public AdapterViewPager(FragmentManager fm, List<Seccion> listaDeSecciones) {
        super(fm);
        this.listaDeSecciones = listaDeSecciones;
        for (Seccion seccion : listaDeSecciones) {
            listadeFragments.add(FragmentRecyclerView.fabricaDeFragmentsDeSecciones(seccion, seccion.getCanal()));
        }
    }

    @Override
    public Fragment getItem(int position) {
        return this.listadeFragments.get(position);
    }

    @Override
    public int getCount() {
        return this.listadeFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return listaDeSecciones.get(position).getNombre();
    }
}
