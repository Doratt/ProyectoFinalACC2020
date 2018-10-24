/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsi235.exceptions;

/**
 *
 * @author doratt
 */
public class ExceptionMapper extends RuntimeException{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExceptionMapper(String message){
        super(message);
    }
}
