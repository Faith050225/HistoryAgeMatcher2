package com.example.historyagematcher

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ageEditText = findViewById<EditText>(R.id.ageEditText)
        val titleTextView = findViewById<TextView>(R.id.titleTextView)
        val matchButton = findViewById<Button>(R.id.matchButton)
        val clearButton = findViewById<Button>(R.id.clearButton)

        matchButton.setOnClickListener{
            val inputAge = ageEditText.text.toString().toIntOrNull()

            if (inputAge in 20..100) {
                val matches = getMatches(inputAge!!)
                if (matches.isNotEmpty()) {
                    val formattedMatches = matches.joinToString(", ")
                titleTextView.text = "Matches: $formattedMatches"
            } else {
                titleTextView.text = "No matches found."
            }
            } else {
               titleTextView.text = "Please enter a valid age between 20 and 100."
            }
        }

        clearButton.setOnClickListener {
            ageEditText.text.clear()
           titleTextView.text = ""
        }
    }

    private fun getMatches(age: Int): List<String> {
        val historicalFigures = mapOf(
            "Albert Einstein" to 76,
            "Leonardo da Vinci" to 67,
            "Marie Curie" to 66,
            "William Shakespeare" to 52,
            "Galileo Galilei" to 77,
            "Rosa Parks" to 92,
            "Wolfgang Amadeus Mozart" to 35,
            "Cleopatra" to 39,
            "Abraham Lincoln" to 56,
            "Joan of Arc" to 19
        )

        val matches = mutableListOf<String>()
        for ((figure, figureAge) in historicalFigures) {
            if (figureAge == age) {
                matches.add(figure)
            }
        }
        return matches
    }
}