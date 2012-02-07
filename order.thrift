namespace java net.cantaloupe.thrift

enum Status {
        PENDING = 1
        DESPATCHED = 2
}

struct Order
{
        1: required i32 oid
        2: required double amount 
        3: optional Status status
}

