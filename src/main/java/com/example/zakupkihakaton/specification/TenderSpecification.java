package com.example.zakupkihakaton.specification;

import com.example.zakupkihakaton.entity.dictionary.Tender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class TenderSpecification extends BaseSpecification<Tender> {
    protected List<TenderSpecification> values = new ArrayList<>();

    public TenderSpecification(SpecSearchCriteria criteria) {
        super(criteria);
    }

    public TenderSpecification() {
        super();
    }

    @Override
    public <L extends BaseSpecification<Tender>> L update(L specification) {
        this.values.add((TenderSpecification) specification);
        return (L) this;
    }

    public <L extends BaseSpecification<Tender>> L update() {
        return (L) this;
    }

    @Override
    public Predicate toPredicate(Root<Tender> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        if (values.isEmpty())
            return super.toPredicate(root, query, builder);

        boolean isFirst = true;
        Specification<Tender> result = null;
        for (var i : values) {
            if (isFirst) {
                isFirst = false;
                result = Specification.where(i);
            } else
                result = result.and(i);
        }

        return result.toPredicate(root, query, builder);
    }

    public TenderSpecification sortByOldest() {
        String key = "createdDate";

        return update(new TenderSpecification(new SpecSearchCriteria(key, SearchOperation.SORT, null)));
    }

    public TenderSpecification sortByNew() {
        String key = "createdDate";
        return update(new TenderSpecification(new SpecSearchCriteria(key, SearchOperation.SORT_DESC, null)));
    }

    public TenderSpecification findStartFrom(LocalDateTime date) {
        if (date == null)
            return update();

        String key = "dateStart";
        return update(new TenderSpecification(new SpecSearchCriteria(key, SearchOperation.EQUALITY_OR_GREATER_THAN, date)));
    }

    public TenderSpecification findEndTo(LocalDateTime date) {
        if (date == null)
            return update();

        String key = "dateEnd";
        return update(new TenderSpecification(new SpecSearchCriteria(key, SearchOperation.EQUALITY_OR_LESS_THAN, date)));
    }

    public TenderSpecification findByNumber(String number) {
        if (number == null)
            return update();

        String key = "number";
        return update(new TenderSpecification(new SpecSearchCriteria(key, SearchOperation.STARTS_WITH, number)));
    }

    public TenderSpecification findByName(String name) {
        if (name == null)
            return update();

        String key = "name";
        return update(new TenderSpecification(new SpecSearchCriteria(key, SearchOperation.HAVE, name)));
    }

    public TenderSpecification findByType(String type) {
        if (type == null)
            return update();

        String key = "type";
        return update(new TenderSpecification(new SpecSearchCriteria(key, SearchOperation.HAVE, type)));
    }

    public TenderSpecification findSumFrom(BigDecimal sum) {
        if (sum == null)
            return update();

        String key = "sum";
        return update(new TenderSpecification(new SpecSearchCriteria(key, SearchOperation.EQUALITY_OR_GREATER_THAN, sum)));
    }

    public TenderSpecification findSumTo(BigDecimal sum) {
        if (sum == null)
            return update();

        String key = "sum";
        return update(new TenderSpecification(new SpecSearchCriteria(key, SearchOperation.EQUALITY_OR_LESS_THAN, sum)));
    }

    public TenderSpecification findIsStroi(Boolean value) {
        if (value == null)
            return update();

        String key = "isStroi";
        return update(new TenderSpecification(new SpecSearchCriteria(key, SearchOperation.EQUALITY, value)));
    }
}
