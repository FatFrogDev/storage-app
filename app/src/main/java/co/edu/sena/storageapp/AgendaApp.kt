package co.edu.sena.storageapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class AgendaApp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agenda_app)
        val name = findViewById<EditText>(R.id.editTextName)
        val contact = findViewById<EditText>(R.id.editTextContact)
        val searchButton = findViewById<Button>(R.id.searchButton)
        val saveButton = findViewById<Button>(R.id.saveButton)
        val preferences = getSharedPreferences("agenda", Context.MODE_PRIVATE)

        saveButton.setOnClickListener {
            val editor = preferences.edit()
            editor.putString(name.text.toString(), contact.text.toString())
            editor.commit()
            Toast.makeText(this, "Data saved correctly", Toast.LENGTH_LONG).show()
            name.setText("")
            contact.setText("")
        }

        searchButton.setOnClickListener{
            val query = preferences.getString(name.text.toString(),"")
            if(query!=null){
                if(query.isEmpty()){
                    Toast.makeText(this, "There's no contact", Toast.LENGTH_LONG).show()
                }else{
                    contact.setText(query.toString())
                }
            }
        }
    }
}