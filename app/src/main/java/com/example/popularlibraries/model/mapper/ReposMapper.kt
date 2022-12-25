
object ReposMapper {

    fun map(repoDto: RepoDto): GithubRepo {
        return GithubRepo(
            id = repoDto.id,
            forks = repoDto.forks,
            name = repoDto.name
        )
    }
}