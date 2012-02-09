import com.foo.*
import org.hibernate.SessionFactory;

class BootStrap {


    def init = { servletContext ->

        def ipAddrs = [] << new IpAddress(ipAddr:'10.0.0.1') << new IpAddress(ipAddr:'10.0.0.2')
        println "ipAddrs:$ipAddrs"
        def custOrder = new CustomerOrder(customerName:'Foo Customer',ipAddresses:ipAddrs).save(flush:true)
        println "$custOrder"
        
    }
    def destroy = {
    }
}
