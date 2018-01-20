package auxillary.reader;
import org.apache.commons.io.IOUtils;

import java.io.*;

public class FileReader {

    public String getFile(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        String txt = "";
        File file;
        InputStream inputStream;
        try {
            file = new File(classLoader.getResource(fileName).getFile());
            inputStream = new FileInputStream(file);
            StringWriter writer = new StringWriter();
            IOUtils.copy(inputStream, writer);
            txt = writer.toString();

        } catch (NullPointerException | IOException e) {
            e.getMessage();
        }
        return txt;
    }
}
