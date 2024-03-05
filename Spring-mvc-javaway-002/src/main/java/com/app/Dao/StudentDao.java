package com.app.Dao;

import com.app.Model.Student;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

@Repository
@AllArgsConstructor
public class StudentDao {
    JdbcTemplate jdbcTemplate;

    public List<Student> getAllStudent(){
        String queryy = "select * from Registration.Persion";
        List<Student> students = jdbcTemplate.query(queryy,rs -> {
            List<Student> studentList  = new ArrayList<>();
            while (rs.next()){
                Student student = Student.builder()
                        .StudentId(rs.getInt("id"))
                        .StudentName(rs.getNString("name"))
                        .StudentCity(rs.getNString("city"))
                        .StudentPhone(rs.getInt("phone"))
                        .build();
                studentList.add(student);

            }
            return studentList;
        });
        return students;

    }

    public Student getStudentById(int StudentId){
        String querry1 = "select * from Registration.Persion where id="+StudentId;
        return jdbcTemplate.queryForObject(querry1,(rs, rowNum) -> Student.builder()
                .StudentId(rs.getInt("id"))
                .StudentName(rs.getNString("name"))
                .StudentCity(rs.getNString("city"))
                .StudentPhone(rs.getInt("phone"))
                .build() );

    }

    public List<Student> getAllStudentByAllfield(Student student){
        String query= "select * from Registration.Persion where id like ? or name like ? or city like ? or phone like ?";
        PreparedStatementSetter pss = (ps -> {
            ps.setInt(1,student.getStudentId());
            ps.setString(2,student.getStudentName());
            ps.setString(3,student.getStudentCity());
            ps.setInt(4,student.getStudentPhone());
        });
        ResultSetExtractor<?extends List<Student>> rm = rs -> {
            List<Student> studentList = new ArrayList<>();
            while (rs.next()){
                Student student1 = Student.builder()
                        .StudentId(rs.getInt("id"))
                        .StudentName(rs.getNString("name"))
                        .StudentCity(rs.getNString("city"))
                        .StudentPhone(rs.getInt("phone"))
                        .build();
                studentList.add(student);
            }return studentList;
        };
        return jdbcTemplate.query(query,pss,rm);
    }


    public void addStudent(Student student){
        String querry = "insert into Registration.Persion(id,name,city,phone) values(?,?,?,?)";
        jdbcTemplate.update(querry,ps -> {
            ps.setInt(1,student.getStudentId());
            ps.setString(2,student.getStudentName());
            ps.setString(3,student.getStudentCity());
            ps.setInt(4,student.getStudentPhone());

        });
    }

}
