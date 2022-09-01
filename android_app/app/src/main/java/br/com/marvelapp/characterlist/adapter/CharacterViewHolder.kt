package br.com.marvelapp.characterlist.adapter

import androidx.recyclerview.widget.RecyclerView
import br.com.marvelapp.databinding.ItemHeroBinding
import br.com.marvelapp.characterlist.model.CharacterUi

class CharacterViewHolder(private val view: ItemHeroBinding): RecyclerView.ViewHolder(view.root) {

    fun bind(hero: CharacterUi) {
        view.tvNameHeroItem.text = hero.name
        view.tvDescriptionHeroItem.text = hero.description
    }
}