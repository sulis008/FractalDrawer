// Written by Alexander Sulistyo, sulis008
import java.awt.Color;
public class Triangle {
    private double xpos;
    private double ypos;
    private double width;
    private double height;
    private Color color;
    public Triangle(double x, double y, double w, double h) {
        xpos = x;
        ypos = y;
        width = w;
        height = h;
        color = new Color(0,0,0);
    }
    public double calculatePerimeter() {
        return (3 * width);
    }
    public double calculateArea() {
        return (0.5 * width * height);
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
