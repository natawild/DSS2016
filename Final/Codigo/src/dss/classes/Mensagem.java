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
 */
public class Mensagem {
    private String assunto;
    private String mensagem;
    private GregorianCalendar data;

    
    public Mensagem() {
    
        this.assunto="";
        this.mensagem="";
        this.data = new GregorianCalendar();
    }
    
    
    public Mensagem(String assunto, String mensagem, GregorianCalendar data) {
        this.assunto = assunto;
        this.mensagem = mensagem;
        this.data = data;
    }

    
    public Mensagem(Mensagem m ) {
    
        this.assunto=m.getAssunto();
        this.mensagem=m.getMensagem();
        this.data=m.getData();
    }
    
    
    @Override
    public String toString() {
        return "\n Mensagem \n " + "Assunto da mensagem : " + assunto 
                + "\n  mensagem : " + mensagem + 
                "\n ano da mensagem : " +data.get(Calendar.YEAR) +
                "\n mes da mensagem : " +(data.get(Calendar.MONTH)+1) +
                "\n dia da mensagem : " +data.get(Calendar.DAY_OF_MONTH) ;
        
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
        final Mensagem other = (Mensagem) obj;
        if (!Objects.equals(this.assunto, other.assunto)) {
            return false;
        }
        if (!Objects.equals(this.mensagem, other.mensagem)) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        return true;
    }

    @Override
   public Mensagem clone()  {
   
       return new Mensagem(this);
   
   } 
   
    
    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public GregorianCalendar getData() {
        return data;
    }

    public void setData(GregorianCalendar data) {
        this.data = data;
    }
    
    
    
    
    
    
    
    
}
