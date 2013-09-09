package org.jsonsmart;

import java.lang.reflect.InvocationTargetException;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * seems that char and Character not supported  = please use String;
 * @author Radu Toader [radu.m.toader@gmail.com]
 */
public class JsonSmartProcessorNullAcceptedTest {
    @Test
    public void testDeserializeObjectMethods() throws IllegalArgumentException, IllegalAccessException, InstantiationException, InvocationTargetException {
    
        String json =
                "{\"floatObjectField\":null,\"integerObjectField\":null,\"doubleObjectField\":null,\"booleanObjectField\":null,\"byteObjectField\":null,\"shortObjectField\":null,\"longObjectField\":null}";
        PlainObjectMethods po = (PlainObjectMethods) JsonSmartProcessor.deserialize( json, PlainObjectMethods.class, false );
        
        Assert.assertEquals( po.getBooleanObjectField( ), null );
        Assert.assertEquals( po.getIntegerObjectField( ), null );
        Assert.assertEquals( po.getFloatObjectField( ), null );
        Assert.assertEquals( po.getShortObjectField( ), null );
        Assert.assertEquals( po.getDoubleObjectField( ), null );
        Assert.assertEquals( po.getByteObjectField( ), null );
    }
    
    @Test
    public void testDeserializePrimitiveMethods() throws IllegalArgumentException, IllegalAccessException, InstantiationException, InvocationTargetException {
    
        String json = "{\"floatField\":null,\"intField\":null,\"doubleField\":null,\"booleanField\":null,\"byteField\":null,\"shortField\":null,\"longField\":null}";
        PlainObjectMethods po = (PlainObjectMethods) JsonSmartProcessor.deserialize( json, PlainObjectMethods.class, false );
        
        Assert.assertEquals( po.getIntField( ), 0 );
        Assert.assertEquals( po.getShortField( ), (short) 0 );
        Assert.assertEquals( po.getLongField( ), 0L );
        Assert.assertEquals( po.getFloatField( ), 0f );
        Assert.assertEquals( po.isBooleanField( ), false );
        Assert.assertEquals( po.getDoubleField( ), 0d );
        Assert.assertEquals( po.getByteField( ), (byte) 0 );
    }
    
    @Test
    public void testDeserializeObjects() throws IllegalArgumentException, IllegalAccessException, InstantiationException, InvocationTargetException {
    
        String json =
                "{\"floatObjectField\":null,\"integerObjectField\":null,\"doubleObjectField\":null,\"booleanObjectField\":null,\"byteObjectField\":null,\"shortObjectField\":null,\"longObjectField\":null}";
        PlainObject po = (PlainObject) JsonSmartProcessor.deserialize( json, PlainObject.class, false );
        
        Assert.assertEquals( po.getBooleanObjectField( ), null );
        Assert.assertEquals( po.getIntegerObjectField( ), null );
        Assert.assertEquals( po.getFloatObjectField( ), null );
        Assert.assertEquals( po.getShortObjectField( ), null );
        Assert.assertEquals( po.getDoubleObjectField( ), null );
        Assert.assertEquals( po.getByteObjectField( ), null );
    }
    
    @Test
    public void testDeserializePrimitives() throws IllegalArgumentException, IllegalAccessException, InstantiationException, InvocationTargetException {
    
        String json = "{\"floatField\":null,\"intField\":null,\"doubleField\":null,\"booleanField\":null,\"byteField\":null,\"shortField\":null,\"longField\":null}";
        PlainObject po = (PlainObject) JsonSmartProcessor.deserialize( json, PlainObject.class, false );
        
        Assert.assertEquals( po.getIntField( ), 0 );
        Assert.assertEquals( po.getShortField( ), (short) 0 );
        Assert.assertEquals( po.getLongField( ), 0L );
        Assert.assertEquals( po.getFloatField( ), 0f );
        Assert.assertEquals( po.isBooleanField( ), false );
        Assert.assertEquals( po.getDoubleField( ), 0d );
        Assert.assertEquals( po.getByteField( ), (byte) 0 );
    }
    
    @Test
    public void testDeserializeNothing() throws IllegalArgumentException, IllegalAccessException, InstantiationException, InvocationTargetException {
    
        String json = "{}";
        PlainObject po = (PlainObject) JsonSmartProcessor.deserialize( json, PlainObject.class, false );
        
        Assert.assertEquals( po.getIntField( ), 0 );
        Assert.assertEquals( po.getShortField( ), (short) 0 );
        Assert.assertEquals( po.getLongField( ), 0L );
        Assert.assertEquals( po.getFloatField( ), 0f );
        Assert.assertEquals( po.isBooleanField( ), false );
        Assert.assertEquals( po.getDoubleField( ), 0d );
        Assert.assertEquals( po.getByteField( ), (byte) 0 );
    }
    
    @Test
    public void testDeserializeNull() throws IllegalArgumentException, IllegalAccessException, InstantiationException, InvocationTargetException {
    
        String json = null;
        PlainObject po = (PlainObject) JsonSmartProcessor.deserialize( json, PlainObject.class, false );
        
        Assert.assertEquals( po, null );
    }
    
    @Test
    public void testDeserializeAndThrowIllegalArgumentExceptionForParametersLenght() throws IllegalArgumentException, IllegalAccessException, InstantiationException, InvocationTargetException {
    
        Exception _e = null;
        String json = "{\"intValue\":12}";
        try {
            PlainObjectMethodsThrow po = (PlainObjectMethodsThrow) JsonSmartProcessor.deserialize( json, PlainObjectMethodsThrow.class, false );
        } catch ( Exception e ) {
            _e = e;
        }
        Assert.assertTrue( _e instanceof IllegalArgumentException );
        Assert.assertTrue( _e.getMessage( ).contains( "params != 1" ) );
    }
}