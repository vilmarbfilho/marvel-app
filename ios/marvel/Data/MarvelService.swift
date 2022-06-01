//
//  MarvelService.swift
//  marvel
//
//  Created by Vilmar Bispo Filho on 31/05/22.
//

import Foundation
import Alamofire

class MarvelService {
    
    func getComics() {
        let currentTimeMillis = Date().currentTimeMillis()
        let ts = String(currentTimeMillis)
        
        let publicKey = "marvel public Key"
        let privateKey = "marvel public Key"
        let apiKey = publicKey
        
        
        let hash = (ts + privateKey + publicKey).md5
        
        AF.request("http://gateway.marvel.com/v1/public/comics?ts=\(ts)&apikey=\(apiKey)&hash=\(hash)").response { response in
            debugPrint(response)
        }
    }
}
