/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dss.exception;

/**
 *
 * @author gil
 */
public class EmailExisteException extends Exception {

   public EmailExisteException() {
       super();
   }
   
   public EmailExisteException(String s) {
       super(s);
    }
    
}