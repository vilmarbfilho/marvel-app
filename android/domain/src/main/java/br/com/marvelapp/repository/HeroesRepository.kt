package br.com.marvelapp.repository

import br.com.marvelapp.entity.Hero

interface HeroesRepository {

    suspend fun getHeroes():  List<Hero>

}