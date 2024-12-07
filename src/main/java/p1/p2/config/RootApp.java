package p1.p2.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RootApp {

		@Bean
		public DataSource dataa()
		{
			BasicDataSource bs=new BasicDataSource();
			bs.setDriverClassName("oracle.jdbc.driver.OracleDriver");
			bs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			bs.setUsername("Priyanshu");
			bs.setPassword("tiger");
			return bs;
		
	}

}
