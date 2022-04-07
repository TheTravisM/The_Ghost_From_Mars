package io.travis.chooseyourownadventure.model

public class Page {
    //private var imageId: Int = 0
    //private var textId: Int = 0
    //private var choice1: choice = null
    //private var choice2: choice = null

    private var imageId: Int = 0
        get() = field
        set(value) { field = value }

    private var textId: Int = 0
        get() = field
        set(value) { field = value }

    private var choice1: Choice? = null
        get() = field
        set(value) { field = value }

    private var choice2: Choice? = null
        get() = field
        set(value) { field = value }

}
//private var imageId: Int = 0
//private var textId: Int = 0
//private var choice1: choice = null
//private var choice2: choice = null

//    fun getTextId(): Int {
//        return textId
//    }
//
//    public void setTextId(int imageId) {
//        this.TextId = TextId;
//    }

//    public Choice getChoice1() {
//        return choice1;
//    }
//
//    public Choice getChoice2() {
//        return choice2;
//    }
