package ru.profsoft.profnotes_v1.core

import android.view.View
 inline fun View.gone() {
    visibility = View.GONE
}
inline fun View.visible() {
    visibility = View.VISIBLE
}
inline fun View.invisible() {
    visibility = View.INVISIBLE
}
