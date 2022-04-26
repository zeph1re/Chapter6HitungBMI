package binar.ganda.chapter6hitungbmi

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        hitung_btn.setOnClickListener(){
            hitungBMI()
        }
    }

    @SuppressLint("SetTextI18n")
    fun hitungBMI() {
        Thread(Runnable {
                val bb = et_bb.text.toString().toInt()
                val tb = et_tinggi.text.toString().toInt()
                var bmi = bb.toDouble()/ Math.pow((tb.toDouble())/100, 2.0)

                var result : String
                if (bmi < 18.5) {
                    result = "Kurus"
                } else if (bmi > 18.5 && bmi < 24.9) {
                    result = "Normal"
                } else if (bmi > 25.0 && bmi < 29.9){
                    result = "Over Weight"
                } else if (bmi >= 30) {
                    result = "Obesitas"
                } else {
                    result = null.toString()
                }

                result_tv.postDelayed(Runnable { result_tv.text = "Perhitungan BMI anda adalah  $result" }, 2000)
        }).start()

    }
}