package org.jsonsmart;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author Radu Toader [radu.m.toader@gmail.com]
 */
public class ClassCacheInfo {
    private HashMap<ClassCacheKey, JSONClassCacheValue<Field>> fieldMap = new HashMap<ClassCacheKey, JSONClassCacheValue<Field>>( );
    private HashMap<ClassCacheKey, JSONClassCacheValue<Method>> methodMap = new HashMap<ClassCacheKey, JSONClassCacheValue<Method>>( );
    
    public Map<String, JSONClassCacheValue<Field>> getAllFieldsFor( JsonSmartSerializationType type ) {
    
        Map<String, JSONClassCacheValue<Field>> filteredFieldMap = new HashMap( );
        
        for ( Entry<ClassCacheKey, JSONClassCacheValue<Field>> entry : fieldMap.entrySet( ) ) {
            ClassCacheKey cck = entry.getKey( );
            JSONClassCacheValue<Field> value = entry.getValue( );
            if ( cck.getType( ).equals( type ) || cck.getType( ).equals( JsonSmartSerializationType.BOTH ) )
                filteredFieldMap.put( cck.getKey( ), value );
        }
        return filteredFieldMap;
    }
    
    public Map<String, JSONClassCacheValue<Method>> getAllMethodsFor( JsonSmartSerializationType type ) {
    
        Map<String, JSONClassCacheValue<Method>> filteredMethodMap = new HashMap( );
        
        for ( Entry<ClassCacheKey, JSONClassCacheValue<Method>> entry : methodMap.entrySet( ) ) {
            ClassCacheKey cck = entry.getKey( );
            JSONClassCacheValue<Method> value = entry.getValue( );
            if ( cck.getType( ).equals( type ) || cck.getType( ).equals( JsonSmartSerializationType.BOTH ) )
                filteredMethodMap.put( cck.getKey( ), value );
        }
        return filteredMethodMap;
    }
    
    public void putField( JsonSmartSerializationType type, Field field, JsonSmart annotationInfo ) {
    
        String key = field.getName( );
        if ( annotationInfo.name( ) != null && !annotationInfo.name( ).isEmpty( ) ) {
            key = annotationInfo.name( );
        }
        JSONClassCacheValue<Field> jsCCValue = new JSONClassCacheValue<Field>( );
        jsCCValue.set( field );
        jsCCValue.setAnnotationInfo( annotationInfo );
        field.setAccessible( true );
        fieldMap.put( new ClassCacheKey( key, type ), jsCCValue );
    }
    
    public void putMethod( JsonSmartSerializationType type, Method method, JsonSmart annotationInfo ) {
    
        String key = method.getName( );
        if ( annotationInfo.name( ) != null && !annotationInfo.name( ).isEmpty( ) ) {
            key = annotationInfo.name( );
        }
        
        JSONClassCacheValue<Method> jsCCValue = new JSONClassCacheValue<Method>( );
        jsCCValue.set( method );
        jsCCValue.setAnnotationInfo( annotationInfo );
        method.setAccessible( true );
        methodMap.put( new ClassCacheKey( key, type ), jsCCValue );
        
    }
}
