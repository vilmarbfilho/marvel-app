//
//  HeroModel.swift
//  marvel
//
//  Created by Vilmar Bispo Filho on 3/4/21.
//

import Foundation

class HeroModel {
    
    let name: String
    let description: String
    let imageURL: String
    
    init(name: String, description: String, imageURL: String) {
        self.name = name
        self.description = description
        self.imageURL = imageURL
    }
}
