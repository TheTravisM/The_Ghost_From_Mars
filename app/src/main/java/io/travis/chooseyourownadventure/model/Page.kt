package io.travis.chooseyourownadventure.model

public class Page {
    private var imageId: Int
    private var textId: Int
    private lateinit var choice1: Choice
    private lateinit var choice2: Choice
    private var isFinalPage: Boolean = false

    constructor(imageId: Int, textId: Int, choice1: Choice, choice2: Choice) {
        this.imageId = imageId
        this.textId = textId
        this.choice1 = choice1
        this.choice2 = choice2
    }

    constructor(imageId: Int, textId: Int) {
        this.imageId = imageId
        this.textId = textId
        isFinalPage = true
    }

    fun isFinalPage(): Boolean {
        return isFinalPage
    }

    fun getImageId(): Int {
        return imageId;
    }

    fun getTextId(): Int {
        return textId;
    }

    fun getChoice1(): Choice {
        return choice1
    }

    fun getChoice2(): Choice {
        return choice2
    }
}