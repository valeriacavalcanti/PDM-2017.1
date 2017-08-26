//
//  ViewController.swift
//  Viagem
//
//  Created by admin on 14/08/17.
//  Copyright © 2017 admin. All rights reserved.
//

import UIKit

class FormularioViewController: UIViewController {
    @IBOutlet weak var tfDestino: UITextField!
    @IBOutlet weak var lbQuantidade: UILabel!
    @IBOutlet weak var stQuantidade: UIStepper!
    @IBOutlet weak var swTemporada: UISwitch!
    @IBOutlet weak var tfOrcamento: UITextField!
    
    var cadastro: Cadastro!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        self.navigationItem.rightBarButtonItem = UIBarButtonItem(barButtonSystemItem: UIBarButtonSystemItem.save, target: self, action: #selector(salvar))
        
    }
    
    @IBAction func definirConvidados(_ sender: Any) {
        self.lbQuantidade.text = String(Int(self.stQuantidade.value))
    }
    
    func salvar() {
        let dest = self.tfDestino.text
        let qtde = Int(self.stQuantidade.value)
        let alta = self.swTemporada.isOn
        let valor = Float(self.tfOrcamento.text!)
        
        let viagem = Viagem(destino: dest!, convidados: qtde, orcamento: valor!, altaTemporada: alta)
        
        //print("\(viagem)")
        self.cadastro.add(nova: viagem)
        
        self.navigationController?.popViewController(animated: true)
    }

}
