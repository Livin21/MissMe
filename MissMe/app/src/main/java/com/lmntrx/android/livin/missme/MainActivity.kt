package com.lmntrx.android.livin.missme

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    lateinit var progressDialog: ProgressDialog

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
                    while (++i <= 5){
                        uiThread {

                            progressDialog.setMessage("Pretending to do some long task...${5-i}")

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

    }

    override fun onBackPressed() {
        progressDialog.onBackPressed { super.onBackPressed() }
    }

}
