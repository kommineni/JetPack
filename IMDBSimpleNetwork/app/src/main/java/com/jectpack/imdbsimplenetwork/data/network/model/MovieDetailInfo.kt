package com.jectpack.imdbsimplenetwork.data.network.model


data class MovieDetailInfo(
    val data: Data,
    val message: String,
    val status: Boolean
)

data class Data(
    val mainSearch: MainSearch
)

data class MainSearch(
    val edges: List<Edge>
)

data class Edge(
    val node: Node
)

data class Node(
    val entity: Entity
)