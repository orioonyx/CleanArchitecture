package com.kyungeun.cleanarchitecture.presentation.home

import android.widget.Toast
import androidx.annotation.StringRes
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewbinding.ViewBinding
import com.kyungeun.cleanarchitecture.databinding.FragmentHomeBinding
import com.kyungeun.cleanarchitecture.presentation.base.BaseFragment
import com.kyungeun.cleanarchitecture.presentation.home.adapter.ReposAdapter
import com.kyungeun.cleanarchitecture.util.Constants.GIT_ID
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    @Inject
    lateinit var reposAdapter: ReposAdapter

    private val homeViewModel: HomeViewModel by viewModels()

    override fun constructViewBinding(): ViewBinding = FragmentHomeBinding.inflate(layoutInflater)

    override fun init(viewBinding: ViewBinding) {
        homeViewModel.getRepos()
        initUi()
        fetchRepos()
    }

    private fun initUi() {
        getViewBinding().reposRV.run {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = reposAdapter
        }
    }

    private fun fetchRepos() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                homeViewModel.uiState.collect { state ->
                    when (state) {
                        is HomeViewModel.ReposUiState.Loaded -> onLoaded(state.itemState)
                        is HomeViewModel.ReposUiState.Error -> showError(state.message)
                        is HomeViewModel.ReposUiState.Loading -> showLoading()
                    }
                }
            }
        }
    }

    private fun onLoaded(homeItemUiState: HomeItemUiState) {
        homeItemUiState.run {
            getViewBinding().userNameTv.text = "Github Id : $GIT_ID"
            reposAdapter.update(homeItemUiState.gitRepos)
        }
    }

    private fun showLoading() {
        Timber.d("showLoading")
    }

    private fun showError(@StringRes stringRes: Int) {
        Toast.makeText(requireContext(), stringRes, Toast.LENGTH_SHORT).show()
    }
}