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

/**
 * @param activity instance of activity to which this ProgressDialog object belongs to
 * **/
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

        // Layout
        val layoutParams = RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT)
        layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT)
        activity.addContentView(layout, layoutParams)
        layout.addView(cardView, cardViewParams)

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

        layout.visibility = View.GONE

    }

    /**
     * @param dp size in dp
     * @return size in px
     * **/
    // Convert dp to px
    private fun dip(dp: Float): Int {
        val r = activity.resources
        return TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                dp,
                r.displayMetrics
        ).toInt()
    }


    /**
     * @param message A string object to display on the progress dialog
     **/
    /*
     * Set message on the progress bar. Functions same as the setMessage() in
     * deprecated ProgressDialog class
     */
    fun setMessage(message: String){
        textView.text = message
    }

    /* Display progress dialog */
    fun show() {
        layout.visibility = View.VISIBLE
    }

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
        // Disable click on all other views
        if (cancelable)
            activity.window.setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                    WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
        else
            activity.window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)

    }

    /**
     * @param color ResourceId of progress bar's color
     **/
    /* Sets progress bar's color */
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun setColor(color: Int) {
        progressBar.progressTintList = ColorStateList.valueOf(color)
    }

    /**
     * @param superOnBackPressed = {super.onBackPressed()} A block of code to be executed.
     **/
    /* Called when back button is pressed. Should be called in
     * the overridden onBackPressed() of the activity
     **/
    fun onBackPressed(superOnBackPressed: () -> Unit) {
        if (layout.visibility == View.VISIBLE){
            if (cancelable)
                dismiss()
        }else
            superOnBackPressed.invoke()
    }

}