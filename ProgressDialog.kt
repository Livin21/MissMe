import android.app.Activity
import android.content.res.ColorStateList
import android.os.Build
import android.support.annotation.RequiresApi
import android.support.v7.widget.CardView
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.view.WindowManager
import android.widget.*


/***
 * Created by Livin Mathew <mail@livinmathew.me> on 10/3/18.
 */


class ProgressDialog(private val activity: Activity) {

    private val layout = RelativeLayout(activity)
    private val textView = TextView(activity)
    private val progressBar = ProgressBar(activity, null, android.R.attr.progressBarStyleLarge)
    private val cardView = CardView(activity)
    private val innerLayout = LinearLayout(activity)

    private var cancelable: Boolean = true

    init {

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
        innerLayout.addView(textView, textViewParams)

        val layoutParams = RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT)
        layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT)
        activity.addContentView(layout, layoutParams)
        layout.addView(cardView, cardViewParams)

        layout.setOnClickListener {
            if (cancelable)
                dismiss()
        }

        layout.visibility = View.GONE

    }

    // Convert dp to px
    private fun dip(dp: Float): Int {
        val r = activity.resources
        return TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                dp,
                r.displayMetrics
        ).toInt()
    }

    
    fun setMessage(message: String){
        textView.text = message
    }

    fun show() {
        layout.visibility = View.VISIBLE
    }

    fun dismiss() {
        layout.visibility = View.GONE
    }

    fun setCancelable(cancelable: Boolean) {
        this.cancelable = cancelable
        if (cancelable)
            activity.window.setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                    WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
        else
            activity.window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)

    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun setColor(color: Int) {
        progressBar.progressTintList = ColorStateList.valueOf(color)
    }

    fun onBackPressed(superOnBackPressed: () -> Unit) {
        if (layout.visibility == View.VISIBLE){
            if (cancelable)
                dismiss()
        }else
            superOnBackPressed.invoke()
    }

}