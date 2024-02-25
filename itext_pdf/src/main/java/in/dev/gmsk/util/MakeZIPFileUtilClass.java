package in.dev.gmsk.util;

import java.io.*;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class MakeZIPFileUtilClass {

    public static void MakeZIPFile(String srcFilesDir, String zipFileDir) throws IOException {
        System.out.println( "Inner Class MakeZIPFileUtilClass..." );

        FileOutputStream fos = new FileOutputStream( zipFileDir );
        ZipOutputStream zos = new ZipOutputStream( fos );

        File srcDir = new File( srcFilesDir );
        zipDirectory( srcDir, srcDir.getName(), zos );
    }

    private static void zipDirectory(File srcDir, String dirName, ZipOutputStream zos) throws IOException {
        if (srcDir.isHidden()) {
            return;
        }
        if (Objects.requireNonNull( srcDir.listFiles() ).length == 0) {
            zos.putNextEntry( new ZipEntry( dirName + "/" ) );
            zos.closeEntry();
        } else {
            for (File file : Objects.requireNonNull( srcDir.listFiles() )) {
                if (file.isDirectory()) {
                    zipDirectory( file, dirName + "/" + file.getName(), zos );
                } else {
                    zipFile( file, dirName + "/" + file.getName(), zos );
                }
            }
        }
    }

    private static void zipFile(File file, String fileName, ZipOutputStream zos) throws IOException {
        FileInputStream fis = new FileInputStream( file );
        ZipEntry zipEntry = new ZipEntry( fileName );
        zos.putNextEntry( zipEntry );
        byte[] buffer = new byte[1024];
        int length;
        while ((length = fis.read( buffer )) > 0) {
            zos.write( buffer, 0, length );
        }
        zos.closeEntry();
        fis.close();
    }
}
