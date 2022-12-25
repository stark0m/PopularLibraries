



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