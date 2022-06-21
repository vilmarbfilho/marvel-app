package br.com.marvelapp.heroeslist.adapter

import androidx.recyclerview.widget.RecyclerView
import br.com.marvelapp.databinding.ItemHeroBinding
import br.com.marvelapp.heroeslist.model.HeroUi

class HeroViewHolder(private val view: ItemHeroBinding): RecyclerView.ViewHolder(view.root) {

    fun bind(hero: HeroUi) {
        view.tvNameHeroItem.text = hero.name
        view.tvDescriptionHeroItem.text = hero.description
    }
}