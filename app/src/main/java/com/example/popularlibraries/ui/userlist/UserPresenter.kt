import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter

class UserPresenter(
    private val repository: GithubRepository,
    private val router: Router

) : MvpPresenter<UserView>() {

    lateinit var userToShow: GithubUser
        private set

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        repository.getUsers()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { userlist ->
                    viewState.initList(userlist)
                },
                {})

    }

    fun onBackPressed(): Boolean {
        router.exit()
        return true
    }

    fun showUserInfo(user: GithubUser) {
        router.navigateTo(UserInformationScreen(user))
    }
}