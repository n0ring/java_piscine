package edu.school21.printer.logic;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.*;
import javax.imageio.ImageIO;

public class Printer {
	private int			width;
	private int			height;
	private char[][]	imageChar;

	public void setImageChar(String fileName, char blackPixel, char whitePixel) throws IOException {
		BufferedImage	image = ImageIO.read(new File(fileName));
		int				color;
		width = image.getWidth();
		height = image.getHeight();
 		imageChar = new char[height][width];
		for (int i = 0; i < height; i++) {
			for (int k = 0; k < width; k++) {
				color = image.getRGB(k, i);
				if (color == Color.BLACK.getRGB()) {
					imageChar[i][k] = blackPixel;
				}
				else {
					imageChar[i][k] = whitePixel;
				}
			}
		}
	}

	public void printImage() {
		for (int i = 0; i < height; i++) {
			System.out.println(imageChar[i]);
		}
	}
}
