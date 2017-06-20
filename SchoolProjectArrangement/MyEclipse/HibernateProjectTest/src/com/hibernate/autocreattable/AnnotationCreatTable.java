package com.hibernate.autocreattable;


import org.hibernate.cfg.AnnotationConfiguration;  
import org.hibernate.cfg.Configuration;  
import org.hibernate.tool.hbm2ddl.SchemaExport;
public class AnnotationCreatTable {
	public static void main(String[] args) {
		Configuration config = new AnnotationConfiguration().configure();  
        SchemaExport export = new SchemaExport(config);  
        export.create(true, true);
	}
}
