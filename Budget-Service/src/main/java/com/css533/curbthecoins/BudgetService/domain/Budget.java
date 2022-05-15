package com.css533.curbthecoins.BudgetService.domain;

public class Budget {
    private Integer budgetId;
    private Integer userId;
    private Integer partnerId;
    private Double totalBudget;
    private String title;
    private String description;

    public Integer getBudgetId() {
        return budgetId;
    }

    public void setBudgetId(Integer budgetId) {
        this.budgetId = budgetId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Integer partnerId) {
        this.partnerId = partnerId;
    }

    public Double getTotalBudget() {
        return totalBudget;
    }

    public void setTotalBudget(Double totalBudget) {
        this.totalBudget = totalBudget;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Budget(Integer budgetId, Integer userId, Integer partnerId, Double totalBudget, String title, String description) {
        this.budgetId = budgetId;
        this.userId = userId;
        this.partnerId = partnerId;
        this.totalBudget = totalBudget;
        this.title = title;
        this.description = description;
    }
}
