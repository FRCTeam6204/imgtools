import org.team6204.frc.imgtools.ImageProperties;
import org.team6204.frc.imgtools.ImageBoard;

import org.opencv.core.Core;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.core.Mat;

/**
 * This example uses three images and cycles through them, placing them in the bottom left and right
 * of a root image at one third size.
 */

public class ThreeImageExample {
    public static void main(String args[]) throws Exception {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Mat[] imgs = new Mat[] {
            Imgcodecs.imread("img/sample_0.jpg"),
            Imgcodecs.imread("img/sample_1.jpg"),
            Imgcodecs.imread("img/sample_2.jpg")
        };

        ImageProperties[] props = new ImageProperties[] {
            new ImageProperties(0, 0, 1/3f),
            new ImageProperties(0, 159, 1/3f)
        };

        ImageBoard board = new ImageBoard(props);
        Imgcodecs.imwrite("out/example_0.jpg", board.draw(imgs));

        Imgcodecs.imwrite("out/example_1.jpg", board.draw(rotate(imgs, 1)));

        Imgcodecs.imwrite("out/example_2.jpg", board.draw(rotate(imgs, 2)));

    }

    private static Mat[] rotate(Mat[] array, int amount) {
        int arrayLen = array.length;
        Mat[] tmp = new Mat[arrayLen];
        for(int i = 0; i <= arrayLen-1; i++){
            tmp[ (i+amount) % arrayLen ] = array[i];
        }
        return tmp;
    }
}
