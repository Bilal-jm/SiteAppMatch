package com.example.siteappmatch


import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MatchEnCoursActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_match_en_cours)

        // Ajout de données brutes pour les matchs en cours
        val tvMatchEnCours = findViewById<TextView>(R.id.tvMatchEnCours)
        tvMatchEnCours.text = """
            Match 1: Équipe A vs Équipe B
            Match 2: Équipe C vs Équipe D
            Match 3: Équipe E vs Équipe F
        """.trimIndent()
    }
}
