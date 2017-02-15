package com.megatech;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cassandra.config.CassandraCqlClusterFactoryBean;
import org.springframework.cassandra.core.keyspace.CreateKeyspaceSpecification;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.config.java.AbstractCassandraConfiguration;

@Configuration
@PropertySource(value = { "classpath:cassandra.properties" })
//@EnableCassandraRepositories(basePackages = { "com.megatech" })
public class CassandraConfig extends AbstractCassandraConfiguration {

	@Value("${cassandra.contactpoints}")
	private String cassandraContactpoints;

	// @Value("${spring.data.cassandra.username}")
	// private String username;
	//
	// @Value("${spring.data.cassandra.password}")
	// private String password;

	@Value("${cassandra.keyspace}")
	private String KEYSPACE_NAME;

	@Value("${cassandra.schema-action}")
	private String KEYSPACE_ACTION;

	@Value("${cassandra.port}")
	private String PORT;


	public CassandraConfig() {
		super();
		System.out.println("Hi Cassandra Config:::::::" + KEYSPACE_NAME);
	}

	@Override
	public String getKeyspaceName() {
		return KEYSPACE_NAME;
	}

	@Override
	public String getContactPoints() {
		return cassandraContactpoints;
	}

	private int getPortNumber() {
		return Integer.parseInt(PORT);
	}

	@Override
	public CassandraCqlClusterFactoryBean cluster() {
		CassandraCqlClusterFactoryBean cluster = super.cluster();

		CreateKeyspaceSpecification keyspaceSpecification = new CreateKeyspaceSpecification(KEYSPACE_NAME).ifNotExists() //
				.withSimpleReplication(1);

		cluster.setKeyspaceCreations(Collections.singletonList(keyspaceSpecification));
		cluster.setPort(getPortNumber());
		cluster.setContactPoints(getContactPoints());

		return cluster;
	}

	@Override
	public SchemaAction getSchemaAction() {
		return SchemaAction.valueOf(KEYSPACE_ACTION);
	}
}