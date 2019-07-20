package com.heyc.gasstation.softem.utils;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
@Data
public class DataGrid<T> implements Serializable {
    private static final long serialVersionUID = -4353059775338989141L;
    private Integer total;
    private List<T> rows;
    private Integer pages;
    private Integer recordsTotal;
    private Integer recordsFiltered;
    private String identified = "id";

    public DataGrid (List<T> item) {
        this(item, item.size());
    }

    public DataGrid (List<T> item, Integer numRows, Integer pages) {
        this.rows = item;
        this.total = numRows;
        this.pages = pages;
    }

    public DataGrid(List<T> items, Integer numRows) {
        rows = items;
        total = numRows;
    }

}
