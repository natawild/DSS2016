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
 * @email email do utilizador que deve dinheiro
 * @nome nome do utilizador que deve dinheiro
 * @valor o valor que o utilizador deve 
 * @data data em que contraiu a divida
 */
public class Divida {
    private String email;
    private String nome;
    private float valor;
    private GregorianCalendar data;
    
    
    
    public Divida() {
    
        this.email="";
        this.nome="";
        this.valor=-1;
        this.data=new GregorianCalendar();
        
    }
    
    public Divida (Divida e) {
    
        this.email=e.getEmail();
        this.nome=e.getNome();
        this.valor=e.getValor();
        this.data=e.getData();
    
    }
    
    public Divida(String email, String nome, float valor, GregorianCalendar data) {
        this.email = email;
        this.nome = nome;
        this.valor = valor;
        this.data = data;
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

    public GregorianCalendar getData() {
        return data;
    }

    public void setData(GregorianCalendar data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Emprestimo : " +
                "\n email : " + email +
                "\n nome : " + nome + 
                "\n valor : " + valor + 
                "\n data : " + data + '}';
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
        final Divida other = (Divida) obj;
        if (Float.floatToIntBits(this.valor) != Float.floatToIntBits(other.valor)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        return true;
    }
    
    @Override
    public Divida clone () {
    
        return new Divida(this);
        
    }
    
    
}
