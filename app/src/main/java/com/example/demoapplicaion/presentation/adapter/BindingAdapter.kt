package com.example.demoapplicaion.presentation.adapter

import android.view.View
import androidx.databinding.BindingAdapter

object BindingAdapter {
    @BindingAdapter("android:visibility")
    @JvmStatic
    fun View.setVisibility(visible: Boolean) {
        visibility = if (visible) {
            View.VISIBLE
        } else {
            View.GONE
        }
    }
}