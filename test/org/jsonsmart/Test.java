package org.jsonsmart;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import net.minidev.json.JSONObject;

/**
 * @author Radu Toader [radu.m.toader@gmail.com]
 */
public class Test {
    public static void main( String[] args ) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    
        List<String> strList = new ArrayList<String>( );
        strList.add( "asdl" );
        JSONObject serializeToJSONObject = JsonSmartProcessor.serializeToJSONObject( strList, false );
        System.out.println( serializeToJSONObject );
        
        JSONObject jso = new JSONObject( );
        jso.put( "asd", strList );
        System.out.println( jso );
    }
}
