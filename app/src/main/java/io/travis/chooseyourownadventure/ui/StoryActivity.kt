package io.travis.chooseyourownadventure.ui

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import io.travis.chooseyourownadventure.R
import io.travis.chooseyourownadventure.model.Page
import io.travis.chooseyourownadventure.model.Story


class StoryActivity : AppCompatActivity() {

    private val tag: String = StoryActivity::class.java.simpleName
    private val story = Story()
    private var page = Page(0,0)
    private var currentPage: Page? = null
    private var imageView: ImageView? = null
    private var textView: TextView? = null
    private var choice1Button: Button? = null
    private var choice2Button: Button? = null
    private var name: String? = null
    private var pageText: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_story)

        intent = intent
        name = intent.getStringExtra(getString(R.string.key_name))

        if (name == null || name!!.isEmpty() ) {
            name = "Samurai Jack!"
        }

        Log.d(tag, name!!)

        imageView = findViewById<ImageView>(R.id.imageView_story)
        textView = findViewById<TextView>(R.id.textView_story)
        choice1Button = findViewById<Button>(R.id.button_choice1_story)
        choice2Button = findViewById<Button>(R.id.button_choice2_story)

        loadPage(0)

    }

    private fun loadPage(pageNumber: Int) {

        page = story.getPage(pageNumber)!!

        val image : Drawable? = ContextCompat.getDrawable(this, page.getImageId())

        imageView?.setImageDrawable(image)

        pageText = getString(page.getTextId())
        // Add Name if place holder is included. Will not add if no placeholder
        pageText = String.format(pageText!!, name)
        textView?.text = pageText

        choice1Button?.text = page.getChoice1()?.let { getString(it.getTextId()) }
        choice2Button?.text = page.getChoice2()?.let { getString(it.getTextId()) }
    }
}