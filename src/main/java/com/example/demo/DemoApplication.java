package com.example.demo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.example.mongodb.model.Person;
import com.example.mongodb.model.dao.PersonDAL;
import com.example.mongodb.model.daoImp.PersonDALImpl;

import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
@ComponentScan("com.example")
public class DemoApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	
	private static final Logger LOG = LoggerFactory.getLogger("AppsDeveloperBlog");
	 @Autowired  
	public  PersonDALImpl personDAL;
	 
public DemoApplication(PersonDALImpl personDAL)
{
	this.personDAL=personDAL;
}
	 
	@Override
	  public void run(String... args) {
	     personDAL.savePerson(new Person(
	           "Shubham", Arrays.asList("Harry potter", "Waking Up"), new Date(769372200000L)));
	     personDAL.savePerson(new Person(
	           "Sergey", Arrays.asList("Startup Guides", "Java"), new Date(664309800000L)));
	     personDAL.savePerson(new Person(
	           "David", Arrays.asList("Harry potter", "Success"), new Date(695845800000L)));
	     personDAL.savePerson(new Person(
	           "Ivan", Arrays.asList("Secrets of Butene", "Meeting Success"), new Date(569615400000L)));
	     personDAL.savePerson(new Person(
	           "Sergey", Arrays.asList("Harry potter", "Startup Guides"), new Date(348777000000L)));
	     LOG.info("Getting all data from MongoDB: \n{}",
	           personDAL.getAllPerson());
	     LOG.info("Getting paginated data from MongoDB: \n{}",
	           personDAL.getAllPersonPaginated(0, 2));
	     LOG.info("Getting person By name 'Sergey': {}",
	           personDAL.findByName("Sergey"));
	     LOG.info("Getting all person By name 'Sergey': {}",
	           personDAL.findOneByName("Sergey"));
	     LOG.info("Getting people between age 22 & 26: {}",
	           personDAL.findByAgeRange(22, 26));
	  }

}
