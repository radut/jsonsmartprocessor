jsonsmartprocessor
==================

Use of JSONSmart lib with custom annotations. Serialize and deserialize primitives and Object(except char / Character),Map&lt;String,String/Pojo>,List&lt;String/Pojo>,Array[] - string array / POJO array

Usage:

annotation on a field (note: you can specify name,to overide the default name which is field name)
You can use a field only in serialization / deserialization / default = Both
public class PlainObject { 
    @JsonSmart
    private OtherObject[] arrOtherObjectField;
    @JsonSmart(type=JsonSmartSerializationType.BOTH)
    private String[] arrStringField;
    @JsonSmart(type=JsonSmartSerializationType.SERIALIZATION)
    private int serializationIntField;
    @JsonSmart(type=JsonSmartSerializationType.DESERIALIZATION)
    private int newIntField;
}

annotation on method
public class PlainObjectMethods {
    private OtherObjectMethods[] arrOtherObjectField;
    private String[] arrStringField;
     @JsonSmart( type = JsonSmartSerializationType.SERIALIZATION, name = "arrOtherObjectField" )
    public OtherObjectMethods[] getArrOtherObjectField() {
    
        return arrOtherObjectField;
    }
    
    @JsonSmart( type = JsonSmartSerializationType.SERIALIZATION, name = "arrStringField" )
    public String[] getArrStringField() {
    
        return arrStringField;
    }
      @JsonSmart( type = JsonSmartSerializationType.DESERIALIZATION, name = "otherObjectField" )
    public void setOtherObjectMethodsField( OtherObjectMethods otherObjectField ) {
    
        this.otherObjectField = otherObjectField;
    }
    
    @JsonSmart( type = JsonSmartSerializationType.DESERIALIZATION, name = "shortField" )
    public void setShortField( short shortField ) {
    
        this.shortField = shortField;
    }
}


Api calls:
deserialize : 

JsonSmartProcessor.deserialize( json, classType, useCache ); //use cache - related to fields and methods
JsonSmartProcessor.deserialize( json, classType ); //use cache = true - default

example in /test
  PlainObject po = (PlainObject) JsonSmartProcessor.deserialize( jsonString, PlainObject.class);
  
serialize:

JsonSmartProcessor.serializeToJSONString( pojo,useCache); //use cache - related to fields and methods
JsonSmartProcessor.serializeToJSONString( pojo); //use cache = true - default

example in /test

  String jsonString = JsonSmartProcessor.serializeToJSONString( po, true );
  
if you want you can obtain JSONObject instead of string like this :

  JSONObject jsonObject = JsonSmartProcessor.serializeToJSONObject( po );  