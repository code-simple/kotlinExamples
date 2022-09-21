import org.jsoup.Jsoup

class Pesco {}

/*------------------PESCO BILL----------------*/
fun pesco(REF: String): String {
    val link = "https://bill.pitc.com.pk/pescobill/general?refno="
    val url = link + REF
    val doc = Jsoup.connect(url).get()


    /*-------Write to local file for testing--------*/
//    val fileName = "src/main/resources/pesco.html"
//    val myfile = File(fileName)
//    myfile.printWriter().use { out ->
//        out.println(doc)
//    }
    /*--------------------------------------------*/
    // For testing we will load local file
//    val input = File("src/main/resources/pesco.html")
//    val doc = Jsoup.parse(input,"UTF-8")


    /* First Section of Bill*/
    val data1 = doc.select("td.border-b")/*Second Section of Bill*/
    val data2 = doc.select("tr.fontsize")

    /*INFORMATION Gathering*/
    var dueDate = data1[1].text().trim()
    val arrears = data1[12].text().trim()
    val currentBill = data1[13].text().trim()
    val payableWithinDueDate = data1[18].text().trim()
    val payableAfterDate = data1[20].text().trim()
    val lpSurcharge = data1[19].text().trim()
    val unitsConsumed = (data2[10].text().trim()).split(" ")[2]
    val referenceNo = data2[3].text().trim()
    val address_raw = data2[8].text().trim()
    val match_address = Regex("Consumer (.*) Say").find(address_raw)!!
    val address = match_address.groupValues[1]


    return ("""
    Address                : ${address}
    Ref #                  : ${referenceNo}
    Payable Within Due Date: ${payableWithinDueDate}
    Payable After Due Date : ${payableAfterDate}
    LP Surcharge           : ${lpSurcharge}
    Due Date               : ${dueDate}
    Arrears                : ${arrears}
    Units Consumed         : ${unitsConsumed}
    Current Bill           : ${currentBill}
""".trimIndent())
}