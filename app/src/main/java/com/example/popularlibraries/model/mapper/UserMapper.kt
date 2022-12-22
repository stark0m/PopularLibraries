package com.mirkhusainov.geekbrainscourse.core.mapper

import com.mirkhusainov.geekbrainscourse.core.network.UserDto
import com.mirkhusainov.geekbrainscourse.model.GithubUser

object UserMapper {

    fun mapToEntity(dto: UserDto): GithubUser {
        return GithubUser(
            id = dto.id,
            login = dto.login,
            avatarUrl = dto.avatarUrl
        )
    }
}