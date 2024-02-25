package in.dev.gmsk.service.impl;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import in.dev.gmsk.model.StudentModel;
import in.dev.gmsk.repository.StudentRepo;
import in.dev.gmsk.service.StudentService;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.stream.Stream;

import static in.dev.gmsk.util.DemoPDFStyle.*;

public class StudentServiceImpl implements StudentService {
    private static final StudentRepo STUDENT_REPO = new StudentRepo();

    @Override
    public Stream<StudentModel> getAllStudent() {
        return STUDENT_REPO.getAllStudent();
    }

    @Override
    public void makeHallTicket(String downloadPath) {

        Thread thread = new Thread( () -> {
            System.err.println( "Thread Name : " + Thread.currentThread().getName() );
            System.out.println( "Name : " + downloadPath );
            try {
                Document document = new Document();
                PdfWriter.getInstance( document, new FileOutputStream( downloadPath ) );
                document.open();
                addMetaData( document );
                addTitlePage( document );
                addContent( document );
                document.close();
            } catch (DocumentException | FileNotFoundException e) {
                throw new RuntimeException( e );
            }
        } );

        try {
            thread.start();
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException( e );
        }
    }

    @Override
    public PdfWriter downloadHallTicketPdfWriter(String downloadPath) throws FileNotFoundException, DocumentException {
        Document document = new Document();

        System.err.println( "Thread Name : " + Thread.currentThread().getName() );
        System.out.println( "Name : " + downloadPath );
        try {
            PdfWriter.getInstance( document, new FileOutputStream( downloadPath ) );
            document.open();
            addMetaData( document );
            addTitlePage( document );
            addContent( document );
            document.close();
        } catch (DocumentException | FileNotFoundException e) {
            throw new RuntimeException( e );
        }
        return PdfWriter.getInstance( document, new FileOutputStream( downloadPath ) );
    }
}
