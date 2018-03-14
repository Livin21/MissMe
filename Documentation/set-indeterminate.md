[missme](../../index.md) / [com.lmntrx.android.library.livin.missme](../index.md) / [ProgressDialog](index.md) / [setIndeterminate](./set-indeterminate.md)

# setIndeterminate

`fun setIndeterminate(indeterminate: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Change the indeterminate mode for this ProgressDialog. In indeterminate
mode, the progress is ignored and the dialog shows an infinite
animation instead.

**Note:** A ProgressDialog with style [.STYLE_SPINNER](#)
is always indeterminate and will ignore this setting.

### Parameters

`indeterminate` - true to enable indeterminate mode, false otherwise