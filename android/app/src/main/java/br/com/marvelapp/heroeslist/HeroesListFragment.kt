package br.com.marvelapp.heroeslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.marvelapp.databinding.FragmentHeroesListBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class HeroesListFragment: Fragment() {

    private lateinit var binding: FragmentHeroesListBinding
    private val viewModel: HeroesListViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHeroesListBinding.inflate(inflater, container, false)
        return binding.root
    }
}