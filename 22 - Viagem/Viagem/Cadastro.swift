//
//  Cadastro.swift
//  Viagem
//
//  Created by admin on 14/08/17.
//  Copyright © 2017 admin. All rights reserved.
//

import Foundation

class Cadastro: NSObject{
    var lista: Array<Viagem>!
    
    override init() {
        self.lista = Array<Viagem>()
    }
    
    func add(nova: Viagem) {
        self.lista.append(nova)
    }
    
    func get(index: Int) -> Viagem {
        return self.lista[index]
    }
    
    func size() -> Int{
        return self.lista.count
    }
}
