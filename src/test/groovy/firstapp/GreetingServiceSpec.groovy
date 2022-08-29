package firstapp

import grails.testing.services.ServiceUnitTest
import spock.lang.Specification

class GreetingServiceSpec extends Specification implements ServiceUnitTest<GreetingService>{

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }
}
