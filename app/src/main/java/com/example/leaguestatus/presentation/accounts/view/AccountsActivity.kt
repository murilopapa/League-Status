package com.example.leaguestatus.presentation.accounts.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.leaguestatus.R
import com.example.leaguestatus.mechanism.livedata.Status
import com.example.leaguestatus.presentation.accounts.presenter.AccountsPresenter
import com.example.leaguestatus.presentation.accounts.view.adapter.AccountsAdapter
import kotlinx.android.synthetic.main.activity_accounts.*
import kotlinx.android.synthetic.main.search_bar.view.*
import org.koin.android.ext.android.inject

class AccountsActivity : AppCompatActivity() {

    private val summonerListAdapter = AccountsAdapter()
    private val presenter: AccountsPresenter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_accounts)
        setupListeners()
        presenter.getAllUsers()
        setupRecyclerView()
        observeChanges()
    }

    private fun observeChanges() {
        presenter.userLiveData.observe(this, Observer {
            when (it?.status) {
                Status.LOADING -> {
                    progressBar.visibility = View.VISIBLE
                }
                Status.ERROR -> {
                }
                Status.SUCCESS -> {
                    it.data?.let {
                        summonerListAdapter.setData(it)
                    } ?: let {
                        summonerListAdapter.setData(emptyList())
                    }

                    progressBar.visibility = View.GONE
                }
                else -> {

                }
            }
        })
    }

    private fun setupListeners() {
        include.search.setOnClickListener {

            if (include.editText.text.isNullOrEmpty()) {
                Toast.makeText(this, "Empty search argument", Toast.LENGTH_SHORT).show()

            } else {
                presenter.getSearchedSummoner(include.editText.text.toString())
            }

        }
    }

    private fun setupRecyclerView() {
        rvAccounts.apply {
            summonerListAdapter.setContext(context)
            adapter = summonerListAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }
}
