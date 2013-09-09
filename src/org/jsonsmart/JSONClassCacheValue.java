package org.jsonsmart;

/**
 * @author Radu Toader [radu.m.toader@gmail.com]
 */
public class JSONClassCacheValue<T> {
    JsonSmart annotationInfo;
    T typeValue;
    
    public JsonSmart getAnnotationInfo() {
    
        return annotationInfo;
    }
    
    public void setAnnotationInfo( JsonSmart annotationInfo ) {
    
        this.annotationInfo = annotationInfo;
    }
    
    public T get() {
    
        return typeValue;
    }
    
    public void set( T value ) {
    
        this.typeValue = value;
    }
    
}
