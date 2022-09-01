package br.com.marvelapp.characterlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.marvelapp.databinding.FragmentHeroesListBinding
import br.com.marvelapp.characterlist.adapter.CharactersAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharacterListFragment: Fragment() {

    private lateinit var binding: FragmentHeroesListBinding
    private val viewModel: CharacterListViewModel by viewModel()

    private val charactersAdapter = CharactersAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHeroesListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupObservers()
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadCharacters()
    }

    private fun setupObservers() {
       viewModel.characters.observe(viewLifecycleOwner) {
            charactersAdapter.heroes = it
       }
    }

    private fun setupRecyclerView() {
        with(binding.rvHeroesList) {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext())
            adapter = charactersAdapter
        }
    }
}