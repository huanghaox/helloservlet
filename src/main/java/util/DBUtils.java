package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

public class DBUtils {
		private static BasicDataSource ds;
		static {
		ds = new BasicDataSource();
		Properties prop = new Properties();
		//获取文件输入流
		InputStream ips = DBUtils.class.getClassLoader()
				.getResourceAsStream("jdbc.properties");
		//加载文件流
		
		try {
		prop.load(ips);
		String url=prop.getProperty("url");
	  String  username=prop.getProperty("username");
		String  password=prop.getProperty("password");
		String driver = prop.getProperty("driver");
		ds.setDriverClassName(driver);
		ds.setUrl(url);
		ds.setUsername(username);
		ds.setPassword(password);
		ds.setInitialSize(3);//设置初始连接数量
		ds.setMaxActive(5);//设置最大连接数量
		}catch(IOException e){
			e.printStackTrace();
		}

	
	}
	public static Connection getConn() throws Exception{
		Connection conn = ds.getConnection();
		System.out.println(conn);
		return conn ;
	}
}
