package br.com.data.service

import br.com.data.model.ApiResponse
import br.com.data.model.character.CharacterResponse
import retrofit2.http.GET

interface MarvelService {

    @GET("/v1/public/characters")
    suspend fun getCharacters(): ApiResponse<List<CharacterResponse>>

}