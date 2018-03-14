[ProgressDialog](index.md) / [setProgressStyle](./set-progress-style.md)

# setProgressStyle

`fun setProgressStyle(style: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Sets the style of this ProgressDialog, either [.STYLE_SPINNER](#) or
[.STYLE_HORIZONTAL](#). The default is [.STYLE_SPINNER](#).

**Note:** A ProgressDialog with style [.STYLE_SPINNER](#)
is always indeterminate and will ignore the [ indeterminate](#) setting.

### Parameters

`style` - the style of this ProgressDialog, either [.STYLE_SPINNER](#) or
[.STYLE_HORIZONTAL](#)