package com.aoo.springboot.Graphqlcrudpostgresql.repository;

import com.aoo.springboot.Graphqlcrudpostgresql.model.Organization;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface OrganizationRepository extends CrudRepository<Organization, Integer>, JpaSpecificationExecutor<Organization> {
}
