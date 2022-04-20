package com.epam.rd.autotasks.figures;

class Triangle extends Figure{
    Point A;
    Point B;
    Point C;
    public Triangle(Point A, Point B, Point C) {
        this.A = A;
        this.B = B;
        this.C = C;
    }

    @Override
    public double area() {

        return Math.abs(
                (B.getX()-A.getX())*(C.getY() - A.getY())
                - (C.getX() - A.getX())*(B.getY() - A.getY())
        ) / 2;
    }

    @Override
    public String pointsToString() {
        return "("+A.getX()+","+A.getY()+")("+B.getX()+","+B.getY()
                +")("+C.getX()+","+C.getY()+")";
    }
    @Override
    public String toString() {
        return this.getClass().getSimpleName()+"[("+A.getX()+","+A.getY()+")("+B.getX()+
    ","+B.getY() +")("+C.getX()+","+C.getY()+")]";
    }

    @Override
    public Point leftmostPoint() {
        double leftmostPointX = A.getX();
        double leftmostPointY = A.getY();
        for (int i = 0; i < 4; i++) {
            if (leftmostPointX > B.getX()) {
                leftmostPointX = B.getX();
                leftmostPointY = B.getY();
            } else if (leftmostPointX > C.getX()) {
                leftmostPointX = C.getX();
                leftmostPointY = C.getY();
            }
        }
        return new Point(leftmostPointX, leftmostPointY);
    }
}
