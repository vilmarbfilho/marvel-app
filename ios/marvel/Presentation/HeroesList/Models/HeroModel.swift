//
//  HeroModel.swift
//  marvel
//
//  Created by Vilmar Bispo Filho on 3/4/21.
//

import Foundation

class HeroModel {
    
    let id: Int
    let name: String
    let description: String
    let imageUrl: String
    
    init(id: Int, name: String, description: String, imageUrl: String) {
        self.id = id
        self.name = name
        self.description = description
        self.imageUrl = imageUrl
    }
}
