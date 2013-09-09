package org.jsonsmart;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author Radu Toader [radu.m.toader@gmail.com]
 */
public class PlainObjectMethods {
    private OtherObjectMethods[] arrOtherObjectField;
    private String[] arrStringField;
    private boolean booleanField;
    private Boolean booleanObjectField;
    private byte byteField;
    private Byte byteObjectField;
    private Character characerObjectField;
    private char charField;
    private double doubleField;
    private Double doubleObjectField;
    private float floatField;
    private Float floatObjectField;
    private Integer integerObjectField;
    private int intField;
    private List<OtherObjectMethods> listOtherObjectField;
    private List<String> listStringField;
    private long longField;
    private Long longObjectField;
    private Map<String, OtherObjectMethods> mapStringToOtherObjectField;
    private Map<String, String> mapStringToStringField;
    private OtherObjectMethods otherObjectField;
    private short shortField;
    private Short shortObjectField;
    private String stringField;
    
    @JsonSmart( type = JsonSmartSerializationType.SERIALIZATION, name = "arrOtherObjectField" )
    public OtherObjectMethods[] getArrOtherObjectField() {
    
        return arrOtherObjectField;
    }
    
    @JsonSmart( type = JsonSmartSerializationType.SERIALIZATION, name = "arrStringField" )
    public String[] getArrStringField() {
    
        return arrStringField;
    }
    
    @JsonSmart( type = JsonSmartSerializationType.SERIALIZATION, name = "booleanObjectField" )
    public Boolean getBooleanObjectField() {
    
        return booleanObjectField;
    }
    
    @JsonSmart( type = JsonSmartSerializationType.SERIALIZATION, name = "byteField" )
    public byte getByteField() {
    
        return byteField;
    }
    
    @JsonSmart( type = JsonSmartSerializationType.SERIALIZATION, name = "byteObjectField" )
    public Byte getByteObjectField() {
    
        return byteObjectField;
    }
    
    @JsonSmart( type = JsonSmartSerializationType.SERIALIZATION, name = "characterObjectField" )
    public Character getCharacerObjectField() {
    
        return characerObjectField;
    }
    
    @JsonSmart( type = JsonSmartSerializationType.SERIALIZATION, name = "charField" )
    public char getCharField() {
    
        return charField;
    }
    
    @JsonSmart( type = JsonSmartSerializationType.SERIALIZATION, name = "doubleField" )
    public double getDoubleField() {
    
        return doubleField;
    }
    
    @JsonSmart( type = JsonSmartSerializationType.SERIALIZATION, name = "doubleObjectField" )
    public Double getDoubleObjectField() {
    
        return doubleObjectField;
    }
    
    @JsonSmart( type = JsonSmartSerializationType.SERIALIZATION, name = "floatField" )
    public float getFloatField() {
    
        return floatField;
    }
    
    @JsonSmart( type = JsonSmartSerializationType.SERIALIZATION, name = "floatObjectField" )
    public Float getFloatObjectField() {
    
        return floatObjectField;
    }
    
    @JsonSmart( type = JsonSmartSerializationType.SERIALIZATION, name = "integerObjectField" )
    public Integer getIntegerObjectField() {
    
        return integerObjectField;
    }
    
    @JsonSmart( type = JsonSmartSerializationType.SERIALIZATION, name = "intField" )
    public int getIntField() {
    
        return intField;
    }
    
    @JsonSmart( type = JsonSmartSerializationType.SERIALIZATION, classType = OtherObjectMethods.class, name = "listOtherObjectField" )
    public List<OtherObjectMethods> getListOtherObjectField() {
    
        return listOtherObjectField;
    }
    
    @JsonSmart( type = JsonSmartSerializationType.SERIALIZATION, name = "listStringField" )
    public List<String> getListStringField() {
    
        return listStringField;
    }
    
    @JsonSmart( type = JsonSmartSerializationType.SERIALIZATION, name = "longField" )
    public long getLongField() {
    
        return longField;
    }
    
