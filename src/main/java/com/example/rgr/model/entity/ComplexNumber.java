package com.example.rgr.model.entity;

import java.util.Objects;

public class ComplexNumber {

    private Long real;
    private Long imaginary;

    public ComplexNumber() {
        this.real = 0L;
        this.imaginary = 0L;
    }

    public ComplexNumber(Long real, Long imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public static ComplexNumber sum(ComplexNumber a, ComplexNumber b) throws Exception {
        ComplexNumber result = new ComplexNumber();
        try{
            result.setReal(a.getReal() + b.getReal());
            result.setImaginary(a.getImaginary() + b.getImaginary());
        } catch (NullPointerException e){
            throw new NullPointerException("Os números complexos não foram instanciados corretamentes" + e);
        } catch (Exception e){
            throw new Exception("Foi encontrado um erro! ");
        }
        return result;
    }

    public Long getReal() {
        return real;
    }

    public void setReal(Long real) {
        this.real = real;
    }

    public Long getImaginary() {
        return imaginary;
    }

    public void setImaginary(Long imaginary) {
        this.imaginary = imaginary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComplexNumber that = (ComplexNumber) o;
        return Objects.equals(real, that.real) && Objects.equals(imaginary, that.imaginary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(real, imaginary);
    }

    @Override
    public String toString() {
        return real + " + " + imaginary + "i";
    }
}
