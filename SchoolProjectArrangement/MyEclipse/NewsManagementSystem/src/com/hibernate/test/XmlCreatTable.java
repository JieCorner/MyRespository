package com.hibernate.test;

import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.spi.MetadataImplementor;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlCreatTable {
	public static void main(String[] args) {
		ServiceRegistry serviceRegistry = (ServiceRegistry) new StandardServiceRegistryBuilder().configure().build();  
		MetadataImplementor metadataImplementor = (MetadataImplementor) new MetadataSources(serviceRegistry).buildMetadata();  
		SchemaExport export = new SchemaExport(serviceRegistry, metadataImplementor);  
		export.create(true, true); 
	}
}
