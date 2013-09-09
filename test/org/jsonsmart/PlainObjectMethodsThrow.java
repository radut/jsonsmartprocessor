package org.jsonsmart;

/**
 * @author Radu Toader [radu.m.toader@gmail.com]
 */
public class PlainObjectMethodsThrow {
    private int intField;
    
    public int getIntField() {
    
        return intField;
    }
    
    @JsonSmart( name = "intValue" )
    public void setIntField( int intField, int value ) {
    
        this.intField = intField;
    }
    
}
