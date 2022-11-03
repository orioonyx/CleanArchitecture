package com.kyungeun.cleanarchitecture.presentation.home

import androidx.annotation.StringRes
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kyungeun.cleanarchitecture.util.CoroutineDispatcherProvider
import com.kyungeun.cleanarchitecture.domain.model.GitReposRequest
import com.kyungeun.cleanarchitecture.domain.usecase.GetGitReposUseCase
import com.kyungeun.cleanarchitecture.util.Constants.GIT_ID
import com.kyungeun.cleanarchitecture.util.ExceptionParser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getGitReposUseCase: GetGitReposUseCase,
    private val coroutineDispatcherProvider: CoroutineDispatcherProvider
) : ViewModel() {

    private val _uiState = MutableStateFlow<ReposUiState>(ReposUiState.Loading)
    val uiState: StateFlow<ReposUiState> = _uiState

    fun getRepos() {
        _uiState.value = ReposUiState.Loading

        viewModelScope.launch(coroutineDispatcherProvider.iO()) {
            try {
                val requestParam = GitReposRequest(GIT_ID)
                val result = getGitReposUseCase.execute(requestParam)
                _uiState.value = ReposUiState.Loaded(HomeItemUiState(result))
            } catch (error: Exception) {
                _uiState.value = ReposUiState.Error(ExceptionParser.getMessage(error))
            }
        }
    }

    sealed class ReposUiState {
        object Loading : ReposUiState()
        class Loaded(val itemState: HomeItemUiState) : ReposUiState()
        class Error(@StringRes val message: Int) : ReposUiState()
    }
}