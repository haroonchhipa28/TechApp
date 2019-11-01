package com.example.mohammadchhipa.techchallengeapp

import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mohammadchhipa.techchallengeapp.adapter.DeliveryListAdapter
import com.example.mohammadchhipa.techchallengeapp.databinding.ActivityMainBinding
import com.example.mohammadchhipa.techchallengeapp.domain.repository.State
import com.example.mohammadchhipa.techchallengeapp.listener.ItemClickListener
import com.example.mohammadchhipa.techchallengeapp.model.DeliveryData
import com.example.mohammadchhipa.techchallengeapp.utils.AppConstant
import com.example.mohammadchhipa.techchallengeapp.view.BaseActivity
import com.example.mohammadchhipa.techchallengeapp.viewmodel.MainViewModel
import javax.inject.Inject


class MainActivity : BaseActivity(), ItemClickListener {

    lateinit var adapter: DeliveryListAdapter
    private lateinit var mainViewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding
    @Inject
    lateinit var factory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
        setUpObserver()
    }

    private fun init() {

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.recyclerList.layoutManager = LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false)
        adapter = DeliveryListAdapter(this)
        binding.recyclerList.adapter = adapter

        binding.swipeRefresh.setOnRefreshListener {
            mainViewModel.onRefresh()
        }

        mainViewModel = ViewModelProviders.of(this, factory)
                .get(MainViewModel::class.java)

        binding.viewModel = mainViewModel
        binding.executePendingBindings()

        setTitle(getString(R.string.things_to_deliver))

    }

    override fun onItemClick(deliveryData: DeliveryData) {
        startActivity(Intent(this@MainActivity, MapsActivity::class.java).putExtra(AppConstant.DATA, deliveryData))
    }

    override fun setUpObserver() {
        mainViewModel.itemList.observe(this, Observer {
            adapter.submitList(it)
            adapter.notifyDataSetChanged()
            if (it != null && it.size > 0 && it[0] != null) {
                mainViewModel.item.set(it[0])
                mainViewModel.noData.set(false)
            } else {
                mainViewModel.noData.set(true)
            }

            if (binding.swipeRefresh.isRefreshing) {
                binding.swipeRefresh.isRefreshing = false
            }
        })

        mainViewModel.boundaryCallback.state.observe(this, Observer {
            when (it) {
                State.ERROR, State.NETWORK_ERROR -> {
                    mainViewModel.isLoading.set(it == State.DONE)

//                    showErrorDialog(
//                            if (it == State.NETWORK_ERROR) {
//                                R.string.network_error
//                            } else R.string.todo_list_error_message
//                    )
                    if (binding.swipeRefresh.isRefreshing) {
                        binding.swipeRefresh.isRefreshing = false
                    }
                }
                State.PAGE_LOADING -> {


                    //  adapter.notifyItemChanged(adapter.itemCount - 1)
                }
                State.LOADED -> {
                    mainViewModel.isLoading.set(it == State.LOADING)
//                    showSuccessDialog(R.string.all_data_fetched)
                }
                else -> {
                    mainViewModel.isLoading.set(it == State.LOADING)
                }
            }
        })
    }
}
