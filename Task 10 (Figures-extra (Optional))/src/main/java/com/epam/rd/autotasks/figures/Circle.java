package com.epam.rd.autotasks.figures;

class Circle extends Figure {
    Point mid;
    double rad;

    public Circle(Point point, double i) {
        if (i<=0 || point == null) throw new IllegalArgumentException();
        mid = point;
        rad = i;
    }


    public double area() {
        return Math.PI*rad*rad;
    }


    public String pointsToString() {
        return "("+ mid.getX() +","+ mid.getY() +")";
    }

    @Override
    public String toString(){
        return "Circle[("+ mid.getX() +","+ mid.getY() +")"+ rad +"]";
    }


    public Point leftmostPoint() {
        return new Point(this.mid.getX()-rad,this.mid.getY());
    }

    @Override
    public Point centroid() {
        return mid;
    }

    @Override
    public boolean isTheSame(Figure figure) {
        return (this.getClass() == figure.getClass() && isEqual(mid.getX(),((Circle) figure).mid.getX())
                && isEqual(this.mid.getY(), ((Circle) figure).mid.getY())
                && isEqual(this.rad, ((Circle) figure).rad));
    }

    public static boolean isEqual(double d1, double d2) {
        return d1 == d2 || isRelativelyEqual(d1,d2);
    }

    private static boolean isRelativelyEqual(double d1, double d2) {
        return 0.0000001 > Math.abs(d1- d2) / Math.max(Math.abs(d1), Math.abs(d2));
    }
}
