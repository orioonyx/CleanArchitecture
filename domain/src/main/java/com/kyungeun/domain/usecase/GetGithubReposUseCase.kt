package com.kyungeun.domain.usecase

import com.kyungeun.domain.model.GithubRepo
import com.kyungeun.domain.repository.GithubRepository
import kotlinx.coroutines.*

class GetGithubReposUseCase(private val githubRepository: GithubRepository) {

    operator fun invoke(
        owner: String,
        scope: CoroutineScope,
        onResult: (List<GithubRepo>) -> Unit = {}
    ) {
        scope.launch(Dispatchers.Main) {
            val deferred = async(Dispatchers.IO) {
                githubRepository.getRepos(owner)
            }
            onResult(deferred.await())
        }
    }
}