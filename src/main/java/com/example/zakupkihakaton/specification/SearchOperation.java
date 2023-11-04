package com.example.zakupkihakaton.specification;

public enum SearchOperation {
    EQUALITY,
    NOT_EQUALITY,

    GREATER_THAN,
    LESS_THAN,

    LIKE,
    STARTS_WITH,
    ENDS_WITH,
    HAVE,
    IN,

    ALL,
    IS_NULL,
    NOT_NULL,

    SORT,
    SORT_DESC,

    CONTAINS,

    ;
}
