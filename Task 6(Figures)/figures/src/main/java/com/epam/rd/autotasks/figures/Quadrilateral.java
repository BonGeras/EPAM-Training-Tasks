package com.epam.rd.autotasks.figures;

class Quadrilateral extends Figure {
    Point A;
    Point B;
    Point C;
    Point D;
    public Quadrilateral(Point A, Point B, Point C, Point D) {
        this.A = A;
        this.B = B;
        this.C = C;
        this.D = D;
    }

    @Override
    public double area() {
        double areaABC = Math.abs(
                (B.getX()-A.getX())*(C.getY() - A.getY())
                        - (C.getX() - A.getX())*(B.getY() - A.getY())
        ) / 2;
        double areaACD = Math.abs(
                (C.getX()-A.getX())*(D.getY() - A.getY())
                        - (D.getX() - A.getX())*(C.getY() - A.getY())
        ) / 2;
        return areaABC+areaACD;
    }

    @Override
    public String pointsToString() {
        return "("+A.getX()+","+A.getY()+")("+B.getX()+","+B.getY()
                +")("+C.getX()+","+C.getY()+")("+D.getX()+","+D.getY()+")";
    }
    @Override
    public String toString() {
        return this.getClass().getSimpleName()+"[("+A.getX()+","+A.getY()+")("+B.getX()+","+B.getY()
                +")("+C.getX()+","+C.getY()+")("+D.getX()+","+D.getY()+")]";
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
            } else if (leftmostPointX > D.getX()) {
                leftmostPointX = D.getX();
                leftmostPointY = D.getY();
            }
        }
        return new Point(leftmostPointX, leftmostPointY);
    }
}
