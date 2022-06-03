//
//  HeroesResponse.swift
//  marvel
//
//  Created by Vilmar Bispo Filho on 02/06/22.
//

import Foundation

struct HeroesResponse : Decodable {
    let id: Int
    let name: String
    let resultDescription: String
    
    enum CodingKeys: String, CodingKey {
        case id, name
        case resultDescription = "description"
    }
}
