/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operadores;

import com.chtml.code.Operation;
import com.chtml.tag.Parameter;

/**
 *
 * @author camran1234
 */
public interface Compare {
    public Parameter Compare(Operation left, Operation right, int line, int column);
    public boolean Calculate(Parameter left, Parameter right);
}