    @JsonSmart( type = JsonSmartSerializationType.SERIALIZATION, name = "longObjectField" )
    public Long getLongObjectField() {
    
        return longObjectField;
    }
    
    @JsonSmart( type = JsonSmartSerializationType.SERIALIZATION, name = "mapStringToOtherObjectField" )
    public Map<String, OtherObjectMethods> getMapStringToOtherObjectField() {
    
        return mapStringToOtherObjectField;
    }
    
    @JsonSmart( type = JsonSmartSerializationType.SERIALIZATION, name = "mapStringToStringField" )
    public Map<String, String> getMapStringToStringField() {
    
        return mapStringToStringField;
    }
    
    @JsonSmart( type = JsonSmartSerializationType.SERIALIZATION, name = "otherObjectField" )
    public OtherObjectMethods getOtherObjectField() {
    
        return otherObjectField;
    }
    
    @JsonSmart( type = JsonSmartSerializationType.SERIALIZATION, name = "shortField" )
    public short getShortField() {
    
        return shortField;
    }
    
    @JsonSmart( type = JsonSmartSerializationType.SERIALIZATION, name = "shortObjectField" )
    public Short getShortObjectField() {
    
        return shortObjectField;
    }
    
    @JsonSmart( type = JsonSmartSerializationType.SERIALIZATION, name = "stringField" )
    public String getStringField() {
    
        return stringField;
    }
    
    @JsonSmart( type = JsonSmartSerializationType.SERIALIZATION, name = "booleanField" )
    public boolean isBooleanField() {
    
        return booleanField;
    }
    
    @JsonSmart( type = JsonSmartSerializationType.DESERIALIZATION, name = "arrOtherObjectField" )
    public void setArrOtherObjectMethodsField( OtherObjectMethods[] arrOtherObjectMethodsField ) {
    
        arrOtherObjectField = arrOtherObjectMethodsField;
    }
    
    @JsonSmart( type = JsonSmartSerializationType.DESERIALIZATION, name = "arrStringField" )
    public void setArrStringField( String[] arrStringField ) {
    
        this.arrStringField = arrStringField;
    }
    
    @JsonSmart( type = JsonSmartSerializationType.DESERIALIZATION, name = "booleanField" )
    public void setBooleanField( boolean booleanField ) {
    
        this.booleanField = booleanField;
    }
    
    @JsonSmart( type = JsonSmartSerializationType.DESERIALIZATION, name = "booleanObjectField" )
    public void setBooleanObjectField( Boolean booleanObjectField ) {
    
        this.booleanObjectField = booleanObjectField;
    }
    
    @JsonSmart( type = JsonSmartSerializationType.DESERIALIZATION, name = "byteField" )
    public void setByteField( byte byteField ) {
    
        this.byteField = byteField;
    }
    
    @JsonSmart( type = JsonSmartSerializationType.DESERIALIZATION, name = "byteObjectField" )
    public void setByteObjectField( Byte byteObjectField ) {
    
        this.byteObjectField = byteObjectField;
    }
    
    @JsonSmart( type = JsonSmartSerializationType.DESERIALIZATION, name = "characterObjectField" )
    public void setCharacerObjectField( Character characerObjectField ) {
    
        this.characerObjectField = characerObjectField;
    }
    
    @JsonSmart( type = JsonSmartSerializationType.DESERIALIZATION, name = "charField" )
    public void setCharField( char charField ) {
    
        this.charField = charField;
    }
    
    @JsonSmart( type = JsonSmartSerializationType.DESERIALIZATION, name = "doubleField" )
    public void setDoubleField( double doubleField ) {
    
        this.doubleField = doubleField;
    }
    
    @JsonSmart( type = JsonSmartSerializationType.DESERIALIZATION, name = "doubleObjectField" )
    public void setDoubleObjectField( Double doubleObjectField ) {
    
        this.doubleObjectField = doubleObjectField;
    }
    
