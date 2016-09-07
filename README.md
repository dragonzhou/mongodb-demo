# spring boot
## 命令
* 打包 clean package
* 运行 java -jar mongodb-geo-demo-0.0.1-SNAPSHOT.jar
* 引用插件 spring-boot-maven-plugin
* 文档
```
http://www.cnblogs.com/tomlxq/p/5514658.html
http://www.jianshu.com/p/afc31c34a99b
```
* main启动，两种方式
```
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class App {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(App.class, args);
	}

}
```
```
@SpringBootApplication
public class GeoMongodbSpringBootDemoApplication {

	 public static void main(String[] args) {
	 SpringApplication.run(GeoMongodbSpringBootDemoApplication.class, args);
	 }
}
```
