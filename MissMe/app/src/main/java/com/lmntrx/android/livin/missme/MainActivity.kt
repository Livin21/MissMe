package com.lmntrx.android.livin.missme

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    lateinit var progressDialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressDialog = ProgressDialog(this)
        progressDialog.setMessage("Pretending to do some long task...")
        progressDialog.setCancelable(false)

        showProgressDialogButton.setOnClickListener {
            progressDialog.show()
            doAsync {
                Thread(Runnable {
                    var i = 0
                    while (++i <= 5){
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
        }

    }

    

}
