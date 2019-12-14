package com.fatihdengiz.ukotlinactivitylifecycle

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

// Android life cycle , How to run Android system ? : answer :last in first out
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("Debug","onCreate Methodu çalıştı .")
        // Uygulama ikonuna/simgesine bastığımız zaman çalışan kısımdır.Uygulamada ilk bu method çalıştırılır.
        //uygulama ortamını ilk açılırken oluşturulan kısım.

        if(savedInstanceState != null){
            val egerSilindiyse: String? = savedInstanceState?.getString("geciciKaydetKey")
            textView.text = egerSilindiyse
        }

        bKaydet.setOnClickListener(View.OnClickListener {
            val tAdi:String?=editText.text.toString()
            textView.text = tAdi.toString()
        })


    }
    override fun onStart() {
        super.onStart()

        // Uygulamayı tekrar kaldığı yerden çalıştırmaya devam eder.
        Log.i("Uyarı","onStart methodu çalıştı.")
    }
    override fun onResume() {
        super.onResume()
        // uygulama ekranda açık içen yani uygulama çalışıyor iken bu kısım çalıştırılır. Kullanıcı uygulamada bir

        Log.i("Uyarı","onResume methodu çalıştı.")
    }
    override fun onPause(){
        super.onPause()
        // uygulama uzun aşağı indirilmiş , başka uyguama açılmış ve ekran kilidi uygulama açıkken kapatılmış ise
        // bu method çalıştırılır.
        Log.i("Uyarı","onPause Methodu çalştı.")
    }
    override  fun onStop(){
        super.onStop()
        // uygulama uzun aşağı indirilmiş , başka uyguama açılmış ve ekran kilidi uygulama açıkken kapatılmış ise
        // bu method çalıştırılır.
        Log.i("Uyarı","onStop methodu çalıştı.")
    }
    override fun onRestart() {
        super.onRestart()
        // Uygulaya geri dönersek onRestart uygulaması çalışır ve bizi direk onStart() methoduna yönlendirir.
        Log.i("Uyarı","onRestart methodu çalıştı.")
    }
    override fun onDestroy() {
        super.onDestroy()
        // onDestroy methodu çalışınca uygulama komple kapanır ve bütün veriler silinir
        Log.i("Uyarı","onDestroy methodu çalıştı.")
    }


    // Turkish : Telefon ya da emulator ekranını yatay konuma getirince en baştan onCreate() metodu çalıştırılır ve
    // bazı veriler silinir . silinmesini engellemek için aşağıda metodu kullanıcaz ve bu metodu onCreate() içersinde
    // kullanıcağız.

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putString("geciciKaydetKey",editText.text.toString())

    }





}
