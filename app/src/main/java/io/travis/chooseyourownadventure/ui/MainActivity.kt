package io.travis.chooseyourownadventure.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import io.travis.chooseyourownadventure.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameField = findViewById<EditText>(R.id.editTextPersonName)
        val startButton = findViewById<Button>(R.id.button_start)

        val listenerStartButton = View.OnClickListener {
            val name = nameField.text.toString()
            Toast.makeText(this, name, Toast.LENGTH_LONG).show()
            startStory(name);
        }

        startButton.setOnClickListener(listenerStartButton)

    }

    private fun startStory(name :String) {
        val intent = Intent(this@MainActivity, StoryActivity::class.java)
        val key = resources.getString(R.string.key_name)
        intent.putExtra(key, name)
        startActivity(intent)
    }

}
