# FRC Image Tools
FRC Image Tools is a Java library that assists with combining separate images using OpenCV, such as three cameras on an FRC robot.

## Usage
`org.team6204.frc.imgtools` provides two classes: ImageBoard and ImageProperties. ImageBoard initialises with an array of ImageProperties, and the ImageBoard.draw() instance method accepts an array of OpenCV Mats, returning a single Mat of combined Mats, using corresponding ImageProperties objects.

`examples` contains a simple example compositing two smaller images on top of a third image, using different combinations of three images (You may need to supply your own opencv_java library for it to work on your system).
