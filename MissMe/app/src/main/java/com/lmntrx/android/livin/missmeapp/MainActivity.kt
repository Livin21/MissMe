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

package com.lmntrx.android.livin.missmeapp

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.lmntrx.android.library.livin.missme.ProgressDialog
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

/**
 * Sample app's MainActivity
 */
class MainActivity : AppCompatActivity() {

    /* ProgressDialog object declared globally */
    private lateinit var progressDialog: ProgressDialog

    /* List of colors */
    private val colors = arrayListOf(
            Color.RED,
            Color.BLUE,
            Color.GREEN,
            Color.YELLOW,
            Color.GRAY,
            Color.CYAN,
            Color.MAGENTA,
            Color.DKGRAY,
            Color.BLACK
    )

    /* color selector variable */
    private var currentColor = 0

    /* progress style selector */
    private var progressStyle = ProgressDialog.STYLE_SPINNER

    /* indeterminate mode selector */
    private var indeterminate = true

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize progressDialog
        progressDialog = ProgressDialog(this)

        // Set maximum progress
        progressDialog.setMax(5)

        // Set Current Progress
        progressDialog.setProgress(0)

        // Set message
        progressDialog.setMessage("Pretending to do some long task...")

        // Set cancelable
        progressDialog.setCancelable(true)

        /* showProgressDialog Click Listener */
        showProgressDialogButton.setOnClickListener {

            // Show dialog
            progressDialog.show()

            /* Faking a long task */
            doAsync {
                Thread(Runnable {
                    var i = 0
                    while (++i <= 5) {
                        uiThread {

                            // Update Progress
                            progressDialog.setProgress(progressDialog.getProgress() + 1)

                            // Set message
                            progressDialog.setMessage("Pretending to do some long task...${5 - i}")

                        }
                        Thread.sleep(1000)
                    }
                }).run()
                uiThread {
                    // Dismiss dialog
                    progressDialog.dismiss()

                }
            }
        }

        /* toggleCancelableButton Click Listener */
        toggleCancelableButton.setOnClickListener {

            // Set cancelable
            progressDialog.setCancelable(!progressDialog.isCancelable())

            toggleCancelableButton.text = "Cancelable: ${progressDialog.isCancelable()}"
        }

        /* changeProgressColorButton Click Listener */
        changeProgressColorButton.setOnClickListener {
            if (currentColor == colors.size)
                currentColor = 0
            // Cycle through colors list
            progressDialog.setColor(colors[currentColor++])
        }

        /* toggleProgressStyleButton Click Listener */
        toggleProgressStyleButton.setOnClickListener {

            if (progressStyle == ProgressDialog.STYLE_SPINNER){

                // Set Progress Style
                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL)

                toggleProgressStyleButton.text = "Toggle ProgressStyle: STYLE_HORIZONTAL"

                progressStyle = ProgressDialog.STYLE_HORIZONTAL

            }else{

                // Set Progress Style
                progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER)

                toggleProgressStyleButton.text = "Toggle ProgressStyle: STYLE_SPINNER"

                progressStyle = ProgressDialog.STYLE_SPINNER

            }
        }


        /* toggleIndeterminateButton Click Listener */
        toggleIndeterminateButton.setOnClickListener {

            // Toggle indeterminate
            indeterminate = !indeterminate

            // Set indeterminate mode
            progressDialog.setIndeterminate(indeterminate)

            // Set value in TextView
            toggleIndeterminateButton.text = "Toggle Indeterminate: $indeterminate"

        }

    }

    /* Override onBackPressed */
    override fun onBackPressed() {
        progressDialog.onBackPressed { super.onBackPressed() }
    }



}
