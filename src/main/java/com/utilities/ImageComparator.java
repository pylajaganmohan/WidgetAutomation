package com.utilities;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageComparator {

	public static boolean compareImages(String expectedPath, String actualPath) throws IOException {
		BufferedImage expected = ImageIO.read(new File(expectedPath));
		BufferedImage actual = ImageIO.read(new File(actualPath));
		int tolerance = 100;
		
		if (expected.getWidth() != actual.getWidth() || expected.getHeight() != actual.getHeight()) {
			System.out.println("Image dimensions do not match.");
			return false;
		}

		int mismatchedPixels = 0;

		for (int x = 0; x < expected.getWidth(); x++) {
			for (int y = 0; y < expected.getHeight(); y++) {
				if (expected.getRGB(x, y) != actual.getRGB(x, y)) {
					mismatchedPixels++;
					if (mismatchedPixels > tolerance) {
						System.out.println("Too many mismatched pixels: " + mismatchedPixels);
						return false;
					}
				}
			}
		}

		return true;
	}
}