import com.foo.*

println ""
println "Initial cascading insert"
println "=============="
def customerOrder = new CustomerOrder(customerName:'Bar Customer')
customerOrder.addToIpAddresses(new IpAddress(ipAddr:'10.0.0.1'))
customerOrder.addToIpAddresses(new IpAddress(ipAddr:'10.0.0.2'))
customerOrder.save(flush:true)
println customerOrder

println ""
println "update a child record - expecting an update or insert"
println "=============="
def lastIpAddr = null
customerOrder.ipAddresses.each{
    lastIpAddr = it
}
lastIpAddr.ipAddr='10.0.0.5'
customerOrder = customerOrder.save(flush:true)
println customerOrder

println ""
println "adding another IpAddress (may want to update a CustomerOrder field to controll table-execution/lock-order/flush-order)"
println "=============="
CustomerOrder.withTransaction {
  customerOrder.customerName = 'Quox Customer'
  customerOrder.save(flush:true)
  customerOrder.addToIpAddresses(new IpAddress(ipAddr:'10.0.0.10'))
  customerOrder = customerOrder.save(flush:true)
}
println customerOrder

println ""
println "show all IpAddress objects in the database (unordered)"
println "=============="
println IpAddress.list()

println ""
println "show all IpAddress objects (Domain object perpective ... retains ordering)"
println "=============="
customerOrder = CustomerOrder.findById(customerOrder.id)
println customerOrder.ipAddresses

println ""
println "Remove all - expecting a cascading delete behavior"
println "=============="
CustomerOrder.list().each{
    it.delete()
}