mport net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class LocalOCR {
    public static void main(String[] args) {
        String path = "./xxx.png";//Add target image here.
        String testdataPath = "./testdata";//Add testdata file
        File file = new File(path);
        ITesseract instance = new Tesseract();
        instance.setDatapath(testdataPath);
        instance.setLanguage("eng");//Select language
        try{
            long start = System.currentTimeMillis();
            String result  = instance.doOCR(file);
            System.out.println(result);
            long end = System.currentTimeMillis();
            System.out.println("OCR time: " + (end - start) + "ms");
            File f = new File("./result.txt");//Generate result file
            FileOutputStream f1 = new FileOutputStream(f);
            OutputStreamWriter f2 = new OutputStreamWriter(f1);
            result = getMatch(result);
            f2.write(result);
            f2.flush();
            f2.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
