package com.example.myapplication.view

import android.content.Context
import android.graphics.Paint
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class KtView : AppCompatTextView {

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attr: AttributeSet?) : this(context, attr, 0)

    constructor(context: Context, attr: AttributeSet?, def: Int) : super(context, attr, def) {

    }
}