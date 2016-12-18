/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dss.classes;

import java.util.Objects;

/**
 *
 * @author gil
 */
public class Pagamento {
    private String email;
    private String nome;
    private float valor;

    public Pagamento () {
    
        this.email="";
        this.nome="";
        this.valor=-1;
    
    }
    
    public Pagamento(Pagamento t) {
    
        this.email=t.getEmail();
        this.nome=t.getNome();
        this.valor=t.getValor();
    }
    
    
    

    public Pagamento(String email, String nome, float valor) {
        this.email = email;
        this.nome = nome;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Pagamento : \n" + "email do morador : " + email 
                + "\n nome do morador : " + nome + 
                "\n valor pago pelo morador :  " + valor ;
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
        final Pagamento other = (Pagamento) obj;
        if (Float.floatToIntBits(this.valor) != Float.floatToIntBits(other.valor)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
    
    @Override
    public Pagamento clone() {
    
        return new Pagamento(this);
    
    }
    
    
    
    
    
    
    
    
}
