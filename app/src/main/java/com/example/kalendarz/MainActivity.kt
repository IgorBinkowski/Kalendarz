package com.example.kalendarz

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var kalendarz = findViewById<CalendarView>(R.id.calendarView)
        var wyjazd = findViewById<Button>(R.id.button)
        var przyjazd = findViewById<Button>(R.id.button2)
        var wyjazd_text = findViewById<TextView>(R.id.textView)
        var przyjazd_text = findViewById<TextView>(R.id.textView2)
        var oblicz = findViewById<Button>(R.id.button3)
        var wynik = findViewById<TextView>(R.id.textView3)
        var data_wyjazdu = mutableListOf<Int>(0,0,0)
        var data_przyjazdu = mutableListOf<Int>(0,0,0)
        var data = arrayListOf<Int>(0,0,0)
        kalendarz.minDate =System.currentTimeMillis()
        kalendarz.maxDate = System.currentTimeMillis() + (kalendarz.maxDate - System.currentTimeMillis())
        kalendarz.setOnDateChangeListener(){
            CalendarView , i , i2 , i3 ->
            data[0]=i
            data[1]=i2
            data[2]=i3
        }
        wyjazd.setOnClickListener {
            data_wyjazdu[0] = data[0]
            data_wyjazdu[1] = data[1]
            data_wyjazdu[2] = data[2]
            wyjazd_text.text =
                "Data wyjazdu: " + data[0].toString() + "-" + data[1].toString() + "-" + data[2].toString()
        }
        przyjazd.setOnClickListener {
            data_przyjazdu[0] = data[0]
            data_przyjazdu[1] = data[1]
            data_przyjazdu[2] = data[2]
            przyjazd_text.text =
                "Data przyjazdu: " + data[0].toString() + "-" + data[1].toString() + "-" + data[2].toString()
        }
        oblicz.setOnClickListener{Int
        var x1= (data_przyjazdu[0]*360)+ (data_przyjazdu[1]*30)+data_przyjazdu[2]
        var x2=(data_wyjazdu[0]*360)+ (data_wyjazdu[1]*30)+data_wyjazdu[2]
        var x3=x1.toChar()-x2.toChar()
            wynik.text = "Ilość dni: "+x3.toString()
        }

}



}
