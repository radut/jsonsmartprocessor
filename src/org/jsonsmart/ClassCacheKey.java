package org.jsonsmart;

/**
 * @author Radu Toader [radu.m.toader@gmail.com]
 */
public class ClassCacheKey {
    private String key;
    private JsonSmartSerializationType type;
    
    public String getKey() {
    
        return key;
    }
    
    public void setKey( String key ) {
    
        this.key = key;
    }
    
    public JsonSmartSerializationType getType() {
    
        return type;
    }
    
    public void setType( JsonSmartSerializationType type ) {
    
        this.type = type;
    }
    
    public ClassCacheKey() {
    
        super( );
    }
    
    public ClassCacheKey( String key, JsonSmartSerializationType type ) {
    
        super( );
        this.key = key;
        this.type = type;
    }
    
    @Override
    public int hashCode() {
    
        final int prime = 31;
        int result = 1;
        result = prime * result
                 + ( ( key == null ) ? 0 : key.hashCode( ) );
        result = prime * result
                 + ( ( type == null ) ? 0 : type.hashCode( ) );
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
        ClassCacheKey other = (ClassCacheKey) obj;
        if ( key == null ) {
            if ( other.key != null )
                return false;
        } else if ( !key.equals( other.key ) )
            return false;
        if ( type != other.type )
            return false;
        return true;
    }
    
}
