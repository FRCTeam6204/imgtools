package org.team6204.frc.imgtools;

import org.opencv.core.Size;

/**
 *
 * ImageProperties represents the location, resolution, and scale of an image in a larger plane.
 *
 */

public class ImageProperties {
    private double x, y, width, height;
    private double scaleFactor = 1;

    private ImageProperties(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public ImageProperties(double x, double y, double width, double height) {
        this(x, y);
        this.width = width;
        this.height = height;
    }

    public ImageProperties(double x, double y, double scaleFactor) {
        this(x, y);
        this.scaleFactor = scaleFactor;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double[] getPos() {
        return new double[] { x, y };
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public Size getSize() {
        return new Size(width, height);
    }

    public double getScaleFactor() {
        return scaleFactor;
    }

}
