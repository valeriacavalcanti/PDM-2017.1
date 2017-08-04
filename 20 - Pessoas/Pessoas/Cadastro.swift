//
//  Cadastro.swift
//  Pessoas
//
//  Created by admin on 04/08/17.
//  Copyright © 2017 admin. All rights reserved.
//

import Foundation

class Cadastro{
    var lista: Array<Pessoa>!
    
    init() {
        self.lista = Array<Pessoa>()
    }
    
    func add(nova: Pessoa) {
        self.lista.append(nova)
    }
    
    func quantidade() -> Int {
        return self.lista.count
    }
}
