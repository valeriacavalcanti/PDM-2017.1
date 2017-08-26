//
//  PessoaDAO.swift
//  Agenda
//
//  Created by admin on 26/08/17.
//  Copyright © 2017 admin. All rights reserved.
//

import Foundation
import CoreData
import UIKit

class PessoaDAO: NSObject{
    var delegate: AppDelegate!
    
    override init() {
        super.init()
        
        self.delegate = UIApplication.shared.delegate as! AppDelegate
    }
    
    func insert(nome: String, idade: Int) {
        let context = self.delegate.persistentContainer.viewContext
        let p = NSEntityDescription.insertNewObject(forEntityName: "Pessoa", into: context)
        p.setValue(nome, forKey: "nome")
        p.setValue(idade, forKey: "idade")
        self.delegate.saveContext()
    }
    
    func get() -> Array<Pessoa>{
        let request = NSFetchRequest<NSFetchRequestResult>(entityName: "Pessoa")
        request.returnsObjectsAsFaults = false
        var lista = Array<Pessoa>()
        
        let context = self.delegate.persistentContainer.viewContext
        do{
            let result = try context.fetch(request)
            if (result.count > 0){
                for r in result as! [NSManagedObject]{
                    lista.append(r as! Pessoa)
                }
            }
        }catch{
            
        }
        return lista
    }
    
    func del(p: Pessoa){
        self.delegate.persistentContainer.viewContext.delete(p)
        self.delegate.saveContext()
    }
}
