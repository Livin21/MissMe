package com.lmntrx.android.library.livin.missme

import android.support.v4.view.ViewCompat
import android.view.View

internal fun View.setVisible(isVisible: Boolean, animate: Boolean = false, onEnd: (() -> Unit)? = null) {
    if (animate) {
        if (isVisible) {
            alpha = 0f
            setVisible(true)
        }
        ViewCompat.animate(this)
                .alpha(if (isVisible) 1f else 0f)
                .withEndAction {
                    if (!isVisible) {
                        setVisible(false)
                    }
                    onEnd?.invoke()
                }
    } else {
        visibility = if (isVisible) View.VISIBLE else View.GONE
    }
}
