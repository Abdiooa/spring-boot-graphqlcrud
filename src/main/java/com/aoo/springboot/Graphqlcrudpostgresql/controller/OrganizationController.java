package com.aoo.springboot.Graphqlcrudpostgresql.controller;

import com.aoo.springboot.Graphqlcrudpostgresql.model.Department;
import com.aoo.springboot.Graphqlcrudpostgresql.model.Employee;
import com.aoo.springboot.Graphqlcrudpostgresql.model.Organization;
import com.aoo.springboot.Graphqlcrudpostgresql.model.OrganizationInput;
import com.aoo.springboot.Graphqlcrudpostgresql.repository.OrganizationRepository;
import graphql.schema.DataFetchingEnvironment;
import graphql.schema.DataFetchingFieldSelectionSet;
import jakarta.persistence.criteria.Fetch;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class OrganizationController {
    private final OrganizationRepository organizationRepository;

    @MutationMapping
    public Organization newOrganization(@Argument OrganizationInput organization) {
        return organizationRepository.save(new Organization(null, organization.getName(), null, null));
    }

    @QueryMapping
    public Iterable<Organization> organizations() {
        return organizationRepository.findAll();
    }
    @QueryMapping
    public Organization organization(@Argument Integer id, DataFetchingEnvironment environment) {
        Specification<Organization> spec = byId(id);
        DataFetchingFieldSelectionSet selectionSet = environment
                .getSelectionSet();
        if (selectionSet.contains("employees"))
            spec = spec.and(fetchEmployees());
        if (selectionSet.contains("departments"))
            spec = spec.and(fetchDepartments());
        return organizationRepository.findOne(spec).orElseThrow();
    }

    private Specification<Organization> fetchDepartments() {
        return (root, query, builder) -> {
            Fetch<Organization, Department> f = root
                    .fetch("departments", JoinType.LEFT);
            Join<Organization, Department> join = (Join<Organization, Department>) f;
            return join.getOn();
        };
    }

    private Specification<Organization> fetchEmployees() {
        return (root, query, builder) -> {
            Fetch<Organization, Employee> f = root
                    .fetch("employees", JoinType.LEFT);
            Join<Organization, Employee> join = (Join<Organization, Employee>) f;
            return join.getOn();
        };
    }

    private Specification<Organization> byId(Integer id) {
        return (root, query, builder) -> builder.equal(root.get("id"), id);
    }

}
