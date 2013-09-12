package org.jsonsmart;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.JSONValue;

/**
 * @author Radu Toader [radu.m.toader@gmail.com]
 */
public class JsonSmartProcessor {
    private static final String _LIST = "list";
    private static final String _MAP = "map";
    private static Map<Class, ClassCacheInfo> cache = Collections.synchronizedMap( new HashMap<Class, ClassCacheInfo>( ) );
    
    public static Object deserialize( String jsonStr, Class<?> c ) throws IllegalArgumentException, IllegalAccessException, InstantiationException, InvocationTargetException {
    
        return deserialize( jsonStr, c, true );
    }
    
    public static Object deserialize( String jsonStr, Class<?> c, boolean useCache ) throws IllegalArgumentException, IllegalAccessException, InstantiationException, InvocationTargetException {
    
        if ( jsonStr == null )
            return null;
        Map<String, Object> jsMap = (Map<String, Object>) new JSONValue( ).parse( jsonStr );
        return deserializeInternal( jsMap, c, useCache );
    }
    
    public static String serializeToJSONString( Object obj ) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    
        return serializeToJSONString( obj, true );
    }
    
    public static String serializeToJSONString( Object obj, boolean useCache ) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    
        return serializeToJSONObject( obj, useCache ).toJSONString( );
    }
    
    private static void buildClassCache( Class<?> c ) {
    
        System.out.println( "building cache for  : " + c.getSimpleName( ) );
        ClassCacheInfo cci = new ClassCacheInfo( );
        cache.put( c, cci );
        Field[] fields = c.getDeclaredFields( );
        for ( Field field : fields ) {
            if ( field.isAnnotationPresent( JsonSmart.class ) ) {
                JsonSmart annotationInfo = field.getAnnotation( JsonSmart.class );
                cci.putField( annotationInfo.type( ), field, annotationInfo );
            }
        }
        //now we build cache for methods :)
        Method[] methods = c.getDeclaredMethods( );
        for ( Method method : methods ) {
            
            if ( method.isAnnotationPresent( JsonSmart.class ) ) {
                JsonSmart anotationInfo = method.getAnnotation( JsonSmart.class );
                cci.putMethod( anotationInfo.type( ), method, anotationInfo );
            }
        }
    }
    
    private static Object deserializeInternal( Object jsMap, Class<?> c, boolean useCache ) throws IllegalArgumentException, IllegalAccessException, InstantiationException, InvocationTargetException {
    
        Object returnObject = c.newInstance( );
        //when we have in cache
        if ( !cache.containsKey( c ) || !useCache ) {
            buildClassCache( c );
        }
        ClassCacheInfo cci = cache.get( c );
        Map<String, JSONClassCacheValue<Field>> fieldMap = cci.getAllFieldsFor( JsonSmartSerializationType.DESERIALIZATION );
        for ( Entry<String, JSONClassCacheValue<Field>> entry : fieldMap.entrySet( ) ) {
            String key = entry.getKey( );
            if ( ( (Map<String, Object>) jsMap ).containsKey( key ) ) {
                JSONClassCacheValue<Field> value = entry.getValue( );
                setFieldValueToObject( (Map<String, Object>) jsMap, returnObject, key, value, useCache );
            }
        }
        Map<String, JSONClassCacheValue<Method>> methodMap = cci.getAllMethodsFor( JsonSmartSerializationType.DESERIALIZATION );
        for ( Entry<String, JSONClassCacheValue<Method>> entry : methodMap.entrySet( ) ) {
            String key = entry.getKey( );
            if ( ( (Map<String, Object>) jsMap ).containsKey( key ) ) {
                JSONClassCacheValue<Method> value = entry.getValue( );
                invokeMethodOnObject( (Map<String, Object>) jsMap, returnObject, key, value, useCache );
            }
        }
        return returnObject;
    }
    
    private static void invokeMethodOnObject( Map<String, Object> jsMap, Object returnObject, String key, JSONClassCacheValue<Method> value, boolean useCache ) throws IllegalAccessException,
            IllegalArgumentException, InvocationTargetException, InstantiationException {
    
        Method method = value.get( );
        Class<?>[] parameterTypes = method.getParameterTypes( );
        if ( parameterTypes.length != 1 )
            throw new IllegalArgumentException( "Cannot put a serialize value into a method with number of params != 1 " + method.getName( )
                                                + " currentParams : "
                                                + parameterTypes.length );
        Class<?> type = parameterTypes[0];
        Object jsValue = jsMap.get( key );
        if ( jsValue == null ) {
            if ( !type.isPrimitive( ) ) {
                method.invoke( returnObject, new Object[1] );
            }
            return;
        }
        if ( !type.isArray( ) && ( type != List.class && type != Map.class ) ) {
            if ( isHandledType( type ) ) {
                if ( ( jsValue instanceof Double && ( type == Float.class || type == float.class ) ) ) {
                    method.invoke( returnObject, new Float( ( (Double) jsValue ).floatValue( ) ) );
                } else if ( ( jsValue instanceof Integer && ( type == Byte.class || type == byte.class ) ) ) {
                    method.invoke( returnObject, new Byte( ( (Integer) jsValue ).byteValue( ) ) );
                } else if ( ( jsValue instanceof Integer && ( type == Short.class || type == short.class ) ) ) {
                    method.invoke( returnObject, new Short( ( (Integer) jsValue ).shortValue( ) ) );
                } else if ( ( jsValue instanceof Integer && ( type == Long.class || type == long.class ) ) ) {
                    method.invoke( returnObject, new Long( ( (Integer) jsValue ) ) );
                } else {
                    method.invoke( returnObject, jsValue );
                }
            } else {
                Object deserialize = deserializeInternal( jsValue, type, false );
                method.invoke( returnObject, new Object[] { deserialize } );
            }
        } else {
            if ( type.isArray( ) || type == List.class ) {
                JSONArray arrObject = (JSONArray) jsValue;
                List<Object> list = new ArrayList<Object>( );
                for ( Object object : arrObject ) {
                    Class<?> classType = type.getComponentType( ) != null ? type.getComponentType( ) : value.getAnnotationInfo( ).classType( );
                    if ( classType == String.class ) {
                        list.add( object );
                    } else {
                        Object di = deserializeInternal( object, classType, useCache );
                        list.add( di );
                    }
                }
                if ( type.isArray( ) ) {
                    Object newInstance = Array.newInstance( type.getComponentType( ), list.size( ) );
                    for ( int i = 0; i < list.size( ); i++ ) {
                        Array.set( newInstance, i, list.get( i ) );
                    }
                    method.invoke( returnObject, new Object[] { newInstance } );
                } else {
                    method.invoke( returnObject, new Object[] { list } );
                }
            } else { //if is Map
                Map<String, Object> mapObject = (Map<String, Object>) jsValue;
                Class<?> classType = value.getAnnotationInfo( ).classType( );
                Map<String, Object> newMap = new HashMap<String, Object>( );
                for ( Entry<String, Object> entry : mapObject.entrySet( ) ) {
                    String entryKey = entry.getKey( );
                    Object entryValue = entry.getValue( );
                    if ( classType == String.class ) {
                        newMap.put( entryKey, entryValue );
                    } else {
                        Object obj = deserializeInternal( entryValue, classType, useCache );
                        newMap.put( entryKey, obj );
                    }
                }
                method.invoke( returnObject, new Object[] { newMap } );
            }
        }
    }
    
    private static boolean isHandledType( Class<?> type ) {
    
        return type == String.class || type == Integer.class
               || type == Long.class
               || type == Double.class
               || type == Byte.class
               || type == Short.class
               || type == Float.class
               || type == Boolean.class
               || type == Character.class
               || type == Map.class
               || type == List.class
               || type.isArray( )
               || type.isPrimitive( );
    }
    
    private static void putFieldValueInJSONObject( Object obj, JSONObject jsObject, String key, Field field, boolean useCache ) throws IllegalAccessException, IllegalArgumentException,
            InvocationTargetException {
    
        Class<?> type = field.getType( );
        if ( isHandledType( type ) ) {
            jsObject.put( key, field.get( obj ) );
        } else {
            JSONObject newJSON = serializeToJSONObject( field.get( obj ), useCache );
            jsObject.put( key, newJSON );
        }
    }
    
    private static void putMethodReturnValueInJSONObject( Object obj, JSONObject jsObject, String key, Method method, boolean useCache ) throws IllegalAccessException, IllegalArgumentException,
            InvocationTargetException {
    
        Class<?> type = method.getReturnType( );
        if ( isHandledType( type ) ) {
            jsObject.put( key, method.invoke( obj ) );
        } else {
            JSONObject newJSON = serializeToJSONObject( method.invoke( obj ), useCache );
            jsObject.put( key, newJSON );
        }
    }
    
    public static JSONObject serializeToJSONObject( Object obj, boolean useCache ) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    
        if ( obj == null )
            return null;
        JSONObject jsObject = new JSONObject( );
        //when we have in cache
        
        if ( obj instanceof List ) {
            jsObject.put( _LIST, obj );
            return jsObject;
        } else if ( obj instanceof Map ) {
            jsObject.put( _MAP, obj );
            return jsObject;
        }
        if ( !cache.containsKey( obj.getClass( ) ) || !useCache ) {
            buildClassCache( obj.getClass( ) );
        }
        ClassCacheInfo cci = cache.get( obj.getClass( ) );
        Map<String, JSONClassCacheValue<Field>> fieldMap = cci.getAllFieldsFor( JsonSmartSerializationType.SERIALIZATION );
        for ( Entry<String, JSONClassCacheValue<Field>> entry : fieldMap.entrySet( ) ) {
            String key = entry.getKey( );
            JSONClassCacheValue<Field> value = entry.getValue( );
            putFieldValueInJSONObject( obj, jsObject, key, value.get( ), useCache );
        }
        Map<String, JSONClassCacheValue<Method>> methodMap = cci.getAllMethodsFor( JsonSmartSerializationType.SERIALIZATION );
        for ( Entry<String, JSONClassCacheValue<Method>> entry : methodMap.entrySet( ) ) {
            String key = entry.getKey( );
            JSONClassCacheValue<Method> value = entry.getValue( );
            putMethodReturnValueInJSONObject( obj, jsObject, key, value.get( ), useCache );
        }
        
        return jsObject;
    }
    
    private static <T> void setFieldValueToObject( Map<String, Object> jsMap, Object returnObject, String key, JSONClassCacheValue<Field> value, boolean useCache ) throws IllegalAccessException,
            IllegalArgumentException, InstantiationException, InvocationTargetException {
    
        Field field = value.get( );
        if ( jsMap.get( key ) == null ) {
            if ( !field.getType( ).isPrimitive( ) )
                field.set( returnObject, null );
            return;
        }
        Class<?> type = field.getType( );
        
        if ( !type.isArray( ) && ( type != List.class && type != Map.class ) ) {
            if ( isHandledType( type ) ) {
                Object object = jsMap.get( key );
                if ( ( object instanceof Double && ( type == Float.class || type == float.class ) ) ) {
                    field.set( returnObject, new Float( ( (Double) object ).floatValue( ) ) );
                } else if ( ( object instanceof Integer && ( type == Byte.class || type == byte.class ) ) ) {
                    field.set( returnObject, new Byte( ( (Integer) object ).byteValue( ) ) );
                } else if ( ( object instanceof Integer && ( type == Short.class || type == short.class ) ) ) {
                    field.set( returnObject, new Short( ( (Integer) object ).shortValue( ) ) );
                } else if ( ( object instanceof Integer && ( type == Long.class || type == long.class ) ) ) {
                    field.set( returnObject, new Long( ( (Integer) object ) ) );
                } else {
                    field.set( returnObject, object );
                }
            } else {
                Object deserialize = deserializeInternal( jsMap.get( key ), type, false );
                field.set( returnObject, deserialize );
            }
        } else {
            if ( type.isArray( ) || type == List.class ) {
                JSONArray arrObject = (JSONArray) jsMap.get( key );
                List<Object> list = new ArrayList<Object>( );
                for ( Object object : arrObject ) {
                    
                    Class classType = type.getComponentType( ) != null ? type.getComponentType( ) : value.getAnnotationInfo( ).classType( );
                    if ( classType == String.class ) {
                        list.add( object );
                    } else {
                        Object di = deserializeInternal( object, classType, useCache );
                        list.add( di );
                    }
                }
                if ( type.isArray( ) ) {
                    Object newInstance = Array.newInstance( type.getComponentType( ), list.size( ) );
                    for ( int i = 0; i < list.size( ); i++ ) {
                        Array.set( newInstance, i, list.get( i ) );
                    }
                    field.set( returnObject, newInstance );
                } else {
                    field.set( returnObject, list );
                }
            } else {//if ( type == Map.class )
                Map<String, Object> mapObject = (Map<String, Object>) jsMap.get( key );
                Class<?> classType = value.getAnnotationInfo( ).classType( );
                Map<String, Object> newMap = new HashMap<String, Object>( );
                for ( Entry<String, Object> entry : mapObject.entrySet( ) ) {
                    String entryKey = entry.getKey( );
                    Object entryValue = entry.getValue( );
                    if ( classType == String.class )
                        newMap.put( entryKey, entryValue );
                    else {
                        Object obj = deserializeInternal( entryValue, classType, useCache );
                        newMap.put( entryKey, obj );
                    }
                }
                field.set( returnObject, newMap );
            }
        }
    }
}
