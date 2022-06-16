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
        val series2021 = LineGraphSeries<DataPoint>()
        val series2022 = LineGraphSeries<DataPoint>()
        val arr2020 = arrayOf(0.0, 0.0, 0.0, 0.0, 1.29, 1.31, 0.32, 1.9, 2.34, 3.13, 8.09, 3.67)
        val arr2021 = arrayOf(5.11, 8.09, 5.92, 7.26, 6.97, 8.13, 12.25, 11.42, 12.21, 15.19, 15.32, 16.5)
        val arr2022 = arrayOf(19.02, 14.36, 16.21, 16.84, 26.46, 14.19, .06, 0.0, 0.0, 0.0, 0.0, 0.0)
        for (x in 0..11)
        {
           // val y = Math.sin(2*x*.2)-2*Math.sin(x*.2)
               val y = arr2020[x]
            series.appendData(DataPoint(x.toDouble(), y), true, 11)
        }
        for (x in 0..11)
        {
            val y = arr2021[x]
            series2021.appendData(DataPoint(x.toDouble(), y), true, 11)
        }
        for(x in 0..11)
        {
            val y = arr2022[x]
            series2022.appendData(DataPoint(x.toDouble(), y), true, 11)
        }
        chart.addSeries(series)
        chart.addSeries(series2021)
        chart.addSeries(series2022)
        series.setColor(Color.RED)
        series2021.setColor(Color.BLUE)
        series2022.setColor(Color.YELLOW)
        chart.setTitle("Dividend Record")

        val gridLabel = chart.gridLabelRenderer
        gridLabel.setHorizontalAxisTitle("Months")
        gridLabel.setVerticalAxisTitle("Amount")
    }
}