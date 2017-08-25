//
//  SobreViewController.swift
//  Viagem
//
//  Created by admin on 25/08/17.
//  Copyright © 2017 admin. All rights reserved.
//

import UIKit

class SobreViewController: UIViewController {
    
    var cadastro: Cadastro!
    
    @IBOutlet weak var lbQuantidade: UILabel!
    @IBOutlet weak var lbTotal: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
    }
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(true)
        self.lbQuantidade.text = String(self.cadastro.size())
        self.lbTotal.text = "R$ \(self.cadastro.total())"
    }
}
