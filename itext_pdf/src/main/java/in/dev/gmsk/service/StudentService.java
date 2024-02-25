package in.dev.gmsk.service;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import in.dev.gmsk.model.StudentModel;

import java.io.FileNotFoundException;
import java.util.stream.Stream;

public interface StudentService {

    Stream<StudentModel> getAllStudent();

    void makeHallTicket(String downloadPath);

    PdfWriter downloadHallTicketPdfWriter(String downloadPath) throws FileNotFoundException, DocumentException;
}
