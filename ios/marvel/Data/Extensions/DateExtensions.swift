//
//  DateExtensions.swift
//  marvel
//
//  Created by Vilmar Bispo Filho on 31/05/22.
//

import Foundation

extension Date {
    func currentTimeMillis() -> Int64 {
        return Int64(self.timeIntervalSince1970 * 1000)
    }
}
