package br.com.marvelapp.characterlist.adapter

import androidx.recyclerview.widget.RecyclerView
import br.com.marvelapp.characterlist.model.CharacterUi
import br.com.marvelapp.databinding.ItemCharacterBinding

class CharacterViewHolder(
    private val view: ItemCharacterBinding
) : RecyclerView.ViewHolder(view.root) {

    fun bind(hero: CharacterUi) {
        view.tvNameHeroItem.text = hero.name
        view.tvDescriptionHeroItem.text = hero.description
    }
}