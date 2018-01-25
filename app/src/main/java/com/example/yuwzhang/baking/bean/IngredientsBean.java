package com.example.yuwzhang.baking.bean;

/**
 * Created by yuwzhang on 2018/1/25.
 */

public class IngredientsBean {
    /**
     * quantity : 2
     * measure : CUP
     * ingredient : Graham Cracker crumbs
     */

    private float quantity;
    private String measure;
    private String ingredient;

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }
}
