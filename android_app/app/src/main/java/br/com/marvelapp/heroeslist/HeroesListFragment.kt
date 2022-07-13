package br.com.marvelapp.heroeslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.marvelapp.databinding.FragmentHeroesListBinding
import br.com.marvelapp.heroeslist.adapter.HeroesAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class HeroesListFragment: Fragment() {

    private lateinit var binding: FragmentHeroesListBinding
    private val viewModel: HeroesListViewModel by viewModel()

    private val adapter = HeroesAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHeroesListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        with(binding.rvHeroesList) {
            layoutManager = LinearLayoutManager(requireContext())

        }
    }
}