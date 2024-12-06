package com.alma.exame1_semi_marti_alberto.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alma.exame1_semi_marti_alberto.R
import com.alma.exame1_semi_marti_alberto.fragments.ListaEventosFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            val fragment = ListaEventosFragment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit()
        }
    }
}
