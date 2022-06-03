//
//  HeroesListViewController.swift
//  marvel
//
//  Created by Vilmar Bispo Filho on 3/3/21.
//

import UIKit

class HeroesListViewController: UIViewController, UITableViewDataSource, UITableViewDelegate {
    
    @IBOutlet private weak var tableView: UITableView!
    
    private let viewModel = HeroesListViewModel()
    
    private var heroes = [HeroModel]()

    override func viewDidLoad() {
        super.viewDidLoad()
        setupObservers()
        loadInfo()
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
    
    private func loadInfo() {
        viewModel.getHeroes()
    }
    
    private func setupObservers() {
        viewModel.heroes.observe(on: self) { [weak self] array in
            if let heroes = array {
                self?.heroes = heroes
                self?.tableView.reloadData()
            }
        }
    }
}
