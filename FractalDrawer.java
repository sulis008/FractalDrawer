// Written by Alexander Sulistyo, sulis008
// FractalDrawer class draws a fractal of a shape indicated by user input
import java.awt.Color;
import java.util.Random;
import java.util.Scanner;

public class FractalDrawer {
    private double totalArea;// member variable for tracking the total area
    public FractalDrawer() {
        totalArea = 0;
    }  // constructor


    //TODO:
    // drawFractal creates a new Canvas object
    // and determines which shapes to draw a fractal by calling appropriate helper function
    // drawFractal returns the area of the fractal
    public double drawFractal(String type) {
        Canvas canvas = new Canvas(1000, 1000);
        if (type.equals("Triangle")) {
            Triangle triangle = new Triangle(375, 600, 250, 250);
            triangle.setColor(newColor());
            drawTriangleFractal(triangle, canvas, 7); // Starts a triangle fractal at the first level, 7.
            return totalArea;
        } else if (type.equals("Circle")) {
            Circle circle = new Circle(500, 400, 125);
            circle.setColor(newColor());
            drawCircleFractal(circle, canvas, 7); // Starts a circle fractal at the first level, 7.
            return totalArea;
        } else if (type.equals("Rectangle")) {
            Rectangle rect = new Rectangle(375, 375, 250, 125);
            rect.setColor(newColor());
            drawRectangleFractal(rect, canvas, 7); // Starts a rectangle fractal at the first level, 7.
            return totalArea;
        } else {
            System.out.println("Incorrect shape type. Try again!"); // Let user know if an incorrect input was given!
            return totalArea;
        }
    }
    public Color newColor() { // Created a helper method, one in which returns a random color for the next shape.
        Random random = new Random();
        float r = random.nextFloat();
        float g = random.nextFloat();
        float b = random.nextFloat();
        return new Color(r, g, b);
    }
    //TODO:
    // drawTriangleFractal draws a triangle fractal using recursive techniques
    public void drawTriangleFractal(Triangle tri, Canvas can, int level) { // Changed arguments, made more sense to me.
        if (level == 0) { // If it's the last level, be done with it!
        } else if (level == 7){ // If it's the first level, print the very first shape as so.
            can.drawShape(tri);
            this.totalArea += tri.calculateArea();
            drawTriangleFractal(tri, can, level - 1);
        } else {
            Triangle left = new Triangle(tri.getXPos()-(tri.getWidth()/2), tri.getYPos(), tri.getWidth()/2, tri.getHeight()/2);
            Triangle right = new Triangle(tri.getXPos()+tri.getWidth(), tri.getYPos(), tri.getWidth()/2, tri.getHeight()/2);
            Triangle top = new Triangle(tri.getXPos()+(tri.getWidth()/2)-(tri.getWidth()/4), tri.getYPos()-tri.getHeight(), tri.getWidth()/2, tri.getHeight()/2);
            this.totalArea += (left.calculateArea() + right.calculateArea() + top.calculateArea());
            left.setColor(newColor());
            right.setColor(newColor());
            top.setColor(newColor());
            can.drawShape(left);
            can.drawShape(right);
            can.drawShape(top);
            drawTriangleFractal(left, can, level - 1); // Send each new triangle to be performed on individually.
            drawTriangleFractal(right, can, level - 1);
            drawTriangleFractal(top, can, level - 1);
        }
    }

    // TODO:
    // drawCircleFractal draws a circle fractal using recursive techniques
    public void drawCircleFractal(Circle circle, Canvas can, int level) { // Changed arguments, identical to Triangle
        if (level == 0) {
        } else if (level == 7) {
            can.drawShape(circle);
            this.totalArea += circle.calculateArea();
            drawCircleFractal(circle, can, level - 1);
        } else {
            Circle left = new Circle(circle.getXPos()-(1.5*circle.getRadius()), circle.getYPos(), circle.getRadius()/2);
            Circle right = new Circle(circle.getXPos()+(1.5*circle.getRadius()), circle.getYPos(), circle.getRadius()/2);
            Circle top = new Circle(circle.getXPos(), circle.getYPos()+(1.5*circle.getRadius()), circle.getRadius()/2);
            Circle bottom = new Circle(circle.getXPos(), circle.getYPos()-(1.5*circle.getRadius()), circle.getRadius()/2);
            this.totalArea += (left.calculateArea()+right.calculateArea()+top.calculateArea()+bottom.calculateArea());
            left.setColor(newColor());
            right.setColor(newColor());
            top.setColor(newColor());
            bottom.setColor(newColor());
            can.drawShape(left);
            can.drawShape(right);
            can.drawShape(top);
            can.drawShape(bottom);
            drawCircleFractal(left, can, level - 1);
            drawCircleFractal(right, can, level - 1);
            drawCircleFractal(top, can, level - 1);
            drawCircleFractal(bottom, can, level - 1);
        }
    }


    //TODO:
    // drawRectangleFractal draws a rectangle fractal using recursive techniques
    public void drawRectangleFractal(Rectangle rect, Canvas can, int level) { // Identical changes to circle and triangle
        if (level == 0) {
        } else if (level == 7) {
            can.drawShape(rect);
            this.totalArea += rect.calculateArea();
            drawRectangleFractal(rect, can, level - 1);
        } else {
            Rectangle topLeft = new Rectangle(rect.getXPos()-(0.5*rect.getWidth()), rect.getYPos()-(0.5*rect.getHeight()), 0.5*rect.getWidth(), 0.5*rect.getHeight());
            Rectangle topRight = new Rectangle(rect.getXPos()+rect.getWidth(), rect.getYPos()-(0.5*rect.getHeight()), 0.5*rect.getWidth(), 0.5*rect.getHeight());
            Rectangle bottomLeft = new Rectangle(rect.getXPos()-(0.5*rect.getWidth()), rect.getYPos()+rect.getHeight(), 0.5*rect.getWidth(), 0.5*rect.getHeight());
            Rectangle bottomRight = new Rectangle(rect.getXPos()+rect.getWidth(), rect.getYPos()+rect.getHeight(), 0.5*rect.getWidth(), 0.5*rect.getHeight());
            this.totalArea += (topLeft.calculateArea() + topRight.calculateArea() + bottomLeft.calculateArea() + bottomRight.calculateArea());
            topLeft.setColor(newColor());
            topRight.setColor(newColor());
            bottomLeft.setColor(newColor());
            bottomRight.setColor(newColor());
            can.drawShape(topLeft);
            can.drawShape(topRight);
            can.drawShape(bottomLeft);
            can.drawShape(bottomRight);
            drawRectangleFractal(topLeft, can, level - 1);
            drawRectangleFractal(topRight, can, level - 1);
            drawRectangleFractal(bottomLeft, can, level - 1);
            drawRectangleFractal(bottomRight, can, level - 1);
        }
    }

    //TODO:
    // main should ask user for shape input, and then draw the corresponding fractal.
    // should print area of fractal
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Circle, Triangle or Rectangle? : ");
        String input = scan.nextLine();
        boolean correct = (input.equals("Circle"))||(input.equals("Triangle"))||(input.equals("Rectangle"));
        // ^ Used a boolean here to clean up my if block a little bit. I tend to do this for personal satisfaction. ^
        if (correct) {
            FractalDrawer drawing = new FractalDrawer();
            drawing.drawFractal(input); // This runs the whole program, which takes the most processing power.
            System.out.println("Total Area = " + drawing.totalArea + "px^2");
        } else {
            System.out.println("Incorrect Option!"); // Two input checks: one in the main method, and one in drawFractal
        }
    }
}
