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
        super.init()
    
        let obj = NSKeyedUnarchiver.unarchiveObject(withFile: self.arquivo())
        if (obj != nil){
            self.lista = obj as! Array<Viagem>
        }else{
            self.lista = Array<Viagem>()
        }
        //print(self.arquivo())
    }
    
    func arquivo() -> String{
        let path = NSSearchPathForDirectoriesInDomains(FileManager.SearchPathDirectory.documentDirectory, FileManager.SearchPathDomainMask.userDomainMask, true)[0]
        return "\(path)/viagens.alexandre"
    }
    
    func salvar(){
        NSKeyedArchiver.archiveRootObject(self.lista, toFile: self.arquivo())
    }
    
    func add(nova: Viagem) {
        self.lista.append(nova)
        self.salvar()
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
        self.salvar()
    }
    
    func mov(origem: Int, destino: Int){
        let aux = self.lista[origem]
        self.lista[origem] = self.lista[destino]
        self.lista[destino] = aux
        self.salvar()
    }
}
