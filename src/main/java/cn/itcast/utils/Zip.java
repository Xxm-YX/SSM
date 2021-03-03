package cn.itcast.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Zip {

    public static File unzip(MultipartFile file) throws Exception{
        byte[] buffer = new byte[1024];
        int bufferSize = 1024;
        File tempFile = null;
        ZipInputStream zis = new ZipInputStream(file.getInputStream());
        ZipEntry entry = null;
        while((entry = zis.getNextEntry()) != null){
            tempFile = File.createTempFile(entry.getName(),"tmp");
            tempFile.deleteOnExit();
            FileOutputStream fos = new FileOutputStream(tempFile);
            BufferedOutputStream bos = new BufferedOutputStream(fos,bufferSize);
            int count;
            while((count = zis.read(buffer, 0 , bufferSize)) != -1){
                bos.write(buffer, 0 , count);
            }
            bos.flush();
            bos.close();
        }
        zis.close();
        return tempFile;
    }
}
