[ProgressDialog](index.md) / [setProgressPercentFormat](./set-progress-percent-format.md)

# setProgressPercentFormat

`fun setProgressPercentFormat(format: `[`NumberFormat`](http://docs.oracle.com/javase/6/docs/api/java/text/NumberFormat.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Change the format of the small text showing the percentage of progress.
The default is
[NumberFormat.getPercentageInstance().](http://docs.oracle.com/javase/6/docs/api/java/text/NumberFormat.html#getPercentInstance())
Should not be called during the number is progressing.

### Parameters

`format` - An instance of a [NumberFormat](http://docs.oracle.com/javase/6/docs/api/java/text/NumberFormat.html) to generate the
percentage text.  If null, nothing will be shown.