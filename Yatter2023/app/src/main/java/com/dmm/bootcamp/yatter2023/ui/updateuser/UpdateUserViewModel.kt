package com.dmm.bootcamp.yatter2023.ui.updateuser

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dmm.bootcamp.yatter2023.domain.model.Username
import com.dmm.bootcamp.yatter2023.infra.pref.MePreferences
import com.dmm.bootcamp.yatter2023.ui.register.UpdateUserUiState
import com.dmm.bootcamp.yatter2023.util.SingleLiveEvent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class UpdateUserViewModel (
    val context: Context
        ): ViewModel() {
    private val _uiState: MutableStateFlow<UpdateUserUiState> =
        MutableStateFlow(UpdateUserUiState.empty())
    val uiState: StateFlow<UpdateUserUiState> = _uiState

    private val _goBack: SingleLiveEvent<Unit> = SingleLiveEvent()
    val goBack: LiveData<Unit> = _goBack

    private val _navigateToPublicTimeline: SingleLiveEvent<Unit> = SingleLiveEvent()
    val navigateToPublicTimeline: LiveData<Unit> = _navigateToPublicTimeline

    fun onChangedUsername(username: String) {
        val snapshotBindingModel = uiState.value.updateUserBindingModel
        _uiState.update {
            it.copy(
                updateUserBindingModel = snapshotBindingModel.copy(
                    username = username
                )
            )
        }
    }
    fun onChangedDisplayName(displayName: String) {
        val snapshotBindingModel = uiState.value.updateUserBindingModel
        _uiState.update {
            it.copy(
                updateUserBindingModel = snapshotBindingModel.copy(
                    displayName = displayName
                )
            )
        }
    }
    fun onChangedBio(bio: String) {
        val snapshotBindingModel = uiState.value.updateUserBindingModel
        _uiState.update {
            it.copy(
                updateUserBindingModel = snapshotBindingModel.copy(
                    bio = bio
                )
            )
        }
    }

    private fun execute(){
        MePreferences(context).putUserName(_uiState.value.updateUserBindingModel.username)
    }

    fun onClickedSaved(){
        viewModelScope.launch { // 1
            _uiState.update { it.copy(isLoading = true) } // 2
            execute() // 3
            _uiState.update { it.copy(isLoading = false) } // 4
        }
        _navigateToPublicTimeline.value = Unit
    }

    fun onClickedBack(){
        _goBack.value = Unit
    }
}