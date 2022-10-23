// Here we learn about different concepts
// Just import class and its all functions will also
// import even they are not inside class
import org.jsoup.Jsoup
import java.io.File


fun main() {
}


// Extensions
fun myExtension(){
    // This function is actually an extension removeFirstLastChar i made
    fun String.removeFirstLastChar():String = this.substring(1,this.length-1)

    print("Hello World".removeFirstLastChar())
}

fun myMutableList() : MutableList<String>{
    var a  = mutableListOf<String>("Apples","Mangoes")
    a.add("oranges")
    return a
}

/*---------------- LAMBDA--------------*/
val myLambada = { x: Int, y: Int ->
    "Hello Now I am returning UNIT"
//    (x+y)*0.00001
}


/*MOVIES SCRAPPER*/
fun lookMovie() {
    // Val cannot be Modified, Var can be modified later
    val url = "https://lookmovie2.to/"
    // Mutable list are editable, u can add remove , you can specify types e.g String,Int,Double,Any
    val movies = mutableListOf<Any>()

    val doc = Jsoup.connect(url).get()
    val titles = doc.getElementsByClass("mv-item-infor")
    for (i in titles) {
        movies.add(i.text())
    }
    print(movies)
}

/*------------------STRING MANUPULATION----------------*/

fun stringFun(): String {
// Regex to match any string starting with 'a'
    val pattern1 = Regex("^a")
    println(pattern1.containsMatchIn("abc"))
    println(pattern1.containsMatchIn("bac"))


// Regex to match "ll" in a string
    val pattern2 = Regex("ll")
    val ans1: MatchResult? = pattern2.find("abc")
    println(ans1?.value)


//	Tests demonstrating split function
    val pattern3 = Regex("\\s+")  // separate for white-spaces
    val ans2: List<String> = pattern3.split("This is a sentence")
    ans2.forEach { word -> println(word) }


// TO Find Text in between
    val s = "12Imran34"
    val match = Regex("""12(.*)34""").find(s)!!
    println(match.groupValues[1])
    return "Job Done"
}


    // Put Space after Each Capital Letter
    fun putSpaceInCapitalWorld() {
        // Put Space after Each Capital Letter
        var str = "HelloWorld"
        print(str.replace("((?<![0-9])(?<![A-Z])[A-Z](?![A-Z])(?![0-9]))".toRegex()," $1").trim())
    }
/*REGEX Good Example*/
fun goodREGEX() {
    val inputString = "John 9731879"
    val match = Regex("(\\w+) (\\d+)").find(inputString)!!
    val (name, phone) = match.destructured

    println(name) // John     // value of the first group matched by \w+
    println(phone) // 9731879 // value of the second group matched by \d+

// group with the zero index is the whole substring matched by the regular expression
    println(match.groupValues) // [John 9731879, John, 9731879]

    val numberedGroupValues = match.destructured.toList()
// destructured group values only contain values of the groups, excluding the zeroth group.
    println(numberedGroupValues) // [John, 9731879]
}


