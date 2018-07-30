package me.doapps.piechart;

import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.Legend;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {
    private PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pieChart = (PieChart) findViewById(R.id.pieChart);

        /*definimos algunos atributos*/
        pieChart.setCenterText("Concentración\nde Gas");

        pieChart.setCenterTextSize(13);
        pieChart.setHoleRadius(40f);
        pieChart.setDrawYValues(false);
        pieChart.setDrawXValues(true);
        pieChart.setRotationEnabled(true);
        pieChart.animateXY(1500, 1500);

		/*creamos una lista para los valores Y*/
        ArrayList<Entry> valsY = new ArrayList<Entry>();

        valsY.add(new Entry(2000,0));
        valsY.add(new Entry(4096,1));

 		/*creamos una lista para los valores X*/
        ArrayList<String> valsX = new ArrayList<String>();

        valsX.add("Fuga Leve");
        valsX.add("");

 		/*creamos una lista de colores*/
        ArrayList<Integer> colors = new ArrayList<Integer>();

        colors.add(getResources().getColor(R.color.red_flat));
        colors.add(getResources().getColor(R.color.colorWhite));


 		/*seteamos los valores de Y y los colores*/
        PieDataSet set1 = new PieDataSet(valsY, "Resultados");
        set1.setSliceSpace(3f);
        set1.setColors(colors);

		/*seteamos los valores de X*/
        PieData data = new PieData(valsX, set1);
        pieChart.setData(data);
        pieChart.highlightValues(null);
        pieChart.invalidate();

        /*Ocutar descripcion*/
        pieChart.setDescription("");
        /*Ocultar leyenda*/
        pieChart.setDrawLegend(false);

    }
}

