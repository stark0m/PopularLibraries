package com.mirkhusainov.geekbrainscourse.core.mapper

import com.example.popularlibraries.core.database.UserDBObject
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

    fun mapToEntity(dbObject: UserDBObject): GithubUser {
        return GithubUser(
            id = dbObject.id,
            login = dbObject.login,
            avatarUrl = dbObject.avatarUrl
        )
    }

    fun mapToDBObject(dto: UserDto): UserDBObject {
        return UserDBObject(
            id = dto.id,
            login = dto.login,
            avatarUrl = dto.avatarUrl
        )
    }
}