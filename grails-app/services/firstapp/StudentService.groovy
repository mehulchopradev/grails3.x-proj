package firstapp

import grails.gorm.transactions.Transactional

@Transactional
class StudentService {

    Student createStudent(Student student) {
        try {
            student.save(flush: true, failOnError: true)
        } catch (e) {
            e.printStackTrace()
            throw e
        }
    }

    Student authenticate(String username, String password) {
        Student.findByUsernameAndPassword(username, password)
    }
}
