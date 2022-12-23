package com.mirkhusainov.geekbrainscourse.core.mapper

import com.mirkhusainov.geekbrainscourse.core.network.RepoDto
import com.mirkhusainov.geekbrainscourse.model.GithubRepo

object ReposMapper {

    fun map(repoDto: RepoDto): GithubRepo {
        return GithubRepo(
            id = repoDto.id,
            forks = repoDto.forks,
            name = repoDto.name
        )
    }
}