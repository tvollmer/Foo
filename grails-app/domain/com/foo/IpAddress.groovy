package com.foo

class IpAddress {

	CustomerOrder customerOrder
    String ipAddr

    static constraints = {
        ipAddr size:0..15
    }

    // as soon as we add a back-reference to the One
    // side of the OneToMany relationship, we get
    // two tables instead of three, and the cascading
    // insert/update/deletes no longer work.
//    static belongsTo = CustomerOrder
    static belongsTo = [customerOrder:CustomerOrder]

    String toString() {
        "$ipAddr"
    }
}
