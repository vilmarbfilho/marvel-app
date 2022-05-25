//
//  HeroesListViewController.swift
//  marvel
//
//  Created by Vilmar Bispo Filho on 3/3/21.
//

import UIKit

class HeroesListViewController: UIViewController, UITableViewDataSource, UITableViewDelegate {
    
    @IBOutlet private weak var tableView: UITableView!
    
    private var heroes: Array<HeroModel> = [
        HeroModel(name: "Captain America", description: "The First Avenger", imageURL: "https://i.pinimg.com/originals/97/bf/27/97bf27becd0df4ff387b882572925416.jpg"),
        HeroModel(name: "Iron Man", description: "Genius. Billionaire. Philanthropist.", imageURL: "https://conteudo.imguol.com.br/c/entretenimento/96/2020/08/07/iron-man-1596813808466_v2_450x337.jpg")
    ]

    override func viewDidLoad() {
        super.viewDidLoad()
    }
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return heroes.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        if let cell = tableView.dequeueReusableCell(withIdentifier: "HeroCellIdentifier") as? HeroTableViewCell {
            cell.configureCell(heroModel: heroes[indexPath.row])
            return cell
        }

        return UITableViewCell()
    }
}
