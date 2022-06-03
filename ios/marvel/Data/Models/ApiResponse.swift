//
//  Response.swift
//  marvel
//
//  Created by Vilmar Bispo Filho on 02/06/22.
//

import Foundation

struct ApiResponse<T: Decodable>: Decodable {
    let code: Int
    let status: String
    let copyright: String
    let attributionText: String
    let attributionHTML: String
    let data: DataResponse<T>
    let etag: String
    
    enum CodingKeys: String, CodingKey {
        case code
        case status
        case copyright
        case attributionText
        case attributionHTML
        case data
        case etag
    }
}
