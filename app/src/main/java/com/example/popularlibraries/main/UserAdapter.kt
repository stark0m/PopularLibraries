
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.popularlibraries.R
import com.example.popularlibraries.databinding.ItemUserBinding
import com.example.popularlibraries.model.RecyclerItemClick


class UserAdapter( val onItemSelect: RecyclerItemClick) :
    RecyclerView.Adapter<GithubUserViewHolder>() {

     var users: List<GithubUser> = emptyList()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubUserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return GithubUserViewHolder(view)
    }

    override fun onBindViewHolder(holder: GithubUserViewHolder, position: Int) {
        holder.bind(users[position],onItemSelect)
    }

    override fun getItemCount() = users.size
}

class GithubUserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val binding = ItemUserBinding.bind(itemView)
    private val tvLogin by lazy { itemView.findViewById<TextView>(R.id.tvUserLogin) }

    fun bind(item: GithubUser,onItemSelect: RecyclerItemClick) = with(item) {
        tvLogin.setOnClickListener{
            onItemSelect.onItemClick(this)
        }
        tvLogin.text = login
        binding.avatarImageView.load(avatarUrl)
    }
}