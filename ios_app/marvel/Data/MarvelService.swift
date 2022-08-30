//
//  MarvelService.swift
//  marvel
//
//  Created by Vilmar Bispo Filho on 31/05/22.
//

import Foundation
import Alamofire

class MarvelService {
    
    private let publicKey = ""
    private let privateKey = ""
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
    
    func getCharacters(onSuccess: @escaping ([HeroesResponse]) -> Void, onFailure: @escaping () -> Void) {
        let ts = getTimestamp()
        let hash = calculateHash(timestamp: ts)
        
        AF.request("\(URL_BASE)/v1/public/characters?ts=\(ts)&apikey=\(apiKey)&hash=\(hash)").responseDecodable(of: ApiResponse<HeroesResponse>.self) { (response) in
            guard let apiResponse = response.value else {
                onFailure()
                return
            }
            
            onSuccess(apiResponse.data.results)
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
