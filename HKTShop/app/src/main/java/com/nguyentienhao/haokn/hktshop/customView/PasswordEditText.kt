package com.nguyentienhao.haokn.hktshop.customView

import android.content.Context
import android.content.res.TypedArray
import android.graphics.drawable.Drawable
import android.support.v4.content.ContextCompat
import android.text.InputType
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.EditText
import com.nguyentienhao.haokn.hktshop.R

class PasswordEditText: EditText {
    var eye: Drawable? = null
    var eyeStrike: Drawable? = null
    var visible = false
    var useStrike = false
    var ALPHA = (255 * .80f)

    constructor(context: Context): super(context){
        create(null)
    }

    constructor(context: Context, attrs: AttributeSet?): super(context, attrs) {
        create(attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int): super(context, attrs, defStyleAttr){
        create(attrs)
    }

    private fun create(attrs: AttributeSet?) {
        if (attrs != null) {
            val array: TypedArray = context.theme.obtainStyledAttributes(attrs, R.styleable.PasswordEditText, 0, 0)
            this.useStrike = array.getBoolean(R.styleable.PasswordEditText_useStrike, false)
        }

        eye = ContextCompat.getDrawable(context, R.drawable.ic_visibility_black_24dp)?.mutate()
        eyeStrike = ContextCompat.getDrawable(context, R.drawable.ic_visibility_off_black_24dp)?.mutate()

        setting()
    }

    private fun setting() {
        inputType = InputType.TYPE_CLASS_TEXT or if (visible) InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD else InputType.TYPE_TEXT_VARIATION_PASSWORD
        val drawables: Array<Drawable> = compoundDrawables

        val drawable: Drawable? = if (!visible && useStrike) eyeStrike else eye
        drawable?.alpha = ALPHA.toInt()

        setCompoundDrawablesRelativeWithIntrinsicBounds(drawables[0], drawables[1], drawable, drawables[3])
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event?.action == MotionEvent.ACTION_UP && event.x >= (right - compoundDrawables[2].bounds.width())) {
            visible = !visible
            setting()
            invalidate()
        }
        return super.onTouchEvent(event)
    }
}