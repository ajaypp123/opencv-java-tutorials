/*
#################capture image from cam#################
*/
package application;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;
import org.opencv.highgui.VideoCapture;

class captua {
 public static void main(String[] args) {
  try {
   System.loadLibrary(Core.NATIVE_LIBRARY_NAME); //load opencv library
   VideoCapture camera = new VideoCapture(0); //capture image
   if (!camera.isOpened()) {
    System.out.println("Error");
   } else {
    Mat frame = new Mat(); //Store image in matrix form

    camera.read(frame);
    Highgui.imwrite("action.jpg", frame); //convert matrix into action.jpg image 

    try {
     File file = new File("action.jpg");
     BufferedImage image = ImageIO.read(file);
    }
    camera.release();
   } catch (Exception e) {}
  }
 }
}