package com.apprizka.apprizka.data.model

import android.content.Context
import android.content.SharedPreferences
import com.apprizka.apprizka.data.local.AuthPref

data class AuthUser(
        val id: Int=0,
        val email: String="",
        val password:String="",
        val fullName:String=""
)