//
//  HeroTableViewCell.swift
//  marvel
//
//  Created by Vilmar Bispo Filho on 3/4/21.
//

import Foundation
import UIKit
import Kingfisher

class HeroTableViewCell: UITableViewCell {
    
    @IBOutlet weak var imageCell: UIImageView!
    @IBOutlet weak var nameCell: UILabel!
    @IBOutlet weak var descriptionCell: UILabel!
 
    func configureCell(heroModel: HeroModel) {
        nameCell.text = heroModel.name
        descriptionCell.text = heroModel.description
        
        let url = URL(string: heroModel.imageUrl)
        imageCell.kf.setImage(with: url)
    }
}
