package in.dev.gmsk.repository;

import in.dev.gmsk.model.JDBCModel;
import in.dev.gmsk.model.StudentModel;
import in.dev.gmsk.util.SQL_Constraints;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StudentRepo {

    public Stream<StudentModel> getAllStudent() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<StudentModel> returnList = new ArrayList<>();

        try {
            connection = JDBCConnection.getJDBCConnection( JDBCModel.getJDBCModelInstance() );
            preparedStatement = connection.prepareStatement( SQL_Constraints.GET_ALL_STUDENT_LIST );
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                StudentModel model = new StudentModel();
                model.setStudentName( resultSet.getString( "studentName" ) );
                model.setRollNo( resultSet.getString( "rollNo" ) );
                model.setGender( resultSet.getString( "gender" ) );
                model.setDob( resultSet.getString( "dob" ) );
                model.setClassName( resultSet.getString( "className" ) );
                model.setSpecializationName( resultSet.getString( "specializationName" ) );
                model.setSectionName( resultSet.getString( "sectionName" ) );
                model.setAvatarURL( resultSet.getString( "avatarURL" ) );
                model.setDate( resultSet.getString( "date" ) );
                model.setSubjectName( resultSet.getString( "subjectName" ) );
                returnList.add( model );
            }

        } catch (Exception e) {
            e.printStackTrace( System.out );
        } finally {
            try {
                if (null != resultSet && resultSet.isClosed()) {
                    resultSet.close();
                }
                if (null != preparedStatement && preparedStatement.isClosed()) {
                    preparedStatement.isClosed();
                }
                if (null != connection && connection.isClosed()) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace( System.out );
            }
        }
        return returnList.parallelStream();
    }
}
