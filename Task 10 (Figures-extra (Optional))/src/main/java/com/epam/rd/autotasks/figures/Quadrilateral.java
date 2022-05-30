package com.epam.rd.autotasks.figures;

class Quadrilateral extends Figure {
    Point a,b,c,d;
    double a1, b11, c1, d1, d2;

    public Quadrilateral(Point point, Point point1, Point point2, Point point3) {
        a = point;
        b = point1;
        c = point2;
        d = point3;
        if (a == null || b == null || c== null || d == null) throw new IllegalArgumentException();
        a1 = length(a,b);
        b11 = length(c,b);
        c1 = length(c,a);
        d1 = length(c,d);
        d2 = length(a,d);

        double product1 = ((c.getX()-a.getX())*(b.getY()-a.getY()) - (c.getY()- a.getY())*(b.getX()-a.getX()));
        double product2 = ((c.getX()-a.getX())*(d.getY()-a.getY()) - (c.getY()- a.getY())*(d.getX()-a.getX()));
        if (product1>=0&&product2<=0 || product1<=0&&product2>=0)
        {
            product1 = ((d.getX()-b.getX())*(a.getY()-b.getY()) - (d.getY()- b.getY())*(a.getX()-b.getX()));
            product2 = ((d.getX()-b.getX())*(c.getY()-b.getY()) - (d.getY()- b.getY())*(c.getX()-b.getX()));
            if (product1>=0&&product2<=0 || product1<=0&&product2>=0) { }
            else
            {
                throw new IllegalArgumentException();
            }
        }
        else
        {
            throw new IllegalArgumentException();
        }

        if (!(a1 + 0.0001 < b11 + c1 && b11 + 0.0001< a1 + c1 && c1+ 0.0001< a1 + b11)) throw new IllegalArgumentException();
    }

    public double area() {
        double p = (a1 + b11 + c1) / 2.0;
        double _p = (c1 + d1 + d2) / 2.0;
        return Math.sqrt(p * (p - a1) * (p - b11) * (p - c1)) + Math.sqrt(_p * (_p - d1) * (_p - d2) * (_p - c1));
    }

    public String pointsToString() {
        return "("+ a.getX() +","+ a.getY() +")"+"("+ b.getX() +","+ b.getY() +")"+"("+ c.getX() +","+ c.getY() +")"+"("+ d.getX() +","+ d.getY() +")";
    }

    public String toString(){
        return "Quadrilateral[("+ a.getX() +","+ a.getY() +")"+"("+ b.getX() +","+ b.getY() +")"+"("+ c.getX() +","+ c.getY() +")"+"("+ d.getX() +","+ d.getY() +")]";
    }

    public Point leftmostPoint() {
        if (a.getX() != b.getX() && a.getX() <= c.getX() && a.getX() <= d.getX())
            return a;
        if (b.getX() <= a.getX() && b.getX() <= c.getX() && b.getX() <= d.getX())
            return b;
        if (c.getX() <= b.getX() && c.getX() <= a.getX() && c.getX() <= d.getX())
            return c;
        if (d.getX() <= b.getX() && d.getX() <= a.getX() && d.getX() <= c.getX())
            return d;
        return a;
    }

    double length(Point start, Point end) {
        double xDistanceSquare = Math.pow(start.getX() - end.getX(), 2);
        double yDistanceSquare = Math.pow(start.getY() - end.getY(), 2);
        return Math.sqrt(xDistanceSquare + yDistanceSquare);
    }

    @Override
    public Point centroid() {
        Point _1 = new Point((a.getX() + b.getX() + c.getX())/3.0,(a.getY() + b.getY() + c.getY())/3.0);
        Point _2 = new Point((a.getX() + d.getX() + c.getX())/3.0,(a.getY() + d.getY() + c.getY())/3.0);

        Point _3 = new Point((a.getX() + b.getX() + d.getX())/3.0,(a.getY() + b.getY() + d.getY())/3.0);
        Point _4 = new Point((c.getX() + b.getX() + d.getX())/3.0,(c.getY() + b.getY() + d.getY())/3.0);

        double k1 = (_2.getY() - _1.getY()) / (_2.getX() - _1.getX());
        double b1 = (_2.getX() * _1.getY() - _1.getX() * _2.getY()) / (_2.getX() - _1.getX());

        double k2 = (_4.getY() - _3.getY()) / (_4.getX() - _3.getX());
        double b2 = (_4.getX() * _3.getY() - _3.getX() * _4.getY()) / (_4.getX() - _3.getX());

        double centroidX = (b1 - b2) / (k2 - k1);
        double centroidY = k1 * centroidX + b1;

        return new Point(centroidX, centroidY);
    }

    @Override
    public boolean isTheSame(Figure figure) {
        if (!(this.getClass() == figure.getClass())) return false;
        Point[] basic1 = new Point[]{ a, b, c, d};
        Point[] basic2 = new Point[]{ ((Quadrilateral) figure).a, ((Quadrilateral) figure).b, ((Quadrilateral) figure).c, ((Quadrilateral) figure).d};
        bubbleSort(basic1);
        bubbleSort(basic2);
        if(isEqual(basic1[0].getX(),basic2[0].getX()) && isEqual(basic1[0].getY(),basic2[0].getY())
                && isEqual(basic1[1].getX(),basic2[1].getX()) && isEqual(basic1[1].getY(),basic2[1].getY())
                && isEqual(basic1[2].getX(),basic2[2].getX()) && isEqual(basic1[2].getY(),basic2[2].getY())
                && isEqual(basic1[3].getX(),basic2[3].getX()) && isEqual(basic1[3].getY(),basic2[3].getY())) return true;
        else return false;
    }

    public static boolean isEqual(double d1, double d2) {
        return d1 == d2 || isRelativelyEqual(d1,d2);
    }

    private static boolean isRelativelyEqual(double d1, double d2) {
        return 0.0000001 > Math.abs(d1- d2) / Math.max(Math.abs(d1), Math.abs(d2));
    }

    public static void bubbleSort(Point[] arr){
        for(int i = arr.length-1 ; i > 0 ; i--){
            for(int j = 0 ; j < i ; j++){
                if( arr[j].getX() > arr[j+1].getX() ){
                    Point tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }
}
