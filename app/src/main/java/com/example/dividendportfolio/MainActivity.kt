package com.example.dividendportfolio

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jjoe64.graphview.GraphView
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries
import com.jjoe64.graphview.GridLabelRenderer
import com.jjoe64.graphview.LegendRenderer

class MainActivity : AppCompatActivity() {
    private lateinit var chart: GraphView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        chart = findViewById(R.id.chart)

        val series = LineGraphSeries<DataPoint>()

        val arr = DoubleArray(5) {1.0}

        for (x in 0..90)
        {
            val y = Math.sin(2*x*.2)-2*Math.sin(x*.2)
            series.appendData(DataPoint(x.toDouble(), y), true, 90)
        }
        chart.addSeries(series)
        series.setColor(Color.RED)
        series.setTitle("January 2020")
        chart.setTitle("Dividend Record")
    }

}

