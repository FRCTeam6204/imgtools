package org.team6204.frc.imgtools;

import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;

/**
 * ImageBoard represents an assocation of multiple images on a single root image.
 * It uses ImageProperties with OpenCV to place images over the root image.
 */

public class ImageBoard {
    private ImageProperties[] props;

    public ImageBoard(ImageProperties[] props) {
        this.props = props;
    }

    /**
     * draw() takes an array of Mats of props.length + 1. The first Mat is treated as the root
     * element and is used as the background, and the others are associated with ImageProperties in
     * props at the same index.
     */
    public Mat draw(Mat[] imgs) throws IllegalStateException {
        int matLen = imgs.length;
        int expectedMatLen = props.length + 1;
        if (matLen != expectedMatLen) {
            throw new IllegalStateException
                    ("Length of Mat[] imgs incompatible with ImageProperties[] props: "
                     + matLen + " != " + expectedMatLen);
        }

        Mat[] newMats = new Mat[matLen];
        for (int i = 0; i < matLen; i++) newMats[i] = imgs[i].clone();
        Mat root = newMats[0];

        for (int img = 0; img < props.length; img++) {
            ImageProperties prop = props[img];
            Mat imgMat = newMats[img + 1];

            // Instead of storing the result of scaleDimensions, imgMat.size() is called to prevent
            // rounding errors later on
            Imgproc.resize(imgMat, imgMat, scaleDimensions(prop, imgMat.size()));
            Size imgSize = imgMat.size();

            Rect roi = new Rect(
                new double[] { prop.getX(), prop.getY(), imgSize.width, imgSize.height }
                );

            imgMat.copyTo(root.submat(roi));
        }

        return root;

    }

    private Size scaleDimensions(ImageProperties prop, Size size) {
        if (prop.getWidth() != 0 && prop.getHeight() != 0) {
            return prop.getSize();
        } else {
            double scaleFactor = prop.getScaleFactor();
            return new Size(size.width * scaleFactor, size.height * scaleFactor);
        }
    }

}
