//
//  Viagem.swift
//  Viagem
//
//  Created by admin on 14/08/17.
//  Copyright © 2017 admin. All rights reserved.
//

import Foundation

class Viagem: NSObject, NSCoding{
    var destino: String!
    var convidados: Int!
    var orcamento: Float!
    var altaTemporada: Bool!
    
    override var description: String{
        return "\(self.destino!) - R$ \(self.porPessoa())"
    }
    
    // memória
    init(destino: String, convidados: Int, orcamento: Float, altaTemporada: Bool) {
        self.destino = destino
        self.convidados = convidados
        self.orcamento = orcamento
        self.altaTemporada = altaTemporada
    }
    
    // arquivo -> memória
    required init?(coder aDecoder: NSCoder) {
        self.destino = aDecoder.decodeObject(forKey: "destino") as! String
        self.convidados = aDecoder.decodeObject(forKey: "convidados") as! Int
        self.orcamento = aDecoder.decodeObject(forKey: "orcamento") as! Float
        self.altaTemporada = aDecoder.decodeObject(forKey: "alta_temporada") as! Bool
    }
    
    // memória -> arquivo
    func encode(with aCoder: NSCoder) {
        aCoder.encode(self.destino, forKey: "destino")
        aCoder.encode(self.convidados, forKey: "convidados")
        aCoder.encode(self.orcamento, forKey: "orcamento")
        aCoder.encode(self.altaTemporada, forKey: "alta_temporada")
    }
    
    func porPessoa() -> Float {
        return self.orcamento / Float(self.convidados + 1)
    }
}
