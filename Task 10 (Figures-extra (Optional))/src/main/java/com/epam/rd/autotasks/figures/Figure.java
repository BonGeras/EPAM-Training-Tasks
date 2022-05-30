package com.epam.rd.autotasks.figures;

abstract class Figure{
    Point A;
    Point B;
    Point C;
    Point D;
    double radius;

    public Figure() {

    }


    public abstract Point centroid();
    public abstract boolean isTheSame(Figure figure);
}
