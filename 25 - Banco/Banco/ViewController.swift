//
//  ViewController.swift
//  Banco
//
//  Created by admin on 26/08/17.
//  Copyright © 2017 admin. All rights reserved.
//

import UIKit
import CoreData

class ViewController: UIViewController {

    @IBOutlet weak var tfNome: UITextField!
    
    
    @IBAction func salvar(_ sender: Any) {
        let nome = self.tfNome.text
        
        let delegate = UIApplication.shared.delegate as! AppDelegate
        let context = delegate.persistentContainer.viewContext
        
        
        // criando um objeto gerenciado pelo contexto
        let p = NSEntityDescription.insertNewObject(forEntityName: "Pessoa", into: context)
        p.setValue(nome, forKey: "nome")
        
        // salvando o contexto
        delegate.saveContext()
        
        // recuperar os objetos que estão no banco
        
        do{
            let request = NSFetchRequest<NSFetchRequestResult>(entityName: "Pessoa")
            let result = try context.fetch(request)
            if (result.count > 0){
                for r in result as! [NSManagedObject] {
                     print(r.value(forKey: "nome"))
                }
            }
        }catch{
            
        }
        
    }
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }



}

