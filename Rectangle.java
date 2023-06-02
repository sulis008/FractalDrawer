// Written by Alexander Sulistyo, sulis008
import java.awt.Color;
public class Rectangle {
    private double xpos;
    private double ypos;
    private double width;
    private double height;
    private Color color;
    public Rectangle(double x, double y, double w, double h) {
        xpos = x;
        ypos = y;
        width = w;
        height = h;
        color = new Color(0,0,0);
    }
    public double calculatePerimeter() {
        return ((2 * width) + (2 * height));
    }
    public double calculateArea() {
        return (width * height);
    }
    public void setColor(Color c) {
        color = c;
    }
    public void setPos(double x, double y) {
        xpos = x;
        ypos = y;
    }
    public void setHeight(double h) {
        height = h;
    }
    public void setWidth(double w) {
        width = w;
    }
    public Color getColor() {
        return color;
    }
    public double getXPos() {
        return xpos;
    }
    public double getYPos() {
        return ypos;
    }
    public double getHeight() {
        return height;
    }
    public double getWidth() {
        return width;
    }
}
