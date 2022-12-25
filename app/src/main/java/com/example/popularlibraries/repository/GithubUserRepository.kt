
import io.reactivex.rxjava3.core.Single

interface GithubUserRepository {
    fun getUserRepositoryList(login:String): Single<List<GithubRepo>>
}