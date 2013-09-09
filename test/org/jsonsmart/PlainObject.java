package org.jsonsmart;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author Radu Toader [radu.m.toader@gmail.com]
 */
public class PlainObject {
    @JsonSmart
    private OtherObject[] arrOtherObjectField;
    @JsonSmart
    private String[] arrStringField;
    @JsonSmart
    private boolean booleanField;
    @JsonSmart
    private Boolean booleanObjectField;
    @JsonSmart
    private byte byteField;
    @JsonSmart
    private Byte byteObjectField;
    @JsonSmart
    private Character characerObjectField;
    @JsonSmart
    private char charField;
    @JsonSmart
    private double doubleField;
    @JsonSmart
    private Double doubleObjectField;
    @JsonSmart
    private float floatField;
    
    @JsonSmart
    private Float floatObjectField;
    
    @JsonSmart
    private Integer integerObjectField;
    @JsonSmart
    private int intField;
    @JsonSmart( classType = OtherObject.class )
    private List<OtherObject> listOtherObjectField;
    @JsonSmart( classType = String.class )
    private List<String> listStringField;
    @JsonSmart
    private long longField;
    @JsonSmart
    private Long longObjectField;
    @JsonSmart( classType = OtherObject.class )
    private Map<String, OtherObject> mapStringToOtherObjectField;
    @JsonSmart( classType = String.class )
    private Map<String, String> mapStringToStringField;
    @JsonSmart
    private OtherObject otherObjectField;
    @JsonSmart
    private short shortField;
    @JsonSmart
    private Short shortObjectField;
    @JsonSmart
    private String stringField;
    
    public OtherObject[] getArrOtherObjectField() {
    
        return arrOtherObjectField;
    }
    
    public String[] getArrStringField() {
    
        return arrStringField;
    }
    
    public Boolean getBooleanObjectField() {
    
        return booleanObjectField;
    }
    
    public byte getByteField() {
    
        return byteField;
    }
    
    public Byte getByteObjectField() {
    
        return byteObjectField;
    }
    
    public Character getCharacerObjectField() {
    
        return characerObjectField;
    }
    
    public char getCharField() {
    
        return charField;
    }
    
    public double getDoubleField() {
    
        return doubleField;
    }
    
    public Double getDoubleObjectField() {
    
        return doubleObjectField;
    }
    
    public float getFloatField() {
    
        return floatField;
    }
    
    public Float getFloatObjectField() {
    
        return floatObjectField;
    }
    
    public Integer getIntegerObjectField() {
    
        return integerObjectField;
    }
    
    public int getIntField() {
    
        return intField;
    }
    
    public List<OtherObject> getListOtherObjectField() {
    
        return listOtherObjectField;
    }
    
    public List<String> getListStringField() {
    
        return listStringField;
    }
    
    public long getLongField() {
    
        return longField;
    }
    
    public Long getLongObjectField() {
    
        return longObjectField;
    }
    
    public Map<String, OtherObject> getMapStringToOtherObjectField() {
    
        return mapStringToOtherObjectField;
    }
    
    public Map<String, String> getMapStringToStringField() {
    
        return mapStringToStringField;
    }
    
    public OtherObject getOtherObjectField() {
    
        return otherObjectField;
    }
    
    public short getShortField() {
    
        return shortField;
    }
    
    public Short getShortObjectField() {
    
        return shortObjectField;
    }
    
    public String getStringField() {
    
        return stringField;
    }
    
    public boolean isBooleanField() {
    
        return booleanField;
    }
    
    public void setArrOtherObjectField( OtherObject[] arrOtherObjectField ) {
    
        this.arrOtherObjectField = arrOtherObjectField;
    }
    
    public void setArrStringField( String[] arrStringField ) {
    
        this.arrStringField = arrStringField;
    }
    
    public void setBooleanField( boolean booleanField ) {
    
        this.booleanField = booleanField;
    }
    
    public void setBooleanObjectField( Boolean booleanObjectField ) {
    
        this.booleanObjectField = booleanObjectField;
    }
    
    public void setByteField( byte byteField ) {
    
        this.byteField = byteField;
    }
    
    public void setByteObjectField( Byte byteObjectField ) {
    
        this.byteObjectField = byteObjectField;
    }
    
    public void setCharacerObjectField( Character characerObjectField ) {
    
        this.characerObjectField = characerObjectField;
    }
    
    public void setCharField( char charField ) {
    
        this.charField = charField;
    }
    
    public void setDoubleField( double doubleField ) {
    
        this.doubleField = doubleField;
    }
    
    public void setDoubleObjectField( Double doubleObjectField ) {
    
        this.doubleObjectField = doubleObjectField;
    }
    
    public void setFloatField( float floatField ) {
    
        this.floatField = floatField;
    }
    
    public void setFloatObjectField( Float floatObjectField ) {
    
        this.floatObjectField = floatObjectField;
    }
    
    public void setIntegerObjectField( Integer intergerObjectField ) {
    
        integerObjectField = intergerObjectField;
    }
    
    public void setIntField( int intField ) {
    
        this.intField = intField;
    }
    
    public void setListOtherObjectField( List<OtherObject> listOtherObjectField ) {
    
        this.listOtherObjectField = listOtherObjectField;
    }
    
    public void setListStringField( List<String> listStringField ) {
    
        this.listStringField = listStringField;
    }
    
    public void setLongField( long longField ) {
    
        this.longField = longField;
    }
    
    public void setLongObjectField( Long longObjectField ) {
    
        this.longObjectField = longObjectField;
    }
    
    public void setMapStringToOtherObjectField( Map<String, OtherObject> mapStringToOtherObjectField ) {
    
        this.mapStringToOtherObjectField = mapStringToOtherObjectField;
    }
    
    public void setMapStringToStringField( Map<String, String> mapStringToStringField ) {
    
        this.mapStringToStringField = mapStringToStringField;
    }
    
    public void setOtherObjectField( OtherObject otherObjectField ) {
    
        this.otherObjectField = otherObjectField;
    }
    
    public void setShortField( short shortField ) {
    
        this.shortField = shortField;
    }
    
    public void setShortObjectField( Short shortObjectField ) {
    
        this.shortObjectField = shortObjectField;
    }
    
    public void setStringField( String stringField ) {
    
        this.stringField = stringField;
    }
    
    @Override
    public String toString() {
    
        StringBuilder builder = new StringBuilder( );
        builder.append( "PlainObject [" );
        if ( arrOtherObjectField != null ) {
            builder.append( "arrOtherObjectField=" );
            builder.append( Arrays.toString( arrOtherObjectField ) );
            builder.append( ", " );
        }
        if ( arrStringField != null ) {
            builder.append( "arrStringField=" );
            builder.append( Arrays.toString( arrStringField ) );
            builder.append( ", " );
        }
        builder.append( "booleanField=" );
        builder.append( booleanField );
        builder.append( ", " );
        if ( booleanObjectField != null ) {
            builder.append( "booleanObjectField=" );
            builder.append( booleanObjectField );
            builder.append( ", " );
        }
        builder.append( "byteField=" );
        builder.append( byteField );
        builder.append( ", longField=" );
        builder.append( longField );
        builder.append( ", " );
        if ( longObjectField != null ) {
            builder.append( "longObjectField=" );
            builder.append( longObjectField );
            builder.append( ", " );
        }
        builder.append( "shortField=" );
        builder.append( shortField );
        builder.append( ", " );
        if ( shortObjectField != null ) {
            builder.append( "shortObjectField=" );
            builder.append( shortObjectField );
            builder.append( ", " );
        }
        if ( byteObjectField != null ) {
            builder.append( "byteObjectField=" );
            builder.append( byteObjectField );
            builder.append( ", " );
        }
        if ( characerObjectField != null ) {
            builder.append( "characerObjectField=" );
            builder.append( characerObjectField );
            builder.append( ", " );
        }
        builder.append( "charField=" );
        builder.append( charField );
        builder.append( ", doubleField=" );
        builder.append( doubleField );
        builder.append( ", " );
        if ( doubleObjectField != null ) {
            builder.append( "doubleObjectField=" );
            builder.append( doubleObjectField );
            builder.append( ", " );
        }
        builder.append( "floatField=" );
        builder.append( floatField );
        builder.append( ", " );
        if ( floatObjectField != null ) {
            builder.append( "floatObjectField=" );
            builder.append( floatObjectField );
            builder.append( ", " );
        }
        if ( integerObjectField != null ) {
            builder.append( "integerObjectField=" );
            builder.append( integerObjectField );
            builder.append( ", " );
        }
        builder.append( "intField=" );
        builder.append( intField );
        builder.append( ", " );
        if ( listOtherObjectField != null ) {
            builder.append( "listOtherObjectField=" );
            builder.append( listOtherObjectField );
            builder.append( ", " );
        }
        if ( listStringField != null ) {
            builder.append( "listStringField=" );
            builder.append( listStringField );
            builder.append( ", " );
        }
        if ( mapStringToOtherObjectField != null ) {
            builder.append( "mapStringToOtherObjectField=" );
            builder.append( mapStringToOtherObjectField );
            builder.append( ", " );
        }
        if ( mapStringToStringField != null ) {
            builder.append( "mapStringToStringField=" );
            builder.append( mapStringToStringField );
            builder.append( ", " );
        }
        if ( otherObjectField != null ) {
            builder.append( "otherObjectField=" );
            builder.append( otherObjectField );
            builder.append( ", " );
        }
        if ( stringField != null ) {
            builder.append( "stringField=" );
            builder.append( stringField );
        }
        builder.append( "]" );
        return builder.toString( );
    }
    
}
