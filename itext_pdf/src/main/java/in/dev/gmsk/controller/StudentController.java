package in.dev.gmsk.controller;

import in.dev.gmsk.model.StudentModel;
import in.dev.gmsk.service.StudentService;
import in.dev.gmsk.service.impl.StudentServiceImpl;
import in.dev.gmsk.util.MakeZIPFileUtilClass;

import java.io.*;
import java.util.List;

public class StudentController {
    private static final StudentService SERVICE = new StudentServiceImpl();

    static List<StudentModel> getAllStudentList() {
        return SERVICE.getAllStudent().toList();
    }

    static void downloadHallTicket() {

        getAllStudentList().forEach( s -> {
            String path = "D:\\work\\itext_pdf_gmsk\\" + s.getStudentName() + "_" + s.getClassName() + ".pdf";
            SERVICE.makeHallTicket( path );
        } );
    }

    void downloadHallTicketZIPFile() throws InterruptedException, IOException {

        MakePDFWriter pdfWriter = new MakePDFWriter();
        pdfWriter.start();

        synchronized (pdfWriter) {
            pdfWriter.wait( 60000 ); // 60,000 Milliseconds = 60 Seconds
            MakeZIPFileUtilClass.MakeZIPFile( "D:\\work\\itext_pdf_gmsk", "D:\\work\\mydir.zip" );
        }
    }

    private static class MakePDFWriter extends Thread {

        @Override
        public void run() {

            synchronized (this) {

                getAllStudentList().forEach( s -> {
                    String path = "D:\\work\\itext_pdf_gmsk\\" + s.getStudentName() + "_" + s.getClassName() + ".pdf";
                    SERVICE.makeHallTicket( path );
                } );

                this.notify();
            }
        }
    }
}
