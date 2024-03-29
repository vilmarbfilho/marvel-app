package br.com.marvelapp.characterlist.adapter

import androidx.recyclerview.widget.RecyclerView
import br.com.marvelapp.characterlist.model.CharacterUi
import br.com.marvelapp.databinding.ItemCharacterBinding
import com.bumptech.glide.Glide

class CharacterViewHolder(
    private val view: ItemCharacterBinding
) : RecyclerView.ViewHolder(view.root) {

    fun bind(character: CharacterUi, onClick: (CharacterUi) -> Unit) {
        view.tvNameHeroItem.text = character.name
        view.tvDescriptionHeroItem.text = character.description

        view.cvHeroItem.setOnClickListener { onClick(character) }

        Glide.with(view.root.context)
            .load(character.imageUrl)
            .into(view.ivHeroItem)
    }
}