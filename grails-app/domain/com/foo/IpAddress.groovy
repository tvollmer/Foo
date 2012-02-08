package com.foo

class IpAddress {

    String ipAddr

    static constraints = {
	ipAddr size:0..15
    }

    String toString() {
        "$ipAddr"
    }
}
