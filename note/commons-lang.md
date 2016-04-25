#commons-lang

##version
http://commons.apache.org/proper/commons-lang

maven

	<groupId>org.apache.commons</groupId>
	<artifactId>commons-lang3</artifactId>
	<version>3.4</version>

##StringUtils

##XXXTypeUtil
比如StringUtils， BooleanUtils,提供功能

1. 常量 	.XXX_ZERO 	.XXX_ONE
2. 类型转换  toXXX
3. 判断比较 	compare，isXXX


##RandomStringUtils
	RandomStringUtils.random(10);//中文环境乱码
	RandomStringUtils.random(10, new char[]{'a','b','c'});
	
	RandomStringUtils.randomAlphanumeric(10);
	RandomStringUtils.randomNumeric(10);
	RandomStringUtils.randomAlphabetic(10);
	RandomStringUtils.randomAscii(10)；

##StringEscapeUtils

##Validate

##ArrayUtil
1. 增删改查
2. 复制，切分

	subarray， 底层依然是System.arraycopy

3. 数据类型转换 
	toMap

		String[][] data = new String[][] { 
			{ "RED", "#FF0000" },{ "GREEN", "#00FF00" }, { "BLUE", "#0000FF" } };

		Map colorMap = ArrayUtils.toMap(data);

	toXXXXType 转换成为某种类型的array

4. 逆序（java.util.Arrays 本身已经提供填充，排序）



