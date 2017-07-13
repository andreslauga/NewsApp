package digitalhouse.android.a0317moacns1c_01.View.Activities;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import digitalhouse.android.a0317moacns1c_01.R;
import digitalhouse.android.a0317moacns1c_01.View.Fragments.FragmentDetalle;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent unIntent = getIntent();
        Bundle bundle = unIntent.getExtras();

        FragmentDetalle fragmentDetalle = new FragmentDetalle();

        fragmentDetalle.setArguments(bundle);

        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.holderDetalleFragment, fragmentDetalle);

        fragmentTransaction.commit();
    }
}