    @JsonSmart( type = JsonSmartSerializationType.DESERIALIZATION, name = "floatField" )
    public void setFloatField( float floatField ) {
    
        this.floatField = floatField;
    }
    
    @JsonSmart( type = JsonSmartSerializationType.DESERIALIZATION, name = "floatObjectField" )
    public void setFloatObjectField( Float floatObjectField ) {
    
        this.floatObjectField = floatObjectField;
    }
    
    @JsonSmart( type = JsonSmartSerializationType.DESERIALIZATION, name = "integerObjectField" )
    public void setIntegerObjectField( Integer intergerObjectField ) {
    
        integerObjectField = intergerObjectField;
    }
    
    @JsonSmart( type = JsonSmartSerializationType.DESERIALIZATION, name = "intField" )
    public void setIntField( int intField ) {
    
        this.intField = intField;
    }
    
    @JsonSmart( type = JsonSmartSerializationType.DESERIALIZATION, classType = OtherObjectMethods.class, name = "listOtherObjectField" )
    public void setListOtherObjectMethodsField( List<OtherObjectMethods> listOtherObjectMethodsField ) {
    
        listOtherObjectField = listOtherObjectMethodsField;
    }
    
    @JsonSmart( type = JsonSmartSerializationType.DESERIALIZATION, classType = String.class, name = "listStringField" )
    public void setListStringField( List<String> listStringField ) {
    
        this.listStringField = listStringField;
    }
    
    @JsonSmart( type = JsonSmartSerializationType.DESERIALIZATION, name = "longField" )
    public void setLongField( long longField ) {
    
        this.longField = longField;
    }
    
    @JsonSmart( type = JsonSmartSerializationType.DESERIALIZATION, name = "longObjectField" )
    public void setLongObjectField( Long longObjectField ) {
    
        this.longObjectField = longObjectField;
    }
    
    @JsonSmart( type = JsonSmartSerializationType.DESERIALIZATION, classType = OtherObjectMethods.class, name = "mapStringToOtherObjectField" )
    public void setMapStringToOtherObjectMethodsField( Map<String, OtherObjectMethods> mapStringToOtherObjectMethodsField ) {
    
        mapStringToOtherObjectField = mapStringToOtherObjectMethodsField;
    }
    
    @JsonSmart( type = JsonSmartSerializationType.DESERIALIZATION, classType = String.class, name = "mapStringToStringField" )
    public void setMapStringToStringField( Map<String, String> mapStringToStringField ) {
    
        this.mapStringToStringField = mapStringToStringField;
    }
    
    @JsonSmart( type = JsonSmartSerializationType.DESERIALIZATION, name = "otherObjectField" )
    public void setOtherObjectMethodsField( OtherObjectMethods otherObjectField ) {
    
        this.otherObjectField = otherObjectField;
    }
    
    @JsonSmart( type = JsonSmartSerializationType.DESERIALIZATION, name = "shortField" )
    public void setShortField( short shortField ) {
    
        this.shortField = shortField;
    }
    
    @JsonSmart( type = JsonSmartSerializationType.DESERIALIZATION, name = "shortObjectField" )
    public void setShortObjectField( Short shortObjectField ) {
    
        this.shortObjectField = shortObjectField;
    }
    
    @JsonSmart( type = JsonSmartSerializationType.DESERIALIZATION, name = "stringField" )
    public void setStringField( String stringField ) {
    
        this.stringField = stringField;
    }
    
    @Override
    public String toString() {
    
        StringBuilder builder = new StringBuilder( );
        builder.append( "PlainObject [" );
        if ( arrOtherObjectField != null ) {
            builder.append( "arrOtherObjectMethodsField=" );
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
            builder.append( "listOtherObjectMethodsField=" );
            builder.append( listOtherObjectField );
            builder.append( ", " );
        }
        if ( listStringField != null ) {
            builder.append( "listStringField=" );
            builder.append( listStringField );
            builder.append( ", " );
        }
        if ( mapStringToOtherObjectField != null ) {
            builder.append( "mapStringToOtherObjectMethodsField=" );
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
