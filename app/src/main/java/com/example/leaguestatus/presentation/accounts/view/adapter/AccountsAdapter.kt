package com.example.leaguestatus.presentation.accounts.view.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.leaguestatus.R
import com.example.leaguestatus.model.User
import kotlinx.android.synthetic.main.account_card.view.*

class AccountsAdapter : RecyclerView.Adapter<AccountsAdapter.ViewHolder>() {

    private var data = mutableListOf<User>()

    fun setData(summoner: List<User>) {
        data.clear()
        data.addAll(summoner)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val summoner = data[position]
        holder.apply {
            name.text = summoner.name
            elo.text = summoner.rank + summoner.tier
            pdl.text = summoner.leaguePoints.toString()
            //TODO set all values from data
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
        val name = itemView.summonerName
        val elo = itemView.summonerElo
        val pdl = itemView.summonerPDL
        val icon = itemView.summonerIcon
    }

}
