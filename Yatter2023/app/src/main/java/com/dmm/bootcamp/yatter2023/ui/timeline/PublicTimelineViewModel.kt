package com.dmm.bootcamp.yatter2023.ui.timeline

import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dmm.bootcamp.yatter2023.domain.repository.StatusRepository
import com.dmm.bootcamp.yatter2023.ui.more.MoreActivity
import com.dmm.bootcamp.yatter2023.ui.timeline.bindingmodel.converter.StatusConverter
import com.dmm.bootcamp.yatter2023.util.SingleLiveEvent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PublicTimelineViewModel(
    private val statusRepository: StatusRepository,
) : ViewModel() {

    // private val viewModel: PublicTimelineViewModel by viewModel()

    private val _uiState: MutableStateFlow<PublicTimelineUiState> =
        MutableStateFlow(PublicTimelineUiState.empty())
    val uiState: StateFlow<PublicTimelineUiState> = _uiState

    private val _navigateToPost: SingleLiveEvent<Unit> = SingleLiveEvent()
    val navigateToPost: LiveData<Unit> = _navigateToPost

    private val _navigateToSettings: SingleLiveEvent<Unit> = SingleLiveEvent()
    val navigateToSettings: LiveData<Unit> = _navigateToSettings

    private val _navigateToMore: SingleLiveEvent<Unit> = SingleLiveEvent()
    val navigateToMore: LiveData<Unit> = _navigateToMore

    private suspend fun fetchPublicTimeline() {
        val statusList = statusRepository.findAllPublic()
        _uiState.update {
            it.copy(
                statusList = StatusConverter.convertToBindingModel(statusList), // 2
            )
        }
    }

    fun onResume() {
        viewModelScope.launch { // 1
            _uiState.update { it.copy(isLoading = true) } // 2
            fetchPublicTimeline() // 3
            _uiState.update { it.copy(isLoading = false) } // 4
        }
    }

    fun onRefresh() {
        viewModelScope.launch { // 1
            _uiState.update { it.copy(isRefreshing = true) } // 2
            fetchPublicTimeline() // 3
            _uiState.update { it.copy(isRefreshing = false) } // 4
        }
    }

    fun onClickPost() {
        _navigateToPost.value = Unit
    }

    fun onClickSettings() {
        _navigateToSettings.value = Unit
    }

    fun onClickMore(text: String) {
        _uiState.update {
            it.copy(currentNum = text)
        }
        _navigateToMore.value = Unit
    }
}