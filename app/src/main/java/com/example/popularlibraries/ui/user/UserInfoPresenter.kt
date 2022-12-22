import com.example.popularlibraries.ui.user.UserInfoView
import com.github.terrakok.cicerone.Router
import com.mirkhusainov.geekbrainscourse.model.GithubUser
import com.mirkhusainov.geekbrainscourse.repository.GithubUserRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter

class UserInfoPresenter(
    private val repository: GithubUserRepository,
    private val view: UserInfoView,
    private val userToShow: GithubUser
) : MvpPresenter<UserInfoView>() {

    fun onBackPressed(): Boolean {
        return true
    }

    fun showUserInfoPresenterCommand(){
        view.showLoading()
        view.showUserInfo(userToShow)
        repository.getUserRepositoryList(userToShow.login)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {repoList->
                    view.showRepoList(repoList)
                    view.hideLoading()
                },
                {})
    }
}