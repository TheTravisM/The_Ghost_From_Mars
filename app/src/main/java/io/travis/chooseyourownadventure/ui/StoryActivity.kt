package io.travis.chooseyourownadventure.ui

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import io.travis.chooseyourownadventure.R
import io.travis.chooseyourownadventure.model.Page
import io.travis.chooseyourownadventure.model.Story
import java.util.*


class StoryActivity : AppCompatActivity() {

    private val tag: String = StoryActivity::class.java.simpleName
    private val story = Story()
    private var page = Page(0,0)
    private lateinit var imageView: ImageView
    private lateinit var textView: TextView
    private lateinit var choice1Button: Button
    private lateinit var choice2Button: Button
    private lateinit var name: String
    private lateinit var pageText: String
    private var pageStack = ArrayDeque<Int>();


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_story)

        intent = intent
        name = intent.getStringExtra(getString(R.string.key_name)).toString()

        if (name.isEmpty()) {
            name = "Samurai Jack!"
        }

        Log.d(tag, name)

        imageView = findViewById<ImageView>(R.id.imageView_story)
        textView = findViewById<TextView>(R.id.textView_story)
        choice1Button = findViewById<Button>(R.id.button_choice1_story)
        choice2Button = findViewById<Button>(R.id.button_choice2_story)

        loadPage(0)

    }

    private fun loadPage(pageNumber: Int) {
        pageStack.push(pageNumber)

        page = story.getPage(pageNumber)!!

        val image : Drawable? = ContextCompat.getDrawable(this, page.getImageId())

        imageView.setImageDrawable(image)

        pageText = getString(page.getTextId())
        // Add Name if place holder is included. Will not add if no placeholder
        pageText = String.format(pageText, name)
        textView.text = pageText

        if (page.isFinalPage()) {
            choice1Button.visibility = View.INVISIBLE
            choice2Button.text = getString(R.string.play_again)
            choice2Button.setOnClickListener() {
                loadPage(0)
            }
        } else {
            // Make sure btns are visible
            choice1Button.visibility = View.VISIBLE
            choice2Button.visibility = View.VISIBLE

            choice1Button.text = getString(page.getChoice1().getTextId())
            choice2Button.text = getString(page.getChoice2().getTextId())

            choice1Button.setOnClickListener(){
                val nextPage = page.getChoice1().getNextPage();
                loadPage(nextPage);
            }
            // Set Click Listener
            choice2Button.setOnClickListener(){
                val nextPage = page.getChoice2().getNextPage();
                loadPage(nextPage);
            }
        }
    }

    override fun onBackPressed() {
        pageStack.pop()
        if (pageStack.isEmpty()) {
            super.onBackPressed()
        } else {
            loadPage(pageStack.pop())
        }


    }
}
