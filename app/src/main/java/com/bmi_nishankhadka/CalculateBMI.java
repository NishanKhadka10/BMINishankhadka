package com.bmi_nishankhadka;

public class CalculateBMI {
    private double height,weight;

    public CalculateBMI(double height,double weight)
    {
        this.height = height;
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double calculateBMI(double height,double weight)
    {
        return (this.weight/((this.height/100)*(this.height/100)));

    }

}

