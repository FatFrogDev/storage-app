 package co.edu.sena.storageapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

 class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val gobancaAppButton = findViewById<ImageButton>(R.id.goBancaAppImage);
        val goAgendaAppButton = findViewById<ImageButton>(R.id.goAgendaButton);
        val intentBancaApp = Intent(this, BancaApp::class.java);
        val intentAgendaApp = Intent(this, AgendaApp::class.java);
        goAgendaAppButton.setOnClickListener{
            startActivity(intentAgendaApp);
        }
        gobancaAppButton.setOnClickListener {
            startActivity(intentBancaApp);
        }
    }
}