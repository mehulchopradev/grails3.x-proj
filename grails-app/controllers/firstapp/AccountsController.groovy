package firstapp

import java.time.LocalTime

// /accounts
class AccountsController {

    static layout = 'public'

    // Dependency injection (DI)
    // Spring IOC container (inversion of control)
    GreetingService greetingService

    StudentService studentService

    // /login
    def login() {
        // new GreetingService().greetingOfDay() // never ever do this!

        // def regSuccess = params['regSuccess']

        [greeting: greetingService.greetingOfDay()]
    }

    def register() {
        // Imagine countries data coming from a database
        def countriesMap = ['IN': 'India', 'USA': 'United states of america', 'AU': 'Australia']
        [countries: countriesMap]
    }

    def createUser() {
        // controller - implicit object - params, flash
        // println params // has the request parameters submitted by the user, stored as a map
        /* def username = params['username']
        def password = params['password']
        def country = params['country']
        def gender = params['gender'] */

        // def s1 = new Student(username: username, password: password, country: country, gender: gender)
        def s1 = new Student(params)
        /* def student = s1.save(flush: true)
        if (student) {
            // flash scope object remembers data for one more request
            flash.message = 'Hey thank you for registering. Please go ahead and login'
            redirect action: 'login'
        } else {
            flash.message = "Something went wrong. Please check the data"
            redirect action: 'register'
        } */
        try {
            // s1.save(flush: true, failOnError: true)
            studentService.createStudent(s1)
            flash.message = 'Hey thank you for registering. Please go ahead and login'
            redirect action: 'login'
        } catch (e) {
            render "Error"
        }

        // does not render any HTML view of its own
        // rather instructs the client to redirect the user to the login action
        // redirect action:'login', params: ['regSuccess': 1]
    }

    def auth(String username, String password) {
        // def username = params['username']
        // def password = params['password']

        def student = studentService.authenticate(username, password)
        if (student) {
            session.user = student
            redirect controller: 'home'
        } else {
            flash.message = "Invalid username or password"
            redirect action: 'login'
        }
    }

    def logout() {
        // invalidate the session
        session.invalidate()

        redirect action: 'login'
    }

    def profile() {
        def countriesMap = ['IN': 'India', 'USA': 'United states of america', 'AU': 'Australia']
        [countries: countriesMap]
    }

    def updateProfile() {
        /* def country = params['country']
        def gender = params['gender']
        def mobile = params['mobile']
        def websiteUrl = params['websiteUrl'] */

        def student = session.user // untracked GORM object
        student.attach() // make it tracked by attaching to the hibernate session
        student.properties = params
        // student.contact.properties = params
        /* student.country = country
        student.gender = gender
        student.contact.mobile = mobile */

        student.save(flush: true) // tracked state (Hibernate session)
        flash.message = "Profile update successfully"
        redirect action: 'profile'
    }
}
