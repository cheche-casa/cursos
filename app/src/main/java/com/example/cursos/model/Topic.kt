package com.example.cursos.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

class Topic (
    @StringRes val stringResourceId: Int,
    val Total: Int,
    @DrawableRes val imageResourceId: Int
)
