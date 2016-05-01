#GSON

##basic

###maven
	<dependency>  
	    <groupId>com.google.code.gson</groupId>  
	    <artifactId>gson</artifactId>  
	    <version>2.6.2</version>  
	  </dependency> 

###fromJson，toJson sample
	Gson gson = new Gson();
	TargetType target = gson.fromJson(JSON_DATA_STRING, TargetType);
	String targetString = gson.toJson(TargetObject);



##Custom 

###类型格式TypeToken
	Type listType = new TypeToken<ArrayList<Person>>(){}.getType();

###时间输出格式

	GsonBuilder builder = new GsonBuilder();
	builder.setDateFormat("yyyy年MM月dd HH:mm:ss"); 
	Gson gson = builder.create();

###别名
	String JSON_DATA_STRING = {
		nick_name: "sagomilk"
	}

	public class Person {	
	    @SerializedName("nick_name")
	    public String name;
	}

	gson.fromJson(JSON_DATA_STRING, Person.class);

###支持null输出
	Gson includeNullsGson = gsonBuilder.serializeNulls().create();

###禁用html转义
	Gson unescapingGson = new GsonBuilder().disableHtmlEscaping().create();

###停用属性
	transient String nickName;

或者 static ，如果需要输出

	import java.lang.reflect.Modifier;
	Gson gson = new GsonBuilder()
	    .excludeFieldsWithModifiers(Modifier.STATIC)
	    .create();


###多版本支持
	class VersionClass{
		@Since(1.0) 
		String versionOneField = "1.0";

		@Since(2.0) 
		String versionTwoField = "2.0";
	}

	Gson gson = new GsonBuilder().setVersion(1.0).create();


Serializer

	private class DateTimeSerializer implements JsonSerializer<DateTime> {
	  public JsonElement serialize(DateTime src, Type typeOfSrc, JsonSerializationContext context) {
	    return new JsonPrimitive(src.toString());
	  }
	}

Deserializer

	private class DateTimeDeserializer implements JsonDeserializer<DateTime> {
	  public DateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
	      throws JsonParseException {
	    return new DateTime(json.getAsJsonPrimitive().getAsString());
	  }
	}

###Serialization 和 Deserialization

	GsonBuilder gson = new GsonBuilder();
	gson.registerTypeAdapter(MyType2.class, new MyTypeAdapter());
	gson.registerTypeAdapter(MyType.class, new MySerializer());
	gson.registerTypeAdapter(MyType.class, new MyDeserializer());
	gson.registerTypeAdapter(MyType.class, new MyInstanceCreator());

##Array

1. 直接解析成数组

		Person[] foos = gson.fromJson(JSON_DATA_STRING, Person[].class);
		List<Person> fooList = Arrays.asList(foos);

2. 解析成为List

		Type listType = new TypeToken<ArrayList<Person>>(){}.getType();
		ArrayList<Person> foos = gson.fromJson(JSON_DATA_STRING, listType);

##Other
###Map
如果没有对应的Object class，可以直接使用Map.class,但是使用的时候需要执行转换

	Map m = gson.fromJson(JSON_DATA_STRING, Map.class);

###命名风格setFieldNamingPolicy
	 new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_DASHES).create();

###美化
	GsonBuilder gsonBuilder = new GsonBuilder();
	Gson prettyGson = gsonBuilder.setPrettyPrinting().create();

###Streaming
	FileWriter writer = new FileWriter("./data.json")) { 
    gson.toJson(new Person(), writer);

###referrer
[gson](https://github.com/google/gson)
