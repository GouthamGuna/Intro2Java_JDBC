package in.dev.gmsk.controller;

import in.dev.gmsk.model.StudentModel;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentControllerTest {
    private static final StudentController CONTROLLER = new StudentController();

    @Test
    void getAllStudentList() {
        List<StudentModel> allStudentList = StudentController.getAllStudentList();
        assertNotNull( allStudentList );
        System.out.println( "allStudentList = " + allStudentList );
    }

    @Test
    void downloadHallTicket() {
        StudentController.downloadHallTicket();
        assertTrue( true );
    }

    @Test
    void testDownloadHallTicketZIPFile() throws IOException, InterruptedException {
        CONTROLLER.downloadHallTicketZIPFile();
        assertTrue( true );
    }
}