package br.com.marvelapp.characterlist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.marvelapp.databinding.ItemHeroBinding
import br.com.marvelapp.characterlist.model.CharacterUi

class CharactersAdapter : RecyclerView.Adapter<CharacterViewHolder>() {

    var heroes: List<CharacterUi> = emptyList()
        set(value) {
            field = heroes
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemHeroBinding.inflate(inflater, parent, false)
        return CharacterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(heroes[position])
    }

    override fun getItemCount(): Int = heroes.size

}