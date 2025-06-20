package beans

import com.google.gson.annotations.SerializedName
import utils.prettyGson

data class NodeJsonData(
    @SerializedName("entities") val entities: List<Node>?
) {
    companion object {
        val EXAMPLE_STRING: String
            get() = prettyGson.toJson(
                NodeJsonData(
                    listOf(
                        Node(
                            "事物1",
                            YamlClass("类名1", listOf("属性1", "属性2"))
                        ),
                        Node(
                            "事物2",
                            YamlClass("类名2", listOf("属性1", "属性2"))
                        )
                    )
                )
            )
    }
}

data class Node(
    val name: String?,
    @SerializedName("yaml_class") val yamlClass: YamlClass?
)