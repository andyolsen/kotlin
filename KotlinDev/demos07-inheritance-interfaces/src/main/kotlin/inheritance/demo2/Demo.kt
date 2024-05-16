package inheritance.demo2

// This class is implicitly closed, i.e. it cannot be subclassed.
class AuthenticationManager

// This won't work:
//class SpecialAuthenticationManager : AuthenticationManager()

// This class is explicitly open, i.e. it can be subclassed.
open class Customer

// This works:
class VipCustomer : Customer()
