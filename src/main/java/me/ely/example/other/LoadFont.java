package me.ely.example.other;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/**
 * Java加载字体(操作系统中不存在的)
 * @author <a href="mailto:xiaochunyong@gmail.com">Ely</a>
 * @see
 * @since 2019/12/2
 */
public class LoadFont {
    public static void main(String[] args) throws IOException {

        try {
            //create the font to use. Specify the size!
            InputStream inputStream = LoadFont.class.getResourceAsStream("/simhei.ttf");
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, inputStream);// .deriveFont(12f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            //register the font
            ge.registerFont(customFont);

            System.out.println(Arrays.toString(ge.getAvailableFontFamilyNames()));
        } catch (IOException e) {
            e.printStackTrace();
        } catch(FontFormatException e) {
            e.printStackTrace();
        }

        BufferedImage image = new BufferedImage(320, 320, BufferedImage.TYPE_4BYTE_ABGR_PRE);
        Graphics2D g = image.createGraphics();
        g.setFont(new Font("SimHei", Font.BOLD, 24));
        g.drawString("你好", 100, 100);

        FileOutputStream fos = new FileOutputStream("/data/test-chinese.jpg");

        g.dispose();
        ImageIO.write(image, "jpg", fos);
        fos.close();
    }
}
