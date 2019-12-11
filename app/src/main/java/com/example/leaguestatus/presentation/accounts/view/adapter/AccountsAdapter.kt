package com.example.leaguestatus.presentation.accounts.view.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.leaguestatus.R
import com.example.leaguestatus.model.User
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.account_card.view.*

class AccountsAdapter : RecyclerView.Adapter<AccountsAdapter.ViewHolder>() {
    lateinit var baseContext: Context
    private var data = mutableListOf<User>()

    fun setContext(context: Context) {
        baseContext = context
    }

    fun setData(summoner: List<User>) {
        data.clear()
        data.addAll(summoner)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val summoner = data[position]
        holder.apply {
            summoner.queue.forEach {
                when (it.queueType) {
                    "RANKED_FLEX_SR" -> {
                        flexElo.text = "${it.tier} ${it.rank}"
                        flexPdl.text = "${it.leaguePoints} PDL"
                        queueNameFlex.text = "Flex:"
                    }
                    "RANKED_SOLO_5x5" -> {
                        soloduoElo.text = "${it.tier} ${it.rank}"
                        soloduoPdl.text = "${it.leaguePoints} PDL"
                        queueNameSoloduo.text = "Solo/Duo:"
                    }
                }
            }
            name.text = summoner.summoner.name
            Glide.with(baseContext)
                .load("https://ddragon.leagueoflegends.com/cdn/9.23.1/img/profileicon/${summoner.summoner.profileIconId}.png")
                .into(icon)

        }

    }

    override fun getItemCount(): Int = data.size

    override fun getItemViewType(position: Int) = if (position == 0) 1 else 0


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.account_card, parent, false)
        )


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.summonerName
        val soloduoElo: TextView = itemView.summonerElo1
        val soloduoPdl: TextView = itemView.summonerPDL1
        val flexElo: TextView = itemView.summonerElo2
        val flexPdl: TextView = itemView.summonerPDL2
        val icon: CircleImageView = itemView.summonerIcon
        val queueNameSoloduo: TextView = itemView.soloduoQueue
        val queueNameFlex: TextView = itemView.flexQueue
    }

}
