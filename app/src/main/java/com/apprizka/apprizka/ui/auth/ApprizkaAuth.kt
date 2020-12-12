package com.apprizka.apprizka.ui.auth

import android.content.Context
import androidx.activity.OnBackPressedCallback
import com.apprizka.apprizka.data.model.ActionState
import com.apprizka.apprizka.data.repository.AuthRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

object ApprizkaAuth {
    fun logout(context: Context, callback: ((ActionState<Boolean>) -> Unit)?=null){
        val repo = AuthRepository(context)
        CoroutineScope(Dispatchers.IO).launch {
            val resp=repo.logout()
            withContext(Dispatchers.Main){
                if(callback!=null) callback.invoke(resp)
            }
        }
    }
}