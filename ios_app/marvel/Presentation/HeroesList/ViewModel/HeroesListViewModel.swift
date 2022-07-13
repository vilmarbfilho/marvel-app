//
//  HeroesListViewModel.swift
//  marvel
//
//  Created by Vilmar Bispo Filho on 02/06/22.
//

import Foundation

class HeroesListViewModel {
    
    let heroes: Observable<[HeroModel]?> = Observable(nil)
    let error: Observable<String> = Observable("")
    
    func getHeroes() {
        MarvelService().getCharacters { heroesArray in
            self.heroes.value = heroesArray.map{ $0.toHeroModel() }
        } onFailure: {
            self.error.value = "Error"
        }
    }
}
