//
//  HeroesListViewModel.swift
//  marvel
//
//  Created by Vilmar Bispo Filho on 02/06/22.
//

import Foundation

class HeroesListViewModel {
    
    func getHeroes() {
        MarvelService().getCharacters()
    }
}
