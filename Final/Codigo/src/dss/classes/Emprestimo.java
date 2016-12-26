/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dss.classes;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;

/**
 *
 * @author gil
 * @email email do utilizador que emprestou dinheiro
 * @nome nome do utilizador que emprestou dinheiro
 * @valor o valor que o utilizador emprestou
 * @data data em que emprestou o dinheiro
 */
public class Emprestimo {
    
    private String email;
    private String nome;
    private float valor;
    private GregorianCalendar data;
    private int idEmprestimo;

    
    public Emprestimo() {
    
        this.email="";
        this.nome="";
        this.valor=-1;
        this.data=new GregorianCalendar();
        this.idEmprestimo=-1;
    }
    
    public Emprestimo (Emprestimo e) {
    
        this.email=e.getEmail();
        this.nome=e.getNome();
        this.valor=e.getValor();
        this.data=e.getData();
        this.idEmprestimo=e.getIdEmprestimo();
    
    }
    
    public Emprestimo(String email, String nome, float valor, GregorianCalendar data) {
        this.email = email;
        this.nome = nome;
        this.valor = valor;
        this.data = data;
    }

    public Emprestimo(int idEmprestimo,String email, String nome, float valor, GregorianCalendar data) {
        this.email = email;
        this.nome = nome;
        this.valor = valor;
        this.data = data;
        this.idEmprestimo=idEmprestimo;
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
                "\n Data  do emprestimo : " +data.get(Calendar.YEAR) +
                " - " +(data.get(Calendar.MONTH)+1) +
                " - " +data.get(Calendar.DAY_OF_MONTH);
    }
    
     public String imprimeEmprestimo() {
        return "Emprestimo : " +
                "\n identificador emprestimo : " + this.idEmprestimo+
                "\n email : " + email +
                "\n nome : " + nome + 
                "\n valor : " + valor + 
                "\n Data  do emprestimo : " +data.get(Calendar.YEAR) +
                " - " +(data.get(Calendar.MONTH)+1) +
                " - " +data.get(Calendar.DAY_OF_MONTH);
               
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
        final Emprestimo other = (Emprestimo) obj;
        if (Float.floatToIntBits(this.valor) != Float.floatToIntBits(other.valor)) {
            return false;
        }
        if (!Objects.equals(this.idEmprestimo, other.idEmprestimo)) {
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
    public Emprestimo clone () {
    
        return new Emprestimo(this);
        
    }

    public int getIdEmprestimo() {
        return idEmprestimo;
    }

    public void setIdEmprestimo(int idEmprestimo) {
        this.idEmprestimo = idEmprestimo;
    }
    
    
    
}
