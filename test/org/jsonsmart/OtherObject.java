package org.jsonsmart;

/**
 * @author Radu Toader [radu.m.toader@gmail.com]
 */
public class OtherObject {
    @JsonSmart
    private String key;
    @JsonSmart
    private String value;
    @JsonSmart
    private int intValue;
    
    public String getKey() {
    
        return key;
    }
    
    public void setKey( String key ) {
    
        this.key = key;
    }
    
    public String getValue() {
    
        return value;
    }
    
    public void setValue( String value ) {
    
        this.value = value;
    }
    
    public int getIntValue() {
    
        return intValue;
    }
    
    public void setIntValue( int intValue ) {
    
        this.intValue = intValue;
    }
    
    @Override
    public String toString() {
    
        StringBuilder builder = new StringBuilder( );
        builder.append( "OtherObject [" );
        if ( key != null ) {
            builder.append( "key=" );
            builder.append( key );
            builder.append( ", " );
        }
        if ( value != null ) {
            builder.append( "value=" );
            builder.append( value );
            builder.append( ", " );
        }
        builder.append( "intValue=" );
        builder.append( intValue );
        builder.append( "]" );
        return builder.toString( );
    }
    
    public OtherObject( String key, String value, int intValue ) {
    
        super( );
        this.key = key;
        this.value = value;
        this.intValue = intValue;
    }
    
    public OtherObject() {
    
    }
    
    @Override
    public int hashCode() {
    
        final int prime = 31;
        int result = 1;
        result = prime * result
                 + intValue;
        result = prime * result
                 + ( ( key == null ) ? 0 : key.hashCode( ) );
        result = prime * result
                 + ( ( value == null ) ? 0 : value.hashCode( ) );
        return result;
    }
    
    @Override
    public boolean equals( Object obj ) {
    
        if ( this == obj )
            return true;
        if ( obj == null )
            return false;
        if ( getClass( ) != obj.getClass( ) )
            return false;
        OtherObject other = (OtherObject) obj;
        if ( intValue != other.intValue )
            return false;
        if ( key == null ) {
            if ( other.key != null )
                return false;
        } else if ( !key.equals( other.key ) )
            return false;
        if ( value == null ) {
            if ( other.value != null )
                return false;
        } else if ( !value.equals( other.value ) )
            return false;
        return true;
    }
    
}
