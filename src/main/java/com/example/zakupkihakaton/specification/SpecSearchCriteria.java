package com.example.zakupkihakaton.specification;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SpecSearchCriteria {
    private String key;
    private SearchOperation operation;
    private Object value;

    public SpecSearchCriteria(final String key, final SearchOperation operation, final Object value) {
        super();
        this.key = key;
        this.operation = operation;
        this.value = value;
    }

    public static SpecSearchCriteria all() {
        return new SpecSearchCriteria(null, SearchOperation.ALL, null);
    }

    public static SpecSearchCriteria equal(String key, final Object value) {
        return new SpecSearchCriteria(key, SearchOperation.EQUALITY, value);
    }

    public static SpecSearchCriteria notNull(String key) {
        return new SpecSearchCriteria(key, SearchOperation.NOT_NULL, null);
    }
}
