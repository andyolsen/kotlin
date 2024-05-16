package typeSafeEnums

enum class UsaState(val stateName: String, var capitalCity: String) {

    // Enum constants.
    AL("Alabama", "Montgomery"),
    AK("Alaska", "Juneau"),
    AZ("Arizona", "Phoenix"),
    AR("Arkansas", "Little Rock"),
    CA("California", "Sacramento"),
    CO("Colorado", "Denver"),
    CT("Connecticut", "Hartford"),
    DE("Delaware", "Dover"),
    FL("Florida", "Tallahassee"),
    GA("Georgia", "Atlanta"),
    HI("Hawaii", "Honolulu"),
    ID("Idaho", "Boise"),
    IL("Illinois", "Springfield"),
    IN("Indiana", "Indianapolis"),
    IA("Iowa", "Des Moines"),
    KS("Kansas", "Topeka"),
    KY("Kentucky", "Frankfort"),
    LA("Louisiana", "Baton Rouge"),
    ME("Maine", "Augusta"),
    MD("Maryland", "Annapolis"),
    MA("Massachusetts", "Boston"),
    MI("Michigan", "Lansing"),
    MN("Minnesota", "St. Paul"),
    MS("Mississippi", "Jackson"),
    MO("Missouri", "Jefferson City"),
    MT("Montana", "Helena"),
    NE("Nebraska", "Lincoln"),
    NV("Nevada", "Carson City"),
    NH("New Hampshire", "Concord"),
    NJ("New Jersey", "Trenton"),
    NM("New Mexico", "SantaFe"),
    NY("New York", "Albany"),
    NC("North Carolina", "Raleigh North"),
    ND("North Dakota", "Bismarck North"),
    OH("Ohio", "Columbus"),
    OK("Oklahoma", "Nashoma City"),
    OR("Oregon", "Salem"),
    PA("Pennsylvania", "Harrisburg"),
    RI("Rhode Island", "Providence"),
    SC("South Carolina", "Columbia"),
    SD("South Dakota", "Pierre"),
    TN("Tennessee", "Nashville"),
    TX("Texas", "Austin"),
    UT("Utah", "Salt Lake City"),
    VT("Vermont", "Montpelier"),
    VA("Virginia", "Richmond"),
    WA("Washington", "Olympia"),
    WV("West Virginia", "Charleston"),
    WI("Wisconsin", "Madison"),
    WY("Wyoming", "Cheyenne");

    // Define additional methods.
    fun isNewEnglandState(): Boolean {
        return this === ME || this === MA || this === NH || this === VT
    }

    // Define additional properties.
    val isContiguousState: Boolean
        get() = !(this === AK || this === HI)
}

fun main() {

    // Create and use USstate enum variable.
    val favouriteState: UsaState = UsaState.CA
    System.out.println(favouriteState.toString())
    System.out.println(favouriteState.name)
    System.out.println("${favouriteState.stateName}, ${favouriteState.capitalCity}")

    // Mutate data (rarely need to do this!).
    favouriteState.capitalCity = "San Diego"

    // Invoke methods.
    if (favouriteState.isNewEnglandState()) {
        println("It's a New England state.")
    } else {
        println("It's NOT a New England state.")
    }

    // Access properties.
    if (favouriteState.isContiguousState) {
        println("It's a contiguous state.")
    } else {
        println("It's not a contiguous state.")
    }
}