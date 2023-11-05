package com.example.demo.genericGenerator;

import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;

public class MyGenerator implements IdentifierGenerator , Configurable{
	
	
	public static final String SEQUENCE_PREFIX = "Sequence_Prefix";
	
	public String sequencePrefix;
	public String sequenceCallSyntax;
	
	@Override
	public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) throws MappingException {
 		IdentifierGenerator.super.configure(type, params, serviceRegistry);
	}

	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) throws HibernateException {

		
		return null;
	}


	
	
	

}
