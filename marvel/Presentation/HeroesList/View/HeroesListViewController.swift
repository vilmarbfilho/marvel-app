//
//  HeroesListViewController.swift
//  marvel
//
//  Created by Vilmar Bispo Filho on 3/3/21.
//

import UIKit

class HeroesListViewController: UIViewController, UITableViewDataSource {
    
    @IBOutlet private var tableView: UITableView!

    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
    }
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        <#code#>
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        <#code#>
    }
}
