//
//  HeroesImageResponse.swift
//  marvel
//
//  Created by Vilmar Bispo Filho on 03/06/22.
//

import Foundation

struct HeroesImageResponse : Decodable {
    let url: String
    let ext: String
    
    enum CodingKeys: String, CodingKey {
        case url = "path"
        case ext = "extension"
    }
}
