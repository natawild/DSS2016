/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dss.classes;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author gil
 */
public class Morador extends Utilizador{
    private List<Mensagem> mensagemAdmin;

    
    public Morador () {
    
        super();
        this.mensagemAdmin = new ArrayList<>();
    }
    
    public Morador(String nome, String email, String password,float contaCorrente, String nrTelemovel, GregorianCalendar dataNascimento) {
    
        super(nome,email,password,contaCorrente,nrTelemovel,dataNascimento);
        this.mensagemAdmin = new ArrayList<>();
    }
    
    
    public Morador (Morador m) {
    
        super (m.getNome(),m.getEmail(),m.getPassword(),m.getNrTelemovel(),m.getDataNascimento());
        this.mensagemAdmin=m.getMensagemAdmin();
    }
    
    
    public String imprimeMensagens() {
     StringBuilder s = new StringBuilder();
     
        
        
    return s.toString();
    }
    
    
    @Override
    public Morador clone() {
    
        return new Morador(this);
    }
    
    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        if(!super.equals(obj)) {
           return false;
        }
        final Morador other = (Morador) obj;
        if (!Objects.equals(this.mensagemAdmin, other.mensagemAdmin)) {
            return false;
        }
        
        return true;
    }
    
    public List<Mensagem> getMensagemAdmin() {
        return mensagemAdmin;
    }

    public void setMensagemAdmin(List<Mensagem> mensagemAdmin) {
        this.mensagemAdmin = mensagemAdmin;
    }
    
    
    
    
    
    
    
    
}
