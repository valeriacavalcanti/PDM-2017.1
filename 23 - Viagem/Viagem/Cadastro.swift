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
    
    func total() -> Float{
        var acc:Float = 0
        for viagem in self.lista{
            acc += viagem.orcamento
        }
        return acc
    }
    
    func del(index: Int) {
        self.lista.remove(at: index)
    }
    
    func move(origem: Int, destino: Int){
        let aux = self.lista[origem]
        self.lista[origem] = self.lista[destino]
        self.lista[destino] = aux
    }
}
