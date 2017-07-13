package digitalhouse.android.a0317moacns1c_01.View.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import digitalhouse.android.a0317moacns1c_01.Model.POJO.Noticia;
import digitalhouse.android.a0317moacns1c_01.R;
import digitalhouse.android.a0317moacns1c_01.View.Fragments.FragmentDetalle;
import digitalhouse.android.a0317moacns1c_01.View.Fragments.FragmentFavoritos;
import digitalhouse.android.a0317moacns1c_01.View.Fragments.FragmentRecyclerView;
import digitalhouse.android.a0317moacns1c_01.View.Fragments.FragmentViewPager;

public class MainActivity extends AppCompatActivity implements FragmentRecyclerView.Notificable, NavigationView.OnNavigationItemSelectedListener  {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* ActionBar ab = getSupportActionBar();
        ab.setDisplayUseLogoEnabled(true);
        ab.setDisplayShowHomeEnabled(true);
        ab.setDisplayShowTitleEnabled(false);
        ab.setLogo(R.drawable.logo_toolbar);*/

        //CARGO EL FRAGMENT LISTVIEW EN PANTALLA PRINCIPAL
        Fragment fragmentViewPager = new FragmentViewPager();
        colocarFragment(fragmentViewPager);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setLogo(R.drawable.logo_toolbar);
        final Intent unIntent = new Intent(getApplicationContext(), MainActivity.class);
        toolbar.findViewById(R.id.toolbar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(unIntent);
            }
        });



        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
       fab.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }        });
*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
               this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View viewNavHeader = navigationView.getHeaderView(0);
        ImageView imageView = (ImageView) viewNavHeader.findViewById(R.id.imageView);

    }


    @Override
    public void recibirNoticiaClickeado(Noticia noticia) {


        // ESTA FUNCION LO QUE HACE ES LANZAR EL ACTIVITY 2, ENVIANDO LA NOTICIA DENTRO DE UN BUNDLE

        Intent unIntent = new Intent(this, SecondActivity.class);

        Bundle unBundle = new Bundle();
        unBundle.putString(FragmentDetalle.TITULO_NOTICIA, noticia.getTitulo());
        unBundle.putString(FragmentDetalle.CONTENIDO_NOTICIA, noticia.getContenido());
        unBundle.putString(FragmentDetalle.IMAGEN_NOTICIA, noticia.getImagen());
        unBundle.putString(FragmentDetalle.AUTOR_NOTICIA, noticia.getAutor());
        unBundle.putString(FragmentDetalle.FECHA_NOTICIA, noticia.getFecha());

        unIntent.putExtras(unBundle);

        startActivity(unIntent);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent unIntent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(unIntent);
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        Fragment fragmentFavoritos = new FragmentFavoritos();

        int id = item.getItemId();

        if (id == R.id.secciones) {
            //ACA TE MANDA A LAS SECCIONES..........................
            Intent unIntent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(unIntent);
        } else if (id == R.id.intereses) {




            // QUIERO QUE ME LLEVE DESDE ACA A LA ACTIVITY DEL LOGIN//////////////////////

//            Intent unIntent = new Intent(this, LoginActivity.class);
//            startActivity(unIntent);

            colocarFragment(fragmentFavoritos);


       /* } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {*/

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void colocarFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.contentFrame, fragment);
        fragmentTransaction.commit();
    }
}
