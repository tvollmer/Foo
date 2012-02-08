package com.foo

class CustomerOrder {

    List ipAddresses

    static constraints = {
    }

    static hasMany = [ipAddresses:IpAddress]

    static mapping = {
        ipAddresses cascade:'all-delete-orphan'
    }

    String toString(){
        "id:$id,ipAddresses:$ipAddresses"
    }
}
