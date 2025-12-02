package twentytwentythree.random

fun main() {
    val points = "<point lat=\"46.2587\" lng=\"-124.2444\"/>\n" +
            "<point lat=\"46.2634\" lng=\"-124.0384\"/>\n" +
            "<point lat=\"46.2891\" lng=\"-124.0205\"/>\n" +
            "<point lat=\"46.2407\" lng=\"-123.9368\"/>\n" +
            "<point lat=\"46.2388\" lng=\"-123.8681\"/>\n" +
            "<point lat=\"46.2691\" lng=\"-123.7390\"/>\n" +
            "<point lat=\"46.2520\" lng=\"-123.6868\"/>\n" +
            "<point lat=\"46.2596\" lng=\"-123.6456\"/>\n" +
            "<point lat=\"46.2577\" lng=\"-123.5468\"/>\n" +
            "<point lat=\"46.2672\" lng=\"-123.4863\"/>\n" +
            "<point lat=\"46.2369\" lng=\"-123.4287\"/>\n" +
            "<point lat=\"46.1817\" lng=\"-123.4287\"/>\n" +
            "<point lat=\"46.1513\" lng=\"-123.3765\"/>\n" +
            "<point lat=\"46.1494\" lng=\"-123.3051\"/>\n" +
            "<point lat=\"46.1874\" lng=\"-123.1512\"/>\n" +
            "<point lat=\"46.1380\" lng=\"-123.0222\"/>\n" +
            "<point lat=\"46.0980\" lng=\"-122.9398\"/>\n" +
            "<point lat=\"46.0551\" lng=\"-122.8848\"/>\n" +
            "<point lat=\"45.9588\" lng=\"-122.8189\"/>\n" +
            "<point lat=\"45.9053\" lng=\"-122.8162\"/>\n" +
            "<point lat=\"45.8824\" lng=\"-122.7887\"/>\n" +
            "<point lat=\"45.8173\" lng=\"-122.7969\"/>\n" +
            "<point lat=\"45.7637\" lng=\"-122.7585\"/>\n" +
            "<point lat=\"45.6851\" lng=\"-122.7750\"/>\n" +
            "<point lat=\"45.6505\" lng=\"-122.7530\"/>\n" +
            "<point lat=\"45.6064\" lng=\"-122.5937\"/>\n" +
            "<point lat=\"45.5679\" lng=\"-122.4426\"/>\n" +
            "<point lat=\"45.5756\" lng=\"-122.3712\"/>\n" +
            "<point lat=\"45.5506\" lng=\"-122.3245\"/>\n" +
            "<point lat=\"45.5641\" lng=\"-122.2064\"/>\n" +
            "<point lat=\"45.5987\" lng=\"-122.0856\"/>\n" +
            "<point lat=\"45.6659\" lng=\"-121.8933\"/>\n" +
            "<point lat=\"45.6812\" lng=\"-121.8906\"/>\n" +
            "<point lat=\"45.7081\" lng=\"-121.8164\"/>\n" +
            "<point lat=\"45.6966\" lng=\"-121.7560\"/>\n" +
            "<point lat=\"45.7254\" lng=\"-121.5335\"/>\n" +
            "<point lat=\"45.6928\" lng=\"-121.3907\"/>\n" +
            "<point lat=\"45.7081\" lng=\"-121.3646\"/>\n" +
            "<point lat=\"45.6582\" lng=\"-121.2039\"/>\n" +
            "<point lat=\"45.6083\" lng=\"-121.1957\"/>\n" +
            "<point lat=\"45.6102\" lng=\"-121.1462\"/>\n" +
            "<point lat=\"45.6524\" lng=\"-121.0803\"/>\n" +
            "<point lat=\"45.6582\" lng=\"-121.0144\"/>\n" +
            "<point lat=\"45.6467\" lng=\"-120.9814\"/>\n" +
            "<point lat=\"45.6563\" lng=\"-120.9430\"/>\n" +
            "<point lat=\"45.6371\" lng=\"-120.9100\"/>\n" +
            "<point lat=\"45.6755\" lng=\"-120.8524\"/>\n" +
            "<point lat=\"45.7445\" lng=\"-120.6052\"/>\n" +
            "<point lat=\"45.7158\" lng=\"-120.5310\"/>\n" +
            "<point lat=\"45.6966\" lng=\"-120.4733\"/>\n" +
            "<point lat=\"45.7234\" lng=\"-120.2893\"/>\n" +
            "<point lat=\"45.7234\" lng=\"-120.2124\"/>\n" +
            "<point lat=\"45.7714\" lng=\"-120.1575\"/>\n" +
            "<point lat=\"45.8211\" lng=\"-119.9680\"/>\n" +
            "<point lat=\"45.8498\" lng=\"-119.7839\"/>\n" +
            "<point lat=\"45.8575\" lng=\"-119.6658\"/>\n" +
            "<point lat=\"45.9149\" lng=\"-119.6136\"/>\n" +
            "<point lat=\"45.9244\" lng=\"-119.5724\"/>\n" +
            "<point lat=\"45.9110\" lng=\"-119.5258\"/>\n" +
            "<point lat=\"45.9378\" lng=\"-119.2676\"/>\n" +
            "<point lat=\"45.9168\" lng=\"-119.1687\"/>\n" +
            "<point lat=\"45.9779\" lng=\"-119.0149\"/>\n" +
            "<point lat=\"46.0027\" lng=\"-118.9847\"/>\n" +
            "<point lat=\"45.9970\" lng=\"-116.9165\"/>\n" +
            "<point lat=\"45.9569\" lng=\"-116.8781\"/>\n" +
            "<point lat=\"45.8957\" lng=\"-116.8588\"/>\n" +
            "<point lat=\"45.8747\" lng=\"-116.8066\"/>\n" +
            "<point lat=\"45.8307\" lng=\"-116.7902\"/>\n" +
            "<point lat=\"45.8192\" lng=\"-116.7654\"/>\n" +
            "<point lat=\"45.8231\" lng=\"-116.7105\"/>\n" +
            "<point lat=\"45.7828\" lng=\"-116.6748\"/>\n" +
            "<point lat=\"45.7828\" lng=\"-116.6144\"/>\n" +
            "<point lat=\"45.7522\" lng=\"-116.5430\"/>\n" +
            "<point lat=\"45.6889\" lng=\"-116.5402\"/>\n" +
            "<point lat=\"45.6121\" lng=\"-116.4606\"/>\n" +
            "<point lat=\"45.5006\" lng=\"-116.5567\"/>\n" +
            "<point lat=\"45.4640\" lng=\"-116.5567\"/>\n" +
            "<point lat=\"45.4447\" lng=\"-116.5869\"/>\n" +
            "<point lat=\"45.3213\" lng=\"-116.6721\"/>\n" +
            "<point lat=\"45.2633\" lng=\"-116.6940\"/>\n" +
            "<point lat=\"45.1414\" lng=\"-116.7325\"/>\n" +
            "<point lat=\"45.1065\" lng=\"-116.7764\"/>\n" +
            "<point lat=\"45.0696\" lng=\"-116.7847\"/>\n" +
            "<point lat=\"45.0231\" lng=\"-116.8451\"/>\n" +
            "<point lat=\"44.9765\" lng=\"-116.8616\"/>\n" +
            "<point lat=\"44.9298\" lng=\"-116.8286\"/>\n" +
            "<point lat=\"44.7955\" lng=\"-116.9302\"/>\n" +
            "<point lat=\"44.7487\" lng=\"-117.0346\"/>\n" +
            "<point lat=\"44.5787\" lng=\"-117.1225\"/>\n" +
            "<point lat=\"44.5455\" lng=\"-117.1445\"/>\n" +
            "<point lat=\"44.4847\" lng=\"-117.2076\"/>\n" +
            "<point lat=\"44.4789\" lng=\"-117.2269\"/>\n" +
            "<point lat=\"44.4063\" lng=\"-117.2269\"/>\n" +
            "<point lat=\"44.3926\" lng=\"-117.2488\"/>\n" +
            "<point lat=\"44.3455\" lng=\"-117.1939\"/>\n" +
            "<point lat=\"44.2983\" lng=\"-117.2269\"/>\n" +
            "<point lat=\"44.2570\" lng=\"-117.1774\"/>\n" +
            "<point lat=\"44.2609\" lng=\"-117.1445\"/>\n" +
            "<point lat=\"44.2806\" lng=\"-117.1005\"/>\n" +
            "<point lat=\"44.2314\" lng=\"-117.0511\"/>\n" +
            "<point lat=\"44.2491\" lng=\"-117.0428\"/>\n" +
            "<point lat=\"44.2432\" lng=\"-116.9797\"/>\n" +
            "<point lat=\"44.1940\" lng=\"-116.9742\"/>\n" +
            "<point lat=\"44.1664\" lng=\"-116.8945\"/>\n" +
            "<point lat=\"44.0935\" lng=\"-116.9330\"/>\n" +
            "<point lat=\"44.0836\" lng=\"-116.9714\"/>\n" +
            "<point lat=\"44.0521\" lng=\"-116.9879\"/>\n" +
            "<point lat=\"44.0244\" lng=\"-116.9302\"/>\n" +
            "<point lat=\"43.9533\" lng=\"-116.9659\"/>\n" +
            "<point lat=\"43.8207\" lng=\"-117.0209\"/>\n" +
            "<point lat=\"43.6639\" lng=\"-117.0264\"/>\n" +
            "<point lat=\"42.0024\" lng=\"-117.0264\"/>\n" +
            "<point lat=\"41.9983\" lng=\"-121.2836\"/>\n" +
            "<point lat=\"42.0085\" lng=\"-122.5003\"/>\n" +
            "<point lat=\"42.0064\" lng=\"-123.0798\"/>\n" +
            "<point lat=\"42.0105\" lng=\"-123.1540\"/>\n" +
            "<point lat=\"42.0044\" lng=\"-123.2419\"/>\n" +
            "<point lat=\"42.0024\" lng=\"-123.6209\"/>\n" +
            "<point lat=\"41.9952\" lng=\"-124.3982\"/>\n" +
            "<point lat=\"42.1593\" lng=\"-124.5493\"/>\n" +
            "<point lat=\"42.6521\" lng=\"-124.5877\"/>\n" +
            "<point lat=\"42.8115\" lng=\"-124.7305\"/>\n" +
            "<point lat=\"43.7552\" lng=\"-124.4119\"/>\n" +
            "<point lat=\"46.0065\" lng=\"-124.2554\"/>\n" +
            "<point lat=\"46.2587\" lng=\"-124.2444\"/>"

    print(convertLocationFormat(points))
//    val pointsArray = points.split("], [")
//        .map { it.replace("[", "").replace("]", "") }
//        .map {
//            val latLong = it.split(", ")
//            Pair(latLong[0], latLong[1])
//        }
//
//    val formattedPoints = pointsArray.map { "GoogleLocation(${it.first}f, ${it.second}f)," }
//    formattedPoints.forEach { println(it) }
}

fun convertLocationFormat(input: String): String {
    val points = input.split("/>")
    val output = StringBuilder()

    points.forEach {
        if(it.contains("lat") && it.contains("lng")) {
            val lat = it.substring(it.indexOf("\"") + 1, it.indexOf("\"", it.indexOf("\"") + 1)) + "f"
            val lng = it.substring(it.indexOf("\"", it.indexOf("lng")) + 1, it.indexOf("\"", it.indexOf("\"", it.indexOf("lng")) + 1)) + "f"
            output.append("GoogleLocation($lat, $lng),\n")
        }
    }

    return output.toString()
}