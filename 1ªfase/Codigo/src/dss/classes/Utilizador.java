/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dss.classes;

import java.util.GregorianCalendar;
import java.util.Objects;

/**
 *
 * @author gil
 */
public abstract class  Utilizador {
    private String nome;
    private String email;
    private String password;
    private float contaCorrente;
    private String nrTelemovel;
    private GregorianCalendar dataNascimento;
    
    public Utilizador() {
        this.nome="";
        this.email = "";
        this.password = "";
        this.dataNascimento = new GregorianCalendar();
        this.nrTelemovel = "";
        this.contaCorrente= -1;
    }

    public Utilizador(String nome, String email, String password, float contaCorrente, String nrTelemovel, GregorianCalendar dataNascimento) {
        this.nome = nome;
        this.email = email;
        this.password = password;
        this.contaCorrente = contaCorrente;
        this.nrTelemovel = nrTelemovel;
        this.dataNascimento = dataNascimento;
    }

     public Utilizador(String nome, String email, String password, String nrTelemovel, GregorianCalendar dataNascimento) {
        this.nome = nome;
        this.email = email;
        this.password = password;
        this.nrTelemovel = nrTelemovel;
        this.dataNascimento = dataNascimento;
        this.contaCorrente=0;
    }
    
    
    
    public Utilizador (Utilizador m ) {
    
        this.nome=m.getNome();
        this.password=m.getPassword();
        this.nrTelemovel=m.getNrTelemovel();
        this.contaCorrente=m.getContaCorrente();
        this.email=m.getEmail();
        this.dataNascimento=m.getDataNascimento();
    }
    
    @Override
    public String toString() {
        return "Nome do morador : " + nome + "\n"
                + " email :  " + email 
                + "\n Dinheiro da conta corrente : " + contaCorrente 
                + "\n Numero de telemovel : " + nrTelemovel 
                + "\n dataNascimento : " + dataNascimento ;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public float getContaCorrente() {
        return contaCorrente;
    }

    public void setContaCorrente(float contaCorrente) {
        this.contaCorrente = contaCorrente;
    }

    public String getNrTelemovel() {
        return nrTelemovel;
    }

    public void setNrTelemovel(String nrTelemovel) {
        this.nrTelemovel = nrTelemovel;
    }

    public GregorianCalendar getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(GregorianCalendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

  
    public void aumentaConta(float dinheiro) {
    
        this.contaCorrente+=dinheiro;
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
        final Utilizador other = (Utilizador ) obj;
        if (Float.floatToIntBits(this.contaCorrente) != Float.floatToIntBits(other.contaCorrente)) {
            return false;
        }
       
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.nrTelemovel, other.nrTelemovel)) {
            return false;
        }
        if (!Objects.equals(this.dataNascimento, other.dataNascimento)) {
            return false;
        }
        return true;
    }
    
    
    

}
