#yaml

#spec
[YAML Ain’t Markup Language (YAML™) Version 1.2](http://www.yaml.org/spec/1.2/spec.html)

##语法sample

###array

	american:
	  - Boston Red Sox
	  - Detroit Tigers
	  - New York Yankees
	national:
	  - New York Mets
	  - Chicago Cubs
	  - Atlanta Braves

###Structures
	---
	time: 20:03:20
	player: Sammy Sosa
	action: strike (miss)
	...
	---
	time: 20:03:47
	player: Sammy Sosa
	action: grand slam
	...




##snakeyaml parser

###maven
	<dependency>
	    <groupId>org.yaml</groupId>
	    <artifactId>snakeyaml</artifactId>
	    <version>1.13</version>
	</dependency>
###parse sample
	InputStream input = new FileInputStream("config.yml");
	Yaml yaml = new Yaml();
	Map<String, Object> object = (Map<String, Object>) yaml.load(input);