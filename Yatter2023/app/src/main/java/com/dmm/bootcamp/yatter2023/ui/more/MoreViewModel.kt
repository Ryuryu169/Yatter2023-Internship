package com.dmm.bootcamp.yatter2023.ui.more

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dmm.bootcamp.yatter2023.domain.model.AccountId
import com.dmm.bootcamp.yatter2023.domain.model.Status
import com.dmm.bootcamp.yatter2023.domain.model.StatusId
import com.dmm.bootcamp.yatter2023.domain.repository.StatusRepository
import com.dmm.bootcamp.yatter2023.ui.timeline.MoreUiState
import com.dmm.bootcamp.yatter2023.ui.timeline.bindingmodel.converter.StatusConverter
import com.dmm.bootcamp.yatter2023.util.SingleLiveEvent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MoreViewModel(
    private val statusRepository: StatusRepository
): ViewModel() {
    private val _uiState: MutableStateFlow<MoreUiState> =
        MutableStateFlow(MoreUiState.empty())
    val uiState: StateFlow<MoreUiState> = _uiState

    private val _navigateToPublicTimeline: SingleLiveEvent<Unit> = SingleLiveEvent()
    val navigateToPublicTimeline: LiveData<Unit> = _navigateToPublicTimeline

    private suspend fun findById(id: StatusId) {
        val status = statusRepository.findById(id)
        _uiState.update {
            it.copy(
                status = StatusConverter.convertToBindingModel(status!!), // 2
            )
        }
    }

    fun onResume(){
        viewModelScope.launch { // 1
            _uiState.update { it.copy(isLoading = true) } // 2
            findById(StatusId(uiState.value.currentNum))
            _uiState.update { it.copy(isLoading = false) } // 4
        }
    }

    fun onClickGoBack(){
        _navigateToPublicTimeline.value = Unit
    }
}