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
 **/
class MainActivity(private var progressDialog: ProgressDialog) : AppCompatActivity() {

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

    private var currentColor = 0

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressDialog = ProgressDialog(this)
        progressDialog.setMessage("Pretending to do some long task...")
        progressDialog.setCancelable(true)

        showProgressDialogButton.setOnClickListener {

            progressDialog.show()

            doAsync {
                Thread(Runnable {
                    var i = 0
                    while (++i <= 5) {
                        uiThread {

                            progressDialog.setMessage("Pretending to do some long task...${5 - i}")

                        }
                        Thread.sleep(1000)
                    }
                }).run()
                uiThread {

                    progressDialog.dismiss()

                }
            }
        }

        toggleCancelableButton.setOnClickListener {

            progressDialog.setCancelable(!progressDialog.isCancelable())

            toggleCancelableButton.text = "Cancelable: ${progressDialog.isCancelable()}"
        }


        changeProgressColorButton.setOnClickListener {
            if (currentColor == colors.size)
                currentColor = 0
            progressDialog.setColor(colors[currentColor++])
        }

    }

    override fun onBackPressed() {
        progressDialog.onBackPressed { super.onBackPressed() }
    }

}
