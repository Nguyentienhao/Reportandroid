package com.nguyentienhao.haokn.hktshop.customView

import android.content.Context
import android.graphics.drawable.Drawable
import android.support.v4.content.ContextCompat
import android.text.InputType
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.EditText
import java.util.jar.Attributes
import com.nguyentienhao.haokn.hktshop.R

class ClearEditText: EditText {
    var crossX: Drawable? = null
    var noneCrossX: Drawable? = null
    var visibleE = false

    constructor(context: Context): super(context) {
        create()
    }

    constructor(context: Context, attrs: AttributeSet): super(context, attrs){
        create()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int): super(context, attrs, defStyleAttr) {
        create()
    }

    private fun create() {
        crossX = ContextCompat.getDrawable(context, R.drawable.ic_mtrl_chip_checked_circle)?.mutate()
        noneCrossX = ContextCompat.getDrawable(context, R.drawable.ic_mtrl_chip_checked_circle)?.mutate()

        setting()
    }

    private fun setting() {
        inputType = InputType.TYPE_CLASS_TEXT
        val drawables: Array<Drawable> = compoundDrawables
        val drawable: Drawable? = if (visibleE) crossX else noneCrossX

        setCompoundDrawablesRelativeWithIntrinsicBounds(drawables[0], drawables[1], drawables[2], drawables[3])
    }

    override fun onTextChanged(text: CharSequence?, start: Int, lengthBefore: Int, lengthAfter: Int) {

        if (lengthAfter == 0 && start == 0) {
            visibleE = false
            setting()
        } else {
            visibleE = true
            setting()
        }
        super.onTextChanged(text, start, lengthBefore, lengthAfter)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (MotionEvent.ACTION_DOWN == event?.action && event.x >= (right - compoundDrawables[2].bounds.width())) {
            setText(" ")
        }
        return super.onTouchEvent(event)
    }
}