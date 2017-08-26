//
//  PessoaTableViewCell.swift
//  Agenda
//
//  Created by admin on 26/08/17.
//  Copyright © 2017 admin. All rights reserved.
//

import UIKit

class PessoaTableViewCell: UITableViewCell {

    @IBOutlet weak var lbNome: UILabel!
    @IBOutlet weak var lbIdade: UILabel!
    
    
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
    }

    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }

}
