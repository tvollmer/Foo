import com.foo.*
import org.hibernate.SessionFactory;

class BootStrap {

//    SessionFactory sessionFactory // <-- still trying to get transactions to work; along with the correct env.

    def init = { servletContext ->

//        def hibSession = sessionFactory.getCurrentSession()

	CustomerOrder.withTransaction{
	    def ipAddrs = [] << new IpAddress(ipAddr:'10.0.0.1')  << new IpAddress(ipAddr:'10.0.0.2')
	    println "ipAddrs:$ipAddrs"
            def savedCustOrder = new CustomerOrder(ipAddesses:ipAddrs).save(failOnError:true)
	    //new IpAddress(customerOrder:savedCustOrder,ipAddr:'10.0.0.1').save(failOnError:true)
	    //new IpAddress(customerOrder:savedCustOrder,ipAddr:'10.0.0.2').save(failOnError:true)
	    //println "${CustomerOrder.findById(savedCustOrder.id)}"
	    println "$savedCustOrder"
	}
    }
    def destroy = {
    }
}
