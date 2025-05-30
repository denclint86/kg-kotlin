import beans.NodeJsonData
import beans.RelationJsonData

fun getNodePrompt(context: String, classes: String, data: String): String = "" +
        "TASK: 你现在处于知识图谱抽取工具链的一环, 你需要根据数据抽取出知识图谱专用的节点的定义, 请确保你的回答是标准的 JSON" +
        "请根据以下文本和上下文主题, 抽取其中的节点实体, 并以 JSON 格式返回结果\n" +
        "类定义(抽取的节点必须是给定的类的实例, 其中的一些属性可空, 但类定义必须是已经给定的):\n" +
        "$classes\n" +
        "上下文主题(你应该只获取与主题相关的实体):\n" +
        context +
        "\n\n" +
        "返回格式示例:\n" +
        NodeJsonData.EXAMPLE_STRING +
        "\n\n" +
        "为了节省 token, 你可以输出不格式化的 json\n" +
        "待处理文本:\n" +
        data

fun getRelationPrompt(givenNodes: String, context: String, data: String): String = "" +
        "TASK: 你现在处于知识图谱抽取工具链的一环, 你需要根据数据抽取出知识图谱专用的三元关系组, 请确保你的回答是标准的 JSON" +
        "请根据以下文本和上下文主题, 抽取其中的三元关系组, 并以 JSON 格式返回结果\n" +
        "给定节点(请仅用给定节点来作为主体, 如果有近义词, 使用给定节点取代):\n" +
        givenNodes +
        "\n\n" +
        "上下文主题(你应该只获取与主题相关的三元关系组):\n" +
        context +
        "\n\n" +
        "注意:\n" +
        "1. 关系(第二个元素)必须能够明确表示主宾关系, 并且尽可能简单且不带有任何形容性质的词语, 就像缩句一样简洁;\n" +
        "2. 整个关系组必须符合中文习惯, 例如使用主动句;\n" +
        "3. 确保关系组是三元的\n" +
        "4. 确保关系组是有意义, 对知识图谱构建有帮助的内容, 否则不要添加" +
        "\n\n" +
        "返回格式示例:\n" +
        RelationJsonData.EXAMPLE_STRING +
        "\n\n" +
        "为了节省 token, 你可以输出不格式化的 json\n" +
        "待处理文本:\n" +
        data