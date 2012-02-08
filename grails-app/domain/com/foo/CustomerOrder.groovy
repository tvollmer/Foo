package com.foo

class CustomerOrder {

    String customerName
//    List ipAddresses

    static constraints = {
        customerName size:5..48
        ipAddresses()
    }

    static hasMany = [ipAddresses:IpAddress]

    // http://grails.org/doc/2.0.x/ref/Database%20Mapping/cascade.html
    // http://docs.redhat.com/docs/en-US/JBoss_Enterprise_Web_Platform/5/html/Hibernate_Entity_Manager_Reference_Guide/objectstate-transitive.html 
    static mapping = {
//        ipAddresses cascade:'all,all-delete-orphan'
    }
    
    String toString(){
        "id:$id,ipAddresses:$ipAddresses"
    }
}
