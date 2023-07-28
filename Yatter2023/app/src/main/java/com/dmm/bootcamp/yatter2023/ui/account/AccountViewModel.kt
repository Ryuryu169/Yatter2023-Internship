package com.dmm.bootcamp.yatter2023.ui.account

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dmm.bootcamp.yatter2023.domain.repository.AccountRepository
import com.dmm.bootcamp.yatter2023.util.SingleLiveEvent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AccountViewModel(
    private val accountRepository: AccountRepository,
) : ViewModel() {

    private val _uiState: MutableStateFlow<AccountUiState> = MutableStateFlow(AccountUiState.empty())
    val uiState: StateFlow<AccountUiState> = _uiState

    private val _goBack: SingleLiveEvent<Unit> = SingleLiveEvent()
    val goBack: LiveData<Unit> = _goBack

    private val _navigateToEdit: SingleLiveEvent<Unit> = SingleLiveEvent()
    val navigateToEdit: LiveData<Unit> = _navigateToEdit

    private suspend fun fetchMyself() {
        val myself = accountRepository.findMe()
        //Log.d("Debug",myself!!.username.value)
        _uiState.update {
            it.copy(
                myself = myself!!
            )
        }
    }

    fun onResume() {
        viewModelScope.launch { // 1
            _uiState.update { it.copy(isLoading = true) } // 2
            fetchMyself()
            _uiState.update { it.copy(isLoading = false) } // 4
        }
    }

    fun onChangedClick() {
        _navigateToEdit.value = Unit
    }

    fun onReturn() {
        _goBack.value = Unit
    }
}