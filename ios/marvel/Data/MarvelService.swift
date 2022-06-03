//
//  MarvelService.swift
//  marvel
//
//  Created by Vilmar Bispo Filho on 31/05/22.
//

import Foundation
import Alamofire

class MarvelService {
    
    private let publicKey = "2f0be02d2438da8ea160cc70b7213d2d"
    private let privateKey = "4e8a41aae4a96dcdd26cc26a5fdd42aba3ba6352"
    private var apiKey: String {
        get {
            return publicKey
        }
    }
    
    private let URL_BASE = "http://gateway.marvel.com"
    
    func getComics() {
        let ts = getTimestamp()
        let hash = calculateHash(timestamp: ts)
        
        AF.request("\(URL_BASE)/v1/public/comics?ts=\(ts)&apikey=\(apiKey)&hash=\(hash)").response { response in
            debugPrint(response)
        }
    }
    
    func getCharacters() {
        let ts = getTimestamp()
        let hash = calculateHash(timestamp: ts)
        
        AF.request("\(URL_BASE)/v1/public/characters?ts=\(ts)&apikey=\(apiKey)&hash=\(hash)").responseDecodable(of: ApiResponse<HeroesResponse>.self) { (response) in
            guard let apiResponse = response.value else { return }
            print(apiResponse)
        }
    }
    
    private func calculateHash(timestamp: String) -> String {
        let hash = (timestamp + privateKey + publicKey).md5
        return hash
    }
    
    private func getTimestamp() -> String {
        let currentTimeMillis = Date().currentTimeMillis()
        let ts = String(currentTimeMillis)
        return ts
    }
}
