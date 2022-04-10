package io.travis.chooseyourownadventure.model

public class Page {
    private var imageId: Int
    private var text: Int
    private var choice1: Choice?
    private var choice2: Choice?
    private var isFinal: Boolean = false

    constructor(imageId: Int, text: Int, choice1: Choice, choice2: Choice) {
        this.imageId = imageId
        this.text = text
        this.choice1 = choice1
        this.choice2 = choice2
    }

    constructor(imageId: Int, text: Int) {
        this.imageId = imageId
        this.text = text
        choice1 = null
        choice2 = null
        isFinal = true
    }
}