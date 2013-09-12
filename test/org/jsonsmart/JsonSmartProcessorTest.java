package org.jsonsmart;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import net.minidev.json.JSONObject;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * seems that char and Character not supported  = please use String;
 * @author Radu Toader [radu.m.toader@gmail.com]
 */
public class JsonSmartProcessorTest {
    @Test
    public void testDeserializeObjects() throws IllegalArgumentException, IllegalAccessException, InstantiationException, InvocationTargetException {
    
        String json =
                "{\"floatObjectField\":30.0,\"integerObjectField\":12,\"doubleObjectField\":3.0,\"booleanObjectField\":true,\"byteObjectField\":32,\"shortObjectField\":21,\"longObjectField\":323}";
        PlainObject po = (PlainObject) JsonSmartProcessor.deserialize( json, PlainObject.class, false );
        
        Assert.assertEquals( po.getBooleanObjectField( ), Boolean.TRUE );
        Assert.assertEquals( po.getIntegerObjectField( ), new Integer( 12 ) );
        Assert.assertEquals( po.getFloatObjectField( ), 30f );
        Assert.assertEquals( po.getDoubleObjectField( ), 3d );
        Assert.assertEquals( po.getByteObjectField( ), new Byte( new Integer( 32 ).byteValue( ) ) );
    }
    
    @Test
    public void testDeserializePrimitives() throws IllegalArgumentException, IllegalAccessException, InstantiationException, InvocationTargetException {
    
        String json = "{\"floatField\":30.0,\"intField\":12,\"doubleField\":3.0,\"booleanField\":true,\"byteField\":32,\"shortField\":21,\"longField\":323}";
        PlainObject po = (PlainObject) JsonSmartProcessor.deserialize( json, PlainObject.class, false );
        Assert.assertEquals( po.isBooleanField( ), true );
        
        Assert.assertEquals( po.getIntField( ), 12 );
        Assert.assertEquals( po.getShortField( ), (short) 21 );
        Assert.assertEquals( po.getLongField( ), 323L );
        Assert.assertEquals( po.getFloatField( ), 30f );
        Assert.assertEquals( po.getDoubleField( ), 3d );
        Assert.assertEquals( po.getByteField( ), (byte) 32 );
    }
    
    @Test
    public void testEncodingObjectsToJsonObject() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    
        PlainObject po = new PlainObject( );
        setObjectsValues( po );
        String jsonString = JsonSmartProcessor.serializeToJSONString( po, true );
        Assert.assertTrue( jsonString.contains( "integerObjectField\":12" ) );
        Assert.assertTrue( jsonString.contains( "shortObjectField\":21" ) );
        Assert.assertTrue( jsonString.contains( "longObjectField\":323" ) );
        Assert.assertTrue( jsonString.contains( "booleanObjectField\":true" ) );
        Assert.assertTrue( jsonString.contains( "doubleObjectField\":3.0" ) );
        Assert.assertTrue( jsonString.contains( "floatObjectField\":30.0" ) );
        Assert.assertTrue( jsonString.contains( "byteObjectField\":32" ) );
        //        Assert.assertTrue( jsonString.contains( "charField\":\"c\"" ) );
    }
    
    @Test
    public void testEncodingPrimitivesToJsonOBJECT() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    
        PlainObject po = new PlainObject( );
        setPrimiteValues( po );
        
        JSONObject jsonObject = JsonSmartProcessor.serializeToJSONObject( po, true );
        
        String jsonString = jsonObject.toJSONString( );
        
        Assert.assertEquals( jsonObject.get( "booleanField" ), true );
        Assert.assertEquals( jsonObject.get( "intField" ), 12 );
        Assert.assertEquals( jsonObject.get( "shortField" ), (short) 21 );
        Assert.assertEquals( jsonObject.get( "longField" ), 323L );
        Assert.assertEquals( jsonObject.get( "floatField" ), 30f );
        Assert.assertEquals( jsonObject.get( "doubleField" ), 3d );
        Assert.assertEquals( jsonObject.get( "byteField" ), (byte) 32 );
        Assert.assertEquals( jsonObject.get( "charField" ), 'c' );
        System.out.println( jsonString );
    }
    
    @Test
    public void testEncodingPrimitivesToJsonString() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    
        PlainObject po = new PlainObject( );
        setPrimiteValues( po );
        String jsonString = JsonSmartProcessor.serializeToJSONString( po, false );
        Assert.assertTrue( jsonString.contains( "intField\":12" ) );
        Assert.assertTrue( jsonString.contains( "shortField\":21" ) );
        Assert.assertTrue( jsonString.contains( "longField\":323" ) );
        Assert.assertTrue( jsonString.contains( "booleanField\":true" ) );
        Assert.assertTrue( jsonString.contains( "doubleField\":3.0" ) );
        Assert.assertTrue( jsonString.contains( "floatField\":30.0" ) );
        Assert.assertTrue( jsonString.contains( "byteField\":32" ) );
        //        Assert.assertTrue( jsonString.contains( "charField\":\"c\"" ) );
    }
    
    private void setObjectsValues( PlainObject po ) {
    
        po.setIntegerObjectField( 12 );
        po.setCharacerObjectField( 'c' );
        po.setShortObjectField( (short) 21 );
        po.setLongObjectField( 323L );
        po.setDoubleObjectField( 3d );
        po.setFloatObjectField( 30f );
        po.setByteObjectField( (byte) 32 );
        po.setBooleanObjectField( true );
        
    }
    
    private void setPrimiteValues( PlainObject po ) {
    
        po.setBooleanField( true );
        po.setShortField( (short) 21 );
        po.setByteField( (byte) 32 );
        po.setIntField( 12 );
        po.setCharField( 'c' );
        po.setDoubleField( 3d );
        po.setLongField( 323L );
        po.setFloatField( 30f );
    }
    
    @Test
    public void testEncodingListString() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    
        PlainObject po = new PlainObject( );
        List<String> lst = new ArrayList<String>( );
        lst.add( "te1" );
        lst.add( "te2" );
        lst.add( "te3" );
        po.setListStringField( lst );
        String jsonString = JsonSmartProcessor.serializeToJSONString( po );
        Assert.assertTrue( jsonString.contains( "\"listStringField\":[\"te1\",\"te2\",\"te3\"]" ) );
    }
    
    @Test
    public void testEncodingMapStringToString() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    
        PlainObject po = new PlainObject( );
        Map<String, String> map = new TreeMap<String, String>( );
        map.put( "tk1", "tv1" );
        map.put( "tk2", "tv2" );
        map.put( "tk3", "tv3" );
        po.setMapStringToStringField( map );
        String jsonString = JsonSmartProcessor.serializeToJSONString( po );
        System.out.println( "testEcodingMapStringToString = " + jsonString );
        Assert.assertTrue( jsonString.contains( "\"mapStringToStringField\":{\"tk1\":\"tv1\",\"tk2\":\"tv2\",\"tk3\":\"tv3\"}" ) );
    }
    
    @Test
    public void testDecodingMapStringToString() throws IllegalArgumentException, IllegalAccessException, InstantiationException, InvocationTargetException {
    
        String jsonString = "{\"mapStringToStringField\":{\"tk1\":\"tv1\",\"tk2\":\"tv2\",\"tk3\":\"tv3\"}}";
        PlainObject po = (PlainObject) JsonSmartProcessor.deserialize( jsonString, PlainObject.class );
        Map<String, String> map = new TreeMap<String, String>( );
        map.put( "tk1", "tv1" );
        map.put( "tk2", "tv2" );
        map.put( "tk3", "tv3" );
        System.out.println( po.getMapStringToStringField( ) );
        Assert.assertEquals( po.getMapStringToStringField( ), map );
    }
    
    @Test
    public void testDecodingArrString() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
    
        String jsonSring = "{\"arrStringField\":[\"te1\",\"te2\",\"te3\"]}";
        PlainObject po = (PlainObject) JsonSmartProcessor.deserialize( jsonSring, PlainObject.class );
        List<String> lst = new ArrayList<String>( );
        lst.add( "te1" );
        lst.add( "te2" );
        lst.add( "te3" );
        Assert.assertEquals( po.getArrStringField( ), lst.toArray( new String[lst.size( )] ) );
    }
    
    @Test
    public void testDecodingListString() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
    
        String jsonSring = "{\"listStringField\":[\"te1\",\"te2\",\"te3\"]}";
        PlainObject po = (PlainObject) JsonSmartProcessor.deserialize( jsonSring, PlainObject.class );
        List<String> lst = new ArrayList<String>( );
        lst.add( "te1" );
        lst.add( "te2" );
        lst.add( "te3" );
        Assert.assertEquals( po.getListStringField( ), lst );
    }
    
    @Test
    public void testEncodingArrString() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    
        PlainObject po = new PlainObject( );
        List<String> lst = new ArrayList<String>( );
        lst.add( "te1" );
        lst.add( "te2" );
        lst.add( "te3" );
        po.setArrStringField( lst.toArray( new String[lst.size( )] ) );
        String jsonString = JsonSmartProcessor.serializeToJSONString( po );
        Assert.assertTrue( jsonString.contains( "\"arrStringField\":[\"te1\",\"te2\",\"te3\"]" ) );
    }
    
    @Test
    public void testEncodingOtherObject() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    
        PlainObject po = new PlainObject( );
        po.setOtherObjectField( new OtherObject( "k1", "v1", 20 ) );
        String jsonString = JsonSmartProcessor.serializeToJSONString( po );
        Assert.assertTrue( jsonString.contains( "otherObjectField\":{" ) );
        Assert.assertTrue( jsonString.contains( "\"value\":\"v1\"" ) );
        Assert.assertTrue( jsonString.contains( "\"key\":\"k1\"" ) );
        Assert.assertTrue( jsonString.contains( "\"intValue\":20" ) );
        
    }
    
    @Test
    public void testEncodingOtherListObject() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    
        PlainObject po = new PlainObject( );
        po.setListOtherObjectField( Collections.singletonList( new OtherObject( "k1", "v1", 20 ) ) );
        String jsonString = JsonSmartProcessor.serializeToJSONString( po );
        Assert.assertTrue( jsonString.contains( "listOtherObjectField\":[{" ) );
        Assert.assertTrue( jsonString.contains( "\"value\":\"v1\"" ) );
        Assert.assertTrue( jsonString.contains( "\"key\":\"k1\"" ) );
        Assert.assertTrue( jsonString.contains( "\"intValue\":20" ) );
    }
    
    @Test
    public void testEncodingMapOtherObject() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    
        PlainObject po = new PlainObject( );
        Map<String, OtherObject> map = new HashMap<String, OtherObject>( );
        map.put( "test", new OtherObject( "k1", "v1", 20 ) );
        po.setMapStringToOtherObjectField( map );
        String jsonString = JsonSmartProcessor.serializeToJSONString( po );
        Assert.assertTrue( jsonString.contains( "mapStringToOtherObjectField\":{\"test\":" ) );
        Assert.assertTrue( jsonString.contains( "\"value\":\"v1\"" ) );
        Assert.assertTrue( jsonString.contains( "\"key\":\"k1\"" ) );
        Assert.assertTrue( jsonString.contains( "\"intValue\":20" ) );
    }
    
    @Test
    public void testDecodingMapToOtherObject() throws IllegalArgumentException, IllegalAccessException, InstantiationException, InvocationTargetException {
    
        String jsonString = "{\"mapStringToOtherObjectField\":{\"test\":{\"key\":\"k1\",\"value\":\"v1\",\"intValue\":20}}}";
        PlainObject po = (PlainObject) JsonSmartProcessor.deserialize( jsonString, PlainObject.class );
        Map<String, OtherObject> map = new HashMap<String, OtherObject>( );
        map.put( "test", new OtherObject( "k1", "v1", 20 ) );
        Assert.assertEquals( po.getMapStringToOtherObjectField( ), map );
        
    }
    
    @Test
    public void testDecodingListOtherObject() throws IllegalArgumentException, IllegalAccessException, InstantiationException, InvocationTargetException {
    
        String jsonString = "{\"listOtherObjectField\":[{\"key\":\"k1\",\"value\":\"v1\",\"intValue\":20 }]}";
        PlainObject po = (PlainObject) JsonSmartProcessor.deserialize( jsonString, PlainObject.class );
        List<OtherObject> list = new ArrayList<OtherObject>( );
        list.add( new OtherObject( "k1", "v1", 20 ) );
        Assert.assertEquals( po.getListOtherObjectField( ), list );
        
    }
    
    @Test
    public void testDecodingArrOtherObject() throws IllegalArgumentException, IllegalAccessException, InstantiationException, InvocationTargetException {
    
        String jsonString = "{\"arrOtherObjectField\":[{\"key\":\"k1\",\"value\":\"v1\",\"intValue\":20 }],\"fake\":12}";
        PlainObject po = (PlainObject) JsonSmartProcessor.deserialize( jsonString, PlainObject.class );
        List<OtherObject> list = new ArrayList<OtherObject>( );
        list.add( new OtherObject( "k1", "v1", 20 ) );
        Assert.assertEquals( po.getArrOtherObjectField( ), list.toArray( new OtherObject[list.size( )] ) );
    }
    
    @Test
    public void testDecodingOtherObject() throws IllegalArgumentException, IllegalAccessException, InstantiationException, InvocationTargetException {
    
        String jsonString = "{\"otherObjectField\":{\"key\":\"k1\",\"value\":\"v1\",\"intValue\":20 },\"fake\":12}";
        PlainObject po = (PlainObject) JsonSmartProcessor.deserialize( jsonString, PlainObject.class );
        Assert.assertEquals( po.getOtherObjectField( ), new OtherObject( "k1", "v1", 20 ) );
    }
    
}
