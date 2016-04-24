#commons

#commons

##commons-lang

StringUtils, 
StringEscapeUtils, 
RandomStringUtils, 
Tokenizer, 
WordUtils等工具类


##toString
ReflectionToStringBuilder;

##text

##BeanUtils

	BeanUtils.copyProperties(teacher,teacherForm);

##function

##collections

##Configuration
处理配置文件，支持多种类型

1. Properties files
2. XML documents
3. Property list files (.plist)
4. JNDI
5. JDBC Datasource
6. System properties
7. Applet parameters
8. Servlet parameters
9. 

##xml
	Student student = (Student)JXPathContext.newContext(xxx).
	getValue("locations[student/name='milk']/address");

##frustration

##Cli
Command Line Interface，也就是"命令行接口"，处理命令的工具。

比如main方法输入的string[]需要解析。你可以预先定义好参数的规则，然后就可以调用CLI来解析。

###自动生成帮助声明:
HelpFormatter formatter = new HelpFormatter();  
formatter.printHelp( "ant", options );  

###Codec
用来编码和解码的，包括Base64，URL，Soundx等等。

###DbUtils
###net
	这个包还是很实用的，封装了很多网络协议。
	
	1. FTP
	2. NNTP
	3. SMTP
	4. POP3
	5. Telnet
	6. TFTP
	7. Finger
	8. Whois
	9. rexec/rcmd/rlogin
	10. Time (rdate) and Daytime
	11. Echo
	12. Discard
	13. NTP/SNTP
	
	使用示例：
	TelnetClient telnet = new TelnetClient();
	telnet.connect( "192.168.1.99", 23 );
	InputStream in = telnet.getInputStream();
	PrintStream out = new PrintStream( telnet.getOutputStream() );
	...
	telnet.close();

###validator
帮助进行验证的工具包。
比如验证Email，日期字符串是否合法。


##Math

##template

##io
###read from  url
使用IOUtils

	InputStream in = new URL( "http://jakarta.apache.org" ).openStream();
	try {
	    System.out.println( IOUtils.toString( in ) );
	} finally {
	    IOUtils.closeQuietly(in);
	}
###read  from file
	File file = new File("/commons/io/project.properties");
	List lines = FileUtils.readLines(file, "UTF-8");

##vfs
提供对各种虚拟资源的访问接口。支持的资源类型包括

	1. CIFS
	2. FTP
	3. Local Files
	4. HTTP and HTTPS
	5. SFTP
	6. Temporary Files
	7. WebDAV
	8. Zip, Jar and Tar (uncompressed, tgz or tbz2)
	9. gzip and bzip2
	10. res
	11. ram

这个包的功能很强大，极大的简化了程序对资源的访问。

使用示例：

从jar中读取文件

	// Locate the Jar file
	FileSystemManager fsManager = VFS.getManager();
	FileObject jarFile = fsManager.resolveFile( "jar:lib/aJarFile.jar" );
	
	// List the children of the Jar file
	FileObject[] children = jarFile.getChildren();
	System.out.println( "Children of " + jarFile.getName().getURI() );
	for ( int i = 0; i < children.length; i++ ){
	    System.out.println( children[ i ].getName().getBaseName() );
	}

从smb读取文件
	StaticUserAuthenticator auth = new StaticUserAuthenticator("username", "password", null);
	FileSystemOptions opts = new FileSystemOptions();
	DefaultFileSystemConfigBuilder.getInstance().setUserAuthenticator(opts, auth);
	FileObject fo = VFS.getManager().resolveFile("smb://host/anyshare/dir", opts);

##http

##search

##bcel
Apache Byte Code Engineering Library (BCEL),与 Javassist 所支持的源代码接口不同，BCEL 在JVM 指令层次上进行操作.使用比 Javassist 要复杂得多。



