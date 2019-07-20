package com.heyc.gasstation.softem.utils;

import java.io.Serializable;

public class Page
        /*     */   implements Serializable
        /*     */ {
    /*     */   private static final long serialVersionUID = -5823482162101235168L;
    /*     */   public static final String ORDER_ASC = "ASC";
    /*     */   public static final String ORDER_DESC = "DESC";
    /*     */   private int page;
    /*     */   private int offset;
    /*     */   private int limit;
    /*     */   private String sort;
    /*  21 */   private String order = "ASC";
    /*     */
    /*     */   public Page() {
        /*  24 */     this(0, Integer.MAX_VALUE);
        /*     */   }
    /*     */
    /*     */   public Page(int offset, int limit) {
        /*  28 */     this.offset = offset;
        /*  29 */     this.limit = limit;
        /*     */   }
    /*     */
    /*     */   public Page(int offset, int limit, String sort, String order) {
        /*  33 */     this.offset = offset;
        /*  34 */     this.limit = limit;
        /*  35 */     this.sort = sort;
        /*  36 */     this.order = order;
        /*     */   }
    /*     */
    /*     */   public int getOffset() {
        /*  40 */     return (page - 1) * limit;
        /*     */   }
    /*     */
    /*     */   public void setOffset(int offset) {
        /*  44 */     this.offset = offset;
        /*     */   }
    /*     */
    /*     */   public int getLimit() {
        /*  48 */     return limit;
        /*     */   }
    /*     */
    /*     */   public void setLimit(int limit) {
        /*  52 */     this.limit = limit;
        /*     */   }
    /*     */
    /*     */   public String getSort() {
        /*  56 */     return underscoreName(sort);
        /*     */   }
    /*     */
    /*     */   public void setSort(String sort) {
        /*  60 */     this.sort = sort;
        /*     */   }
    /*     */
    /*     */   public String getOrder() {
        /*  64 */     return order;
        /*     */   }
    /*     */
    /*     */   public void setOrder(String order) {
        /*  68 */     this.order = order;
        /*     */   }
    /*     */
    /*     */   public int getOffsetLimit() {
        /*  72 */     return offset + limit;
        /*     */   }
    /*     */
    /*     */   public String toString() {
        /*  76 */     return "[Page: " + offset + ", " + limit + ", " + sort + ", " + order + "]";
        /*     */   }
    /*     */
    /*     */   public int getPage() {
        /*  80 */     return page;
        /*     */   }
    /*     */
    /*     */   public void setPage(int page) {
        /*  84 */     this.page = page;
        /*     */   }
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */   public String underscoreName(String name)
    /*     */   {
        /*  94 */     StringBuilder result = new StringBuilder();
        /*  95 */     if ((name != null) && (name.length() > 0))
            /*     */     {
            /*  97 */       result.append(name.substring(0, 1).toUpperCase());
            /*     */
            /*  99 */       for (int i = 1; i < name.length(); i++) {
                /* 100 */         String s = name.substring(i, i + 1);
                /*     */
                /* 102 */         if ((s.equals(s.toUpperCase())) && (!Character.isDigit(s.charAt(0)))) {
                    /* 103 */           result.append("_");
                    /*     */         }
                /*     */
                /* 106 */         result.append(s.toUpperCase());
                /*     */       }
            /*     */     }
        /* 109 */     return result.toString();
        /*     */   }
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */   public String camelName(String name)
    /*     */   {
        /* 119 */     StringBuilder result = new StringBuilder();
        /*     */
        /* 121 */     if ((name == null) || (name.isEmpty()))
            /*     */     {
            /* 123 */       return ""; }
        /* 124 */     if (!name.contains("_"))
            /*     */     {
            /* 126 */       return name.substring(0, 1).toLowerCase() + name.substring(1);
            /*     */     }
        /*     */
        /* 129 */     String[] camels = name.split("_");
        /* 130 */     for (String camel : camels)
            /*     */     {
            /* 132 */       if (!camel.isEmpty())
                /*     */       {
                /*     */
                /*     */
                /* 136 */         if (result.length() == 0)
                    /*     */         {
                    /* 138 */           result.append(camel.toLowerCase());
                    /*     */         }
                /*     */         else {
                    /* 141 */           result.append(camel.substring(0, 1).toUpperCase());
                    /* 142 */           result.append(camel.substring(1).toLowerCase());
                    /*     */         } }
            /*     */     }
        /* 145 */     return result.toString();
        /*     */   }
    /*     */ }
