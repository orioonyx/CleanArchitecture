package com.kyungeun.cleanarchitecture.domain.usecase

import com.kyungeun.cleanarchitecture.domain.model.GitRepos
import com.kyungeun.cleanarchitecture.domain.model.GitReposRequest
import com.kyungeun.cleanarchitecture.domain.repository.GitReposRepository
import javax.inject.Inject

class GetGitReposUseCase @Inject constructor(
    private val repository: GitReposRepository) {

    suspend fun execute(request: GitReposRequest): List<GitRepos> {
        return repository.getGitReposRepository(request)
    }
}
