package io.travis.chooseyourownadventure

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class StoryActivity : AppCompatActivity() {

    private val tag: String = StoryActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_story)

        intent = intent
        var name= intent.getStringExtra(getString(R.string.key_name))

        if (name == null || name.isEmpty() ) {
            name = "Samurai Jack!"
        }

        Log.d(tag, name)



    }
}