package in.dev.gmsk.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class StudentModel {

    private String studentName;
    private String rollNo;
    private String gender;
    private String dob;
    private String className;
    private String specializationName;
    private String sectionName;
    private String date;
    private String avatarURL;
    private String subjectName;
}
