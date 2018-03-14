[ProgressDialog](index.md) / [setProgressNumberFormat](./set-progress-number-format.md)

# setProgressNumberFormat

`fun setProgressNumberFormat(format: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Change the format of the small text showing current and maximum units
of progress.  The default is "%1d/%2d".
Should not be called during the number is progressing.

### Parameters

`format` - A string passed to [String.format()](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/format.html);
use "%1d" for the current number and "%2d" for the maximum.  If null,
nothing will be shown.