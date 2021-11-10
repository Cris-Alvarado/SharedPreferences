package com.example.sharedpreferences

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Switch
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val titleFromPrefs = resources.getString(R.string.title_text)
        val appName = resources.getString(R.string.app_name)
        val unBoolean = resources.getBoolean(R.bool.boolean_key)
        val highscore = resources.getInteger(R.integer.saved_high_score_key)

        Log.d("SAVEDVALUES", "initial high score $highscore")
        Log.d("SAVEDVALUES", "$appName $titleFromPrefs ${unBoolean} ")

        val texto = findViewById<TextView>(R.id.tvDefault)
        val switchUno: Switch = findViewById(R.id.switch_uno)
        val switchDos = findViewById<Switch>(R.id.switch_dos)
        val switchTres = findViewById<Switch>(R.id.switch_tres)
        val switchCuatro = findViewById<Switch>(R.id.switch_cuatro)

        texto.setText(titleFromPrefs)
        switchUno.isChecked = resources.getBoolean(R.bool.boolean_key1)
        switchDos.isChecked = resources.getBoolean(R.bool.boolean_key2)
        switchTres.isChecked = resources.getBoolean(R.bool.boolean_key3)
        switchCuatro.isChecked = resources.getBoolean(R.bool.boolean_key4)

        val sharedPref = getPreferences(Context.MODE_PRIVATE)

        if(sharedPref != null){
            val success = sharedPref.edit().putInt(getString(R.integer.saved_high_score_key),60).commit()
            if (success){
                val newHighScore = sharedPref.getInt(getString(R.integer.saved_high_score_key), 5)
                Log.d("SAVEDVALUES", "initial commited ${newHighScore}")
            }

            sharedPref.edit().putString(getString(R.string.title_text),"Sobreescrito").commit()
            Log.d("SAVEDVALUES", "new Title ${sharedPref.getString(getString(R.string.title_text),"")}")
            //val newTitleText = sharedPref.getString(getString(R.string.title_text),"")


            sharedPref.edit().putString("Algun_string_asi_nomas", "a ver si se guarda").commit()
            Log.d("SAVEDVALUE", "Experimento: ${sharedPref.getString("algun_string_asi_nomas","")}")
        }
    }
}