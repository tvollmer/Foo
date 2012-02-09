import com.foo.*
import org.hibernate.SessionFactory;

class BootStrap {


    def init = { servletContext ->

        def custOrder = new CustomerOrder(customerName:'Foo Customer')
		custOrder.addToIpAddresses(new IpAddress(ipAddr:'10.0.0.1'))
		custOrder.addToIpAddresses(new IpAddress(ipAddr:'10.0.0.2'))
		custOrder.save(flush:true)
        println "$custOrder"
        
    }
    def destroy = {
    }
}
