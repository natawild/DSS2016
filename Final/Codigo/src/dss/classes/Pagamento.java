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
    private float valorApagar;
    private float valorPago;

    public Pagamento () {
    
        this.email="";
        this.nome="";
        this.valorApagar=-1;
        this.valorPago=-1;
    
    }
    
    public Pagamento(Pagamento t) {
    
        this.email=t.getEmail();
        this.nome=t.getNome();
        this.valorPago=t.getValor();
        this.valorApagar=t.getValorApagar();
    }
    
    
    

    public Pagamento(String email, String nome, float valor,float valorP) {
        this.email = email;
        this.nome = nome;
        this.valorPago = valor;
        this.valorApagar=valorP;
    }
    
      public Pagamento(String email, String nome,float valorP) {
        this.email = email;
        this.nome = nome;
        this.valorPago = -1;
        this.valorApagar=valorP;
    }

    @Override
    public String toString() {
        return "Pagamento : \n" + "email do morador : " + email 
                + "\n nome do morador : " + nome + 
                "\n valor pago pelo morador :  " + valorPago 
                +"\n valor a pagar pelo morador : " + valorApagar;
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
        if (Float.floatToIntBits(this.valorPago) != Float.floatToIntBits(other.valorPago)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
         if (Float.floatToIntBits(this.valorApagar) != Float.floatToIntBits(other.valorApagar)) {
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
        return valorPago;
    }

    public void setValor(float valor) {
        this.valorPago = valor;
    }
    
    @Override
    public Pagamento clone() {
    
        return new Pagamento(this);
    
    }

    public float getValorApagar() {
        return valorApagar;
    }

    public void setValorApagar(float valorApagar) {
        this.valorApagar = valorApagar;
    }

 
}
