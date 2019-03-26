package com.roman.shilov.hw9.travelagency.common.buisness.search;

public abstract class BaseSearchConditition {
    protected Long id;
    protected SortType sortType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SortType getSortType() {
        return sortType;
    }

    public void setSortType(SortType sortType) {
        this.sortType = sortType;
    }
}
