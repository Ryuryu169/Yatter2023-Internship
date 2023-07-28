package com.dmm.bootcamp.yatter2023.ui.settings

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dmm.bootcamp.yatter2023.infra.pref.MePreferences
import com.dmm.bootcamp.yatter2023.util.SingleLiveEvent

class SettingsViewModel(
    val context: Context
) : ViewModel() {
    private val _navigateToPublicTimelineFromSettings: SingleLiveEvent<Unit> = SingleLiveEvent()
    val navigateToPublicTimelineFromSettings: LiveData<Unit> = _navigateToPublicTimelineFromSettings

    private val _navigateToAccount: SingleLiveEvent<Unit> = SingleLiveEvent()
    val navigateToAccount: LiveData<Unit> = _navigateToAccount

    private val _navigateToLogin: SingleLiveEvent<Unit> = SingleLiveEvent()
    val navigateToLogin: LiveData<Unit> = _navigateToLogin

    fun onClickReturn(){
        _navigateToPublicTimelineFromSettings.value = Unit
    }

    fun onClickAccount(){
        _navigateToAccount.value = Unit
    }

    fun onClickFollower(){

    }

    fun onClickSignOut(){
        MePreferences(context).clear()
        _navigateToLogin.value = Unit
    }
}