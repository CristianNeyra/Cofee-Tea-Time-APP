package com.example.cristianneyraev2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class Order2 extends AppCompatActivity {

    private int mQuantity = 0;
    private int mTotalPrice = 0;

    private static final int SMALL_PRICE = 5;
    private static final int MEDIUM_PRICE = 6;
    private static final int LARGE_PRICE = 7;

    private static final String TEA_SIZE_SMALL = "Small ($5/cup)";
    private static final String TEA_SIZE_MEDIUM = "Medium ($6/cup)";
    private static final String TEA_SIZE_LARGE = "Large ($7/cup)";

    private String mMilkType = "";
    private String mSugarType = "";
    private String mTeaName = "";

    private String mSize;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order2);

        // Setea el costo por defecto a $0.00
        TextView costTextView = findViewById(
                R.id.cost_text_view);
        costTextView.setText(getString(R.string.initial_cost));

        setupSizeSpinner();
        setupMilkSpinner();
        setupSugarSpinner();


       //Asigna el Nombre del té como titulo en el toolbar
        GlobalClass claseGlobal = (GlobalClass) getApplicationContext();
        TextView nombreTe= findViewById(R.id.tea_name_text_view);
        nombreTe.setText(claseGlobal.getNombre());
        claseGlobal.setNombre("");

    }

    /*
     * Setea el dropdown del spiner para seleccionar el tamaño del te mSize
     */

    private void setupSizeSpinner() {

        Spinner mSizeSpinner = findViewById(R.id.tea_size_spinner);

        // Crea un array adapter para usae el strinf con el listado y setea el default
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.tea_size_array, android.R.layout.simple_spinner_item);

        // Especifica el layout para usar
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        mSizeSpinner.setAdapter(adapter);

        // Asigna el mSelected a la constante
        mSizeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        mSize = getString(R.string.tea_size_small);
                        break;
                    case 1:
                        mSize = getString(R.string.tea_size_medium);
                        break;
                    case 2:
                        mSize = getString(R.string.tea_size_large);
                        break;

                }
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                mSize = getString(R.string.tea_size_small);
            }
        });

    }


    /*
     * Setea el dropdown del spiner para seleccionar el tamaño del te Milk
     */

    private void setupMilkSpinner() {

        Spinner mSizeSpinner = findViewById(R.id.milk_spinner);

        // Crea un array adapter para usae el strinf con el listado y setea el default
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.milk_array, android.R.layout.simple_spinner_item);
        // Especifica el layout para usar
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        mSizeSpinner.setAdapter(adapter);

        // Asigna el mSelected a la constante
        mSizeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        mMilkType = getString(R.string.milk_type_none);
                        break;
                    case 1:
                        mMilkType = getString(R.string.milk_type_nonfat);
                        break;
                    case 2:
                        mMilkType = getString(R.string.milk_type_1_percent);
                        break;
                    case 3:
                        mMilkType = getString(R.string.milk_type_2_percent);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                mMilkType = getString(R.string.milk_type_none);
            }
        });

    }


    /*
     * Setea el dropdown del spiner para seleccionar el tamaño del te Sugar
     */


    private void setupSugarSpinner() {

        Spinner mSizeSpinner = findViewById(R.id.sugar_spinner);

        // Crea un array adapter para usae el strinf con el listado y setea el default
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.sugar_array, android.R.layout.simple_spinner_item);

        // Especifica el layout para usar
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        mSizeSpinner.setAdapter(adapter);

        // Asigna el mSelected a la constante
        mSizeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        mSugarType = getString(R.string.sweet_type_0);
                        break;
                    case 1:
                        mSugarType = getString(R.string.sweet_type_20);
                        break;
                    case 2:
                        mSugarType = getString(R.string.sweet_type_50);
                        break;
                    case 3:
                        mSugarType = getString(R.string.sweet_type_90);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                mSugarType = getString(R.string.sweet_type_0);
            }
        });

    }

    // Desplegar Menu

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);

        return true;
    }

    // Setea la cantidad de tasas de té
    private void displayQuantity(int numberOfTeas) {
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
        quantityTextView.setText(String.valueOf(numberOfTeas));
    }

    //Muestra el valor total de la orden
    private void displayCost(int totalPrice) {
        TextView costTextView = findViewById(
                R.id.cost_text_view);

        String convertPrice = NumberFormat.getCurrencyInstance().format(totalPrice);
        costTextView.setText(convertPrice);
    }

    //Función para el calculo del precio de la orden
    private int calculatePrice() {

        // Calcula el total de la orden
        switch (mSize) {
            case TEA_SIZE_SMALL:
                mTotalPrice = mQuantity * SMALL_PRICE;
                break;
            case TEA_SIZE_MEDIUM:
                mTotalPrice = mQuantity * MEDIUM_PRICE;
                break;
            case TEA_SIZE_LARGE:
                mTotalPrice = mQuantity * LARGE_PRICE;
                break;
        }
        return mTotalPrice;
    }

    //Función que incrementa la cantidad de tasas
    public void increment(View view) {
        mQuantity = mQuantity + 1;
        displayQuantity(mQuantity);
        mTotalPrice = calculatePrice();
        displayCost(mTotalPrice);
    }

    //Función que disminuye la cantidad de tasas
    public void decrement(View view) {
        if (mQuantity > 0) {

            mQuantity = mQuantity - 1;
            displayQuantity(mQuantity);
            mTotalPrice = calculatePrice();
            displayCost(mTotalPrice);
        }
    }

    //función que habilita las acciones a seguir una vez clickeado el botón "Brew Tea"
    public void brewTea(View view) {

        switch (mQuantity){
            case 0:
                Toast.makeText(getApplicationContext(), "You need select at last one cup of tea", Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(getApplicationContext(), "You order was submited", Toast.LENGTH_SHORT).show();
        }


    }
}