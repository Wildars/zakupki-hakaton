package com.example.zakupkihakaton.specification;

import com.example.zakupkihakaton.entity.Role;
import com.example.zakupkihakaton.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class UserSpecification extends BaseSpecification<User> {
    protected List<UserSpecification> values = new ArrayList<>();

    public UserSpecification(SpecSearchCriteria criteria) {
        super(criteria);
    }

    public UserSpecification() {
        super();
    }

    @Override
    public <L extends BaseSpecification<User>> L update(L specification) {
        this.values.add((UserSpecification) specification);
        return (L) this;
    }

    @Override
    public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        if (values.isEmpty())
            return super.toPredicate(root, query, builder);

        boolean isFirst = true;
        Specification<User> result = null;
        for (var i : values) {
            if (isFirst) {
                isFirst = false;
                result = Specification.where(i);
            } else
                result = result.and(i);
        }

        return result.toPredicate(root, query, builder);
    }

    public UserSpecification findByRoleList(List<Role> roles) {
        if (roles == null)
            return update(new UserSpecification());
        if (roles.isEmpty())
            return update(new UserSpecification());

        String key = "role";
        return update(new UserSpecification(new SpecSearchCriteria(key, SearchOperation.IN, roles)));
    }

    public UserSpecification findByOZid(Long OZid) {
        if (OZid == null)
            return update(new UserSpecification());

        String key = "organization";
        return update(new UserSpecification(SpecSearchCriteria.equal(key, OZid)));
    }

    public UserSpecification findByRegionId(Short regionId) {
        if (regionId == null)
            return update(new UserSpecification());

        String key = "region";
        return update(new UserSpecification(SpecSearchCriteria.equal(key, regionId)));
    }
}
