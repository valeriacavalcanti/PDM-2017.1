//
//  Tela2ViewController.swift
//  Janela
//
//  Created by admin on 07/08/17.
//  Copyright © 2017 admin. All rights reserved.
//

import UIKit

class Tela2ViewController: UIViewController {
    @IBOutlet weak var lbTitulo: UILabel!
        
    override func viewDidLoad() {
        super.viewDidLoad()
        
        print("Tela2: ViewDidLoad")
        self.lbTitulo.text = "ViewDidLoad"
    }

    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(true)
        
        print("Tela2: viewWillAppear")
        self.lbTitulo.text = "viewWillAppear"
    }
    
    override func viewDidAppear(_ animated: Bool) {
        super.viewDidAppear(true)
        
        print("Tela2: viewDidAppear")
        self.lbTitulo.text = "viewDidAppear"
    }
    
    @IBAction func Voltar(_ sender: Any) {
        // liberar a Tela 2, consequentemente ... Tela 1 fica visível.
        
    }
    
    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destinationViewController.
        // Pass the selected object to the new view controller.
    }
    */

}
