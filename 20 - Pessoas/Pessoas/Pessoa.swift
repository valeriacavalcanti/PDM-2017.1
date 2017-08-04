//
//  Pessoa.swift
//  Pessoas
//
//  Created by admin on 04/08/17.
//  Copyright © 2017 admin. All rights reserved.
//

import Foundation

class Pessoa: NSObject{
    var nome: String!
    var idade: Int!
    
    override var description: String{
        return "\(nome) - \(idade)"
    }
    
    init(nome:String, idade: Int) {
        self.nome = nome
        self.idade = idade
    }

    func maiorIdade() -> Bool {
        return self.idade >= 18
    }
}
