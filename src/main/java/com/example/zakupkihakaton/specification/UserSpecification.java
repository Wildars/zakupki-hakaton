package com.example.zakupkihakaton.specification;

import com.example.zakupkihakaton.entity.Role;
import com.example.zakupkihakaton.entity.User;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class UserSpecification extends BaseSpecification<User> {
    public UserSpecification(SpecSearchCriteria criteria) {
        super(criteria);
    }

    public UserSpecification() {
        super(SpecSearchCriteria.all());
    }


    public static UserSpecification findByRoleList(List<Role> roles) {
        if (roles == null)
            return new UserSpecification();
        if (roles.isEmpty())
            return new UserSpecification();

        String key = "role";
        return new UserSpecification(new SpecSearchCriteria(key, SearchOperation.IN, roles));
    }

    public static UserSpecification findByOZid(Long OZid) {
        if (OZid == null)
            return new UserSpecification();

        String key = "organization";
        return new UserSpecification(SpecSearchCriteria.equal(key, OZid));
    }

    public static UserSpecification findByRegionId(Short regionId) {
        if (regionId == null)
            return new UserSpecification();

        String key = "region";
        return new UserSpecification(SpecSearchCriteria.equal(key, regionId));
    }
}
