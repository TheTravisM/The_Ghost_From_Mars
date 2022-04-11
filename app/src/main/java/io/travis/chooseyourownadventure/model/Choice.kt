package io.travis.chooseyourownadventure.model

public class Choice {
    private var textId: Int
    private var nextPage: Int

    constructor(textId: Int, nextPage: Int) {
        this.textId = textId
        this.nextPage = nextPage
    }

    fun getTextId(): Int {
        return textId
    }

    fun setText(textId: Int) {
        this.textId = textId
    }

    fun getNextPage(): Int {
        return nextPage
    }
}