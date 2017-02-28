package net.ricebean.tools.colorstrip;

import net.ricebean.tools.colorstrip.model.Patch;
import net.ricebean.tools.colorstrip.util.PatchGroup;
import org.junit.Test;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * JUnit test case for ColorStripBuilder.
 */
public class ColorStripFactoryTest {

    @Test
    public void genericStrip() throws Exception {

        // arrange
        ColorStripBuilder colorStripBuilder = ColorStripFactory.newColorStripBuilder();
        colorStripBuilder.addPatchGroup("GrayCon M i1", PatchGroup.grayConM());

        List<Patch> patches = new ArrayList<>(45);
        patches.add(new Patch(0, 100, 100, 50));
        patches.add(new Patch(100, 0, 100, 50));
        patches.add(new Patch(100, 100, 0, 50));
        patches.add(new Patch(0, 100, 100, 50));
        patches.add(new Patch(0, 0, 0, 50));
        patches.add(new Patch(0, 100, 0, 50));
        patches.add(new Patch(0, 0, 10, 50));
        patches.add(new Patch(0, 90, 0, 50));
        patches.add(new Patch(0, 0, 20, 50));
        colorStripBuilder.addPatchGroup("FYERALARM Custom", patches.toArray(new Patch[]{}));

        File file = Paths.get(
                "/home/stefan/Desktop/", "strip-10-" + System.currentTimeMillis() + ".pdf"
        ).toFile();

        // act
        colorStripBuilder.setPatchWidth(4);
        colorStripBuilder.setPatchHeight(10);
        colorStripBuilder.setFontSize(3);
        colorStripBuilder.setPatchWidthSpacer(6);
        colorStripBuilder.setTitle("FLYERALRM GaryCon M für Lisas Masterarbeit");
        colorStripBuilder.setDescription("Compatible to ECI/bvdm GrayCon Mi1");

        colorStripBuilder.build(file, 12345678L);

        // assert
        System.out.println("File: " + file.getAbsolutePath());
    }

    @Test
    public void tvi10Strip() throws Exception {

        // arrange
        File file = Paths.get(
                "/home/stefan/Desktop/", "tvi-10-" + System.currentTimeMillis() + ".pdf"
        ).toFile();

        // act
        ColorStripFactory.createTvi10Strip(12345678L, file);

        // assert
        System.out.println("File: " + file.getAbsolutePath());
    }

    @Test
    public void grayConStrip() throws Exception {

        // arrange
        File file = Paths.get(
                "/home/stefan/Desktop/", "grayCon-" + System.currentTimeMillis() + ".pdf"
        ).toFile();

        // act
        ColorStripFactory.createGrayConMi1(12345678L, file);

        // assert
        System.out.println("File: " + file.getAbsolutePath());
    }
}