//
//  HeroesMapper.swift
//  marvel
//
//  Created by Vilmar Bispo Filho on 03/06/22.
//

import Foundation

extension HeroesResponse {
    func toHeroModel() -> HeroModel {
        return HeroModel(
            id: self.id,
            name: self.name,
            description: self.resultDescription,
            imageUrl: "\(self.thumbnail.url).\(self.thumbnail.ext)"
        )
    }
}
