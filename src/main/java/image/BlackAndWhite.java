package image;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

class BlackAndWhiteTest {


    public static void main(String[] args) throws IOException {

        File file = new File(Paths.get("resources/image/geral.jpg").toAbsolutePath().toString());

        BufferedImage orginalImage = ImageIO.read(file);

        BufferedImage blackAndWhiteImg = new BufferedImage(
                orginalImage.getWidth(), orginalImage.getHeight(),
                BufferedImage.TYPE_BYTE_BINARY);

        Graphics2D graphics = blackAndWhiteImg.createGraphics();
        graphics.drawImage(orginalImage, 0, 0, null);

        ImageIO.write(blackAndWhiteImg, "png", new File(Paths.get("resources/image/geral_W_B.jpg").toAbsolutePath().toString()));
    }

}
