package edu.temple.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContracts

class DisplayActivity : AppCompatActivity() {

    // TODO Step 1: Launch TextSizeActivity when button clicked to allow selection of text size value
    private val textSizeLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            val textSize = result.data?.getIntExtra(TEXT_SIZE_KEY, 14) ?: 14
            lyricsDisplayTextView.textSize = textSize.toFloat()
        }
    }
    // TODO Step 3: Use returned value for lyricsDisplayTextView text size
    private lateinit var lyricsDisplayTextView: TextView
    private lateinit var textSizeSelectorButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        lyricsDisplayTextView = findViewById(R.id.lyricsDisplayTextView)
        textSizeSelectorButton = findViewById(R.id.textSizeSelectorButton)

        textSizeSelectorButton.setOnClickListener {
            textSizeLauncher.launch(Intent(this@DisplayActivity, TextSizeActivity::class.java))
        }

    }
}