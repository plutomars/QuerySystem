package query.model;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * @author fyyang
 * @version 1.0 畫面列印並打開資料夾
 */
public class ScreenCapture {
	public static void capture(String title, Point point, Dimension dimension) {
		String desktopPath = System.getProperty("user.home");
		if (!new File(desktopPath + File.separator + "整合查詢").exists()) {
			new File(desktopPath + File.separator + "整合查詢").mkdir();
			desktopPath = desktopPath + File.separator + "整合查詢"
					+ File.separator;
		} else
			desktopPath = desktopPath + File.separator + "整合查詢"
					+ File.separator;
		// System.out.print(desktopPath.replace("\\", "/"));
		String outFileName = desktopPath + title + ".jpg";

		Rectangle screenRect = new Rectangle(point, dimension);

		// save captured image to JPG file
		try {
			// create screen shots
			Robot robot = new Robot();
			BufferedImage image = robot.createScreenCapture(screenRect);
			ImageIO.write(image, "jpg", new File(outFileName));

			File file = new File(outFileName);

			if ((file.exists())) {
				try {
					Runtime.getRuntime().exec(
							"explorer " + file.getAbsoluteFile().getParent());
				} catch (IOException ioe) {
					// do something
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
