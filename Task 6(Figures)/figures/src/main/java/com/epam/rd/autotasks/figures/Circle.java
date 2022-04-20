package com.epam.rd.autotasks.figures;

class Circle extends Figure{
    Point center;
    double radius;
    public Circle(Point center, double radius){
        this.center = center;
        this.radius = radius;
    }

    @Override
    public double area() {
        return 3.141592653589793 * Math.pow(radius, 2);
    }

    @Override
    public String pointsToString() {
        return "("+center.getX()+","+center.getY()+")";
    }
    @Override
    public String toString() {
        return this.getClass().getSimpleName()+"[("+center.getX()+","
                +center.getY()+")"+radius+"]";
    }

    @Override
    public Point leftmostPoint() {
        return new Point(center.getX()-radius, center.getY());
    }
}
// TODO: 17.04.2022
//  * №1) Сделать корректную проверку самой левой точки
//  * №2) Доделать для треугольника
//  * №3) Запустить программу)
//  *
//  *
