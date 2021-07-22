package com.example.cristianneyraev2;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;
import com.example.cristianneyraev2.Adapters.PagerAdapter;
import com.example.cristianneyraev2.Interface.IComunicaFragment;
import com.example.cristianneyraev2.Objects.TeaListMenu;
import com.google.android.material.tabs.TabLayout;


public class MainActivity extends AppCompatActivity implements IComunicaFragment {


    TabLayout tabLayout;
    ViewPager2 pager2;
    PagerAdapter adapter;
    Intent newOrder;
    public String teaName;
    public Bundle bundle;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        /* Configuración y habilitación de Tabs para navegación de Fragments */
        tabLayout = findViewById(R.id.tablayout);
        pager2 = findViewById(R.id.pager2);

        FragmentManager frm = getSupportFragmentManager();
        adapter = new PagerAdapter(frm, getLifecycle());
        pager2.setAdapter(adapter);

        tabLayout.addTab(tabLayout.newTab().setText("TEAS"));
        tabLayout.addTab(tabLayout.newTab().setText("CONTACTS"));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        pager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });

        /* Fin de configuración de navegación de los TABS*/
    }

    /* Desplegar Menu */

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    /* Fin despliege de Menu */

    public void NewOrder (View view) {
        Intent newOrder = new Intent(this,Order2.class);
        GlobalClass claseGlobal = (GlobalClass) getApplicationContext();
        String nombre=claseGlobal.getNombre();
        //Valida que se seleccione un te de la lista antes de iniciar la activity order
        if (nombre!=null){
            if (nombre.isEmpty()) {
                Toast.makeText(getApplicationContext(), "You need select a Tea ", Toast.LENGTH_SHORT).show();
            }
            else {
        startActivity(newOrder);}}
        else {
            Toast.makeText(getApplicationContext(), "You need select a Tea ", Toast.LENGTH_SHORT).show();}
    }



    @Override
    public void capturaCardView(String name) {
        String nombre = name;
        GlobalClass claseGlobal = (GlobalClass) getApplicationContext();
        claseGlobal.setNombre(nombre);
        Toast.makeText(getApplicationContext(), "You made a selection " + nombre, Toast.LENGTH_SHORT).show();



    }
}