Log4J is most often used to create an instance of the Logger interface from the LogManager and then call the methods on 
this interface. Assume there is a ```<ClassToTest>.java```, inside which we need to create an instance of Logger 
interface by using either of the following ways.
 
```public static final Logger log = LogManager.getLogger(<ClassToTest>.class)``` or 
```public static final Logger log = LoggerFactory.getLogger(<ClassToTest>.class)```. 

Then, we can use any of the in-built log-levels in any method of ```<ClassToTest>.java```, as follows:
```java
 logger.trace("the built-in TRACE level");
 logger.debug("the built-in DEBUG level");
 logger.notice("a custom level: a NOTICE message");
 logger.info("the built-in INFO level");
 logger.warn("the built-in WARN level");
 logger.error("the built-in ERROR level");
 logger.fatal("the built-in FATAL level");
```

Following are the in-built log-levels in highest to lowest order of logging:

|Log-Level| 	Description                                  |
|---      |---                                               |
|Trace    | 	Logs the fine-grained information. This is a high (most detailed) level of logging.|
|Debug    | 	Logs the information necessary for debugging.|
|Info     |	    Used for logging the status messages or any desirable field value|
|Warn     |	    Used for logging potentially unexpected/dangerous situations|
|Error    | 	Used for logging Exception and minor Error events|
|Fatal    | 	Used for logging very severe Error events that might lead the application to collapse.|

![Alt text](java/log_level.png?raw=true "Log Level")