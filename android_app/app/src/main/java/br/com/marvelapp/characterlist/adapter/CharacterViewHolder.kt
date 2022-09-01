package br.com.marvelapp.characterlist.adapter

import androidx.recyclerview.widget.RecyclerView
import br.com.marvelapp.databinding.ItemHeroBinding
import br.com.marvelapp.characterlist.model.HeroUi

class CharacterViewHolder(private val view: ItemHeroBinding): RecyclerView.ViewHolder(view.root) {

    fun bind(hero: HeroUi) {
        view.tvNameHeroItem.text = hero.name
        view.tvDescriptionHeroItem.text = hero.description
    }
}