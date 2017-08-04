//
//  ViewController.swift
//  Pessoas
//
//  Created by admin on 04/08/17.
//  Copyright © 2017 admin. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    @IBOutlet weak var tfNome: UITextField!
    @IBOutlet weak var tfIdade: UITextField!
    @IBOutlet weak var lbContador: UILabel!
    
    var cadastro = Cadastro()
    
    @IBAction func cadastrar(_ sender: Any) {
        let lNome = self.tfNome.text
        let lIdade = Int(self.tfIdade.text!)
        
        //print("Nome:\(lNome)  - Idade:\(lIdade) ")
        
        let p = Pessoa(nome: lNome!, idade: lIdade!)
        self.cadastro.add(nova: p)
        
        self.lbContador.text = String(self.cadastro.quantidade())

        print(self.cadastro.lista)
    }
}

