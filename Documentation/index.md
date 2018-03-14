[ProgressDialog](./index.md)

# ProgressDialog

`class ProgressDialog`

A dialog showing a progress indicator and an optional text message or view.
Only a text message or a view can be used at the same time.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `ProgressDialog(activity: Activity)`<br>A dialog showing a progress indicator and an optional text message or view. Only a text message or a view can be used at the same time. |

### Functions

| Name | Summary |
|---|---|
| [dismiss](dismiss.md) | `fun dismiss(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Hides progress dialog |
| [getMax](get-max.md) | `fun getMax(): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Gets the maximum allowed progress value. The default value is 100. |
| [getMessageTextView](get-message-text-view.md) | `fun getMessageTextView(): TextView?`<br>Return message display TextView, so that the user can customize it as per his wish |
| [getProgress](get-progress.md) | `fun getProgress(): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Gets the current progress. |
| [getSecondaryProgress](get-secondary-progress.md) | `fun getSecondaryProgress(): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Gets the current secondary progress. |
| [incrementProgressBy](increment-progress-by.md) | `fun incrementProgressBy(diff: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Increments the current progress value. |
| [incrementSecondaryProgressBy](increment-secondary-progress-by.md) | `fun incrementSecondaryProgressBy(diff: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Increments the current secondary progress value. |
| [isCancelable](is-cancelable.md) | `fun isCancelable(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [isIndeterminate](is-indeterminate.md) | `fun isIndeterminate(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Whether this ProgressDialog is in indeterminate mode. |
| [onBackPressed](on-back-pressed.md) | `fun onBackPressed(superOnBackPressed: () -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [setCancelable](set-cancelable.md) | `fun setCancelable(cancelable: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [setColor](set-color.md) | `fun setColor(color: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [setIndeterminate](set-indeterminate.md) | `fun setIndeterminate(indeterminate: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Change the indeterminate mode for this ProgressDialog. In indeterminate mode, the progress is ignored and the dialog shows an infinite animation instead. |
| [setIndeterminateDrawable](set-indeterminate-drawable.md) | `fun setIndeterminateDrawable(d: Drawable): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Sets the drawable to be used to display the indeterminate progress value. |
| [setMax](set-max.md) | `fun setMax(max: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Sets the maximum allowed progress value. |
| [setMessage](set-message.md) | `fun setMessage(message: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [setProgress](set-progress.md) | `fun setProgress(value: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Sets the current progress. |
| [setProgressDrawable](set-progress-drawable.md) | `fun setProgressDrawable(d: Drawable): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Sets the drawable to be used to display the progress value. |
| [setProgressNumberFormat](set-progress-number-format.md) | `fun setProgressNumberFormat(format: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Change the format of the small text showing current and maximum units of progress.  The default is "%1d/%2d". Should not be called during the number is progressing. |
| [setProgressPercentFormat](set-progress-percent-format.md) | `fun setProgressPercentFormat(format: `[`NumberFormat`](http://docs.oracle.com/javase/6/docs/api/java/text/NumberFormat.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Change the format of the small text showing the percentage of progress. The default is [NumberFormat.getPercentageInstnace().](http://docs.oracle.com/javase/6/docs/api/java/text/NumberFormat.html#getPercentInstance()) Should not be called during the number is progressing. |
| [setProgressStyle](set-progress-style.md) | `fun setProgressStyle(style: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Sets the style of this ProgressDialog, either [.STYLE_SPINNER](#) or [.STYLE_HORIZONTAL](#). The default is [.STYLE_SPINNER](#). |
| [setSecondaryProgress](set-secondary-progress.md) | `fun setSecondaryProgress(secondaryProgress: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Sets the secondary progress. |
| [setTextColor](set-text-color.md) | `fun setTextColor(color: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [setTextSize](set-text-size.md) | `fun setTextSize(sizeInSp: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [show](show.md) | `fun show(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Displays progress dialog |

### Companion Object Properties

| Name | Summary |
|---|---|
| [STYLE_HORIZONTAL](-s-t-y-l-e_-h-o-r-i-z-o-n-t-a-l.md) | `const val STYLE_HORIZONTAL: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Creates a ProgressDialog with a horizontal progress bar. |
| [STYLE_SPINNER](-s-t-y-l-e_-s-p-i-n-n-e-r.md) | `const val STYLE_SPINNER: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Creates a ProgressDialog with a circular, spinning progress bar. This is the default. |
