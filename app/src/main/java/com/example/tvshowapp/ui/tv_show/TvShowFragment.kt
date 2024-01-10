package com.example.tvshowapp.ui.tv_show

import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.tvshowapp.R
import com.example.tvshowapp.base.BaseFragment
import com.example.tvshowapp.databinding.FragmentTvShowBinding
import com.example.tvshowapp.ui.tv_show.adapter.TvShowAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TvShowFragment : BaseFragment<TvShowViewModel>(R.layout.fragment_tv_show) {

    private val binding by viewBinding(FragmentTvShowBinding::bind)
    override val viewModel: TvShowViewModel by viewModels()
    private lateinit var tvShowAdapter: TvShowAdapter

    override fun initViews() {
        super.initViews()
        tvShowAdapter = TvShowAdapter()
        binding.rvTvShows.apply {
            adapter = tvShowAdapter
            layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.HORIZONTAL,
                false
            )
            setHasFixedSize(true)
        }
    }

    override fun initObservers() {
        super.initObservers()
        viewModel.responseTvShow.observe(viewLifecycleOwner) {
            tvShowAdapter.addList(it)
        }
    }
}