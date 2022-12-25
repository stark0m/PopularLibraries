
import io.reactivex.rxjava3.core.Single

interface GithubRepository {
    fun getUsers(): Single<List<GithubUser>>
}