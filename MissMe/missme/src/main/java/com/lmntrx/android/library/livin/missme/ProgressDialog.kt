/*
 * MIT License
 *
 * Copyright (c) 2018.  Livin
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */

package com.lmntrx.android.library.livin.missme

import android.app.Activity
import android.app.ProgressDialog.STYLE_SPINNER
import android.support.v4.content.ContextCompat
import android.support.v7.widget.CardView
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.TextView


/***
 * Created by Livin Mathew <mail@livinmathew.me> on 10/3/18.
 */

/**
 * @param activity instance of activity to which this ProgressDialog object belongs to
 **/
class ProgressDialog(private val activity: Activity) {

    companion object {
        /**
         * Creates a ProgressDialog with a circular, spinning progress
         * bar. This is the default.
         */
        const val STYLE_SPINNER = 0

        /**
         * Creates a ProgressDialog with a horizontal progress bar.
         */
        const val STYLE_HORIZONTAL = 1
    }

    private val layout = RelativeLayout(activity)
    private val textView = TextView(activity)
    private val progressBar = ProgressBar(activity, null, android.R.attr.progressBarStyleLarge)
    private val cardView = CardView(activity)
    private val innerLayout = LinearLayout(activity)

    private var progressStyle = STYLE_SPINNER

    private var cancelable: Boolean = true

    init {

        if (progressStyle == STYLE_SPINNER) {
            spinnerLayout()
        }

        /* If clicked anywhere on the screen except the progress dialog,
         * the progress dialog must dismiss depending upon the value of cancelable
         */
        layout.setOnClickListener {
            if (cancelable)
                dismiss()
        }

        /* Left empty purposefully. To detach cardview and
         * its contents from layout's click listener
         */
        cardView.setOnClickListener {}


        dismiss()

    }

    private fun spinnerLayout() {
        // CardView
        val cardViewParams = RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, 275)
        cardViewParams.addRule(RelativeLayout.CENTER_VERTICAL)
        cardView.cardElevation = 15f
        cardView.radius = 20f
        cardViewParams.setMargins(dip(16f), dip(0f), dip(16f), dip(0f))

        // Inner Layout
        val innerLayoutParams = RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT)
        innerLayout.setPadding(dip(8f), dip(8f), dip(8f), dip(8f))
        innerLayout.orientation = LinearLayout.HORIZONTAL
        cardView.addView(innerLayout, innerLayoutParams)

        // ProgressBar
        val progressBarParams = RelativeLayout.LayoutParams(125, RelativeLayout.LayoutParams.MATCH_PARENT)
        progressBarParams.addRule(RelativeLayout.CENTER_VERTICAL)
        progressBarParams.setMargins(dip(0f), dip(0f), dip(16f), dip(0f))
        innerLayout.addView(progressBar, progressBarParams)

        // TextView
        val textViewParams = RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.MATCH_PARENT)
        textViewParams.addRule(RelativeLayout.CENTER_VERTICAL)
        textView.setPadding(dip(16f), dip(0f), dip(0f), dip(0f))
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 22f)
        textView.gravity = Gravity.CENTER_VERTICAL
        textView.maxLines = 3
        innerLayout.addView(textView, textViewParams)

        // Layout
        val layoutParams = RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT)
        layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT)
        activity.addContentView(layout, layoutParams)
        layout.addView(cardView, cardViewParams)
    }

    /* Convert dp to px */
    private fun dip(dp: Float): Int {
        val r = activity.resources
        return TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                dp,
                r.displayMetrics
        ).toInt()
    }

    /**
     * @param style can be STYLE_SPINNER or STYLE_HORIZONTAL
     * Functions same as the setStyle() in deprecated ProgressDialog class
     **/
    /* Sets progressbar style */
    fun setProgressStyle(style: Int) {
        progressStyle = style
    }

    /**
     * @param message A string object to display on the progress dialog
     * Functions same as the setMessage() in deprecated ProgressDialog class
     **/
    /* Set message on the progress bar. */
    fun setMessage(message: String) {
        textView.text = message
    }

    /**
     * Displays progress dialog
     **/
    /* Display progress dialog */
    fun show() {
        layout.visibility = View.VISIBLE
    }

    /**
     * Hides progress dialog
     **/
    /* Hide progress dialog */
    fun dismiss() {
        layout.visibility = View.GONE
    }

    /**
     * @param cancelable A boolean which determines if the dialog can be dismissed by the user
     **/
    /* Toggles value of cancelable */
    fun setCancelable(cancelable: Boolean) {
        this.cancelable = cancelable
    }

    /**
     * @param color Constant from Color class, eg: Color.RED
     **/
    /* Sets progress bar's color */
    fun setColor(color: Int) {
        progressBar.indeterminateDrawable.setColorFilter(color, android.graphics.PorterDuff.Mode.SRC_IN)
    }

    /**
     * @param superOnBackPressed = {super.onBackPressed()} A block of code to be executed.
     * Called when back button is pressed. Should be called in the overridden onBackPressed()
     * of the activity
     **/
    fun onBackPressed(superOnBackPressed: () -> Unit) {
        if (layout.visibility == View.VISIBLE) {
            if (cancelable)
                dismiss()
        } else
            superOnBackPressed.invoke()
    }

    /**
     * @return value of cancelable
     **/
    fun isCancelable(): Boolean = cancelable

    /**
     * @param color ResourceId of text color
     **/
    /* Sets text color */
    fun setTextColor(color: Int) {
        textView.setTextColor(ContextCompat.getColor(activity, color))
    }

    /**
     * @param sizeInSp text size in sp
     **/
    /* Sets text size */
    fun setTextSize(sizeInSp: Float) {
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, sizeInSp)
    }

}