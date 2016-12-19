/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dss.classes;

import java.util.GregorianCalendar;

/**
 *
 * @author gil
 */
public class Admin extends Morador {
    
    public Admin () {
    
        super();
    
    
    }
    
    public Admin (String nome, String email, String password,float contaCorrente, String nrTelemovel, GregorianCalendar dataNascimento) {
    
        super(nome,email,password,contaCorrente,nrTelemovel,dataNascimento);       
    }
    
    
    public Admin (Admin m) {
    
    super (m.getNome(),m.getEmail(),m.getPassword(),m.getNrTelemovel(),m.getDataNascimento());
    
    }
    
    
    @Override
    public Admin clone() {
    
    
        return new Admin(this);
    }
    
    
    @Override
    public String toString() {
    
       return super.toString();
    
    }
    
    
    
}
