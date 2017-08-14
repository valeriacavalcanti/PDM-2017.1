//
//  Viagem.swift
//  Viagem
//
//  Created by admin on 14/08/17.
//  Copyright © 2017 admin. All rights reserved.
//

import Foundation

class Viagem: NSObject {
    var destino: String!
    var convidados: Int!
    var orcamento: Float!
    var altaTemporada: Bool!
    
    override var description: String{
        return self.destino
    }
    
    init(destino: String, convidados: Int, orcamento: Float, altaTemporada: Bool) {
        self.destino = destino
        self.convidados = convidados
        self.orcamento = orcamento
        self.altaTemporada = altaTemporada
    }
    
    func porPessoa() -> Float {
        return self.orcamento / Float(self.convidados + 1)
    }
}
