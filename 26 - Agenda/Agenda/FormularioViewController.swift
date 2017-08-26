//
//  ViewController.swift
//  Agenda
//
//  Created by admin on 26/08/17.
//  Copyright © 2017 admin. All rights reserved.
//

import UIKit
import CoreData

class FormularioViewController: UIViewController {
    @IBOutlet weak var tfNome: UITextField!
    @IBOutlet weak var stIdade: UIStepper!
    @IBOutlet weak var lbIdade: UILabel!
    
    var dao: PessoaDAO!
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        self.navigationItem.rightBarButtonItem = UIBarButtonItem(barButtonSystemItem: UIBarButtonSystemItem.save, target: self, action: #selector(salvar))
    }
    
    func salvar() {
        let nome = self.tfNome.text!
        let idade = Int(self.stIdade.value)
        
        self.dao.insert(nome: nome, idade: idade)
        self.navigationController?.popViewController(animated: true)
    }
    
    @IBAction func definir_idade(_ sender: Any) {
        self.lbIdade.text = String(Int(self.stIdade.value))
    }
    
}

