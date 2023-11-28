package co.edu.sena.storageapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class BancaApp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_banca_app)
        val preferences = getSharedPreferences("agenda", Context.MODE_PRIVATE)
        val account = findViewById<EditText>(R.id.accountBanca)
        val searchButton = findViewById<Button>(R.id.searchButtonBanca)

        searchButton.setOnClickListener{
            val query = preferences.getInt(account.text.toString(),0)
            if(query!=null){
                if(query.isEmpty()){
                    Toast.makeText(this, "There's no account", Toast.LENGTH_LONG).show()
                }else{
                    account.setText(query.toString())
                }
            }
        }
    }
}