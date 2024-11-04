package com.jectpack.imdbmovie.data.network.model

data class ReleaseDate(
    val __typename: String,
    val attributes: List<Attribute>,
    val country: Country,
    val day: Int,
    val displayableProperty: DisplayableProperty,
    val month: Int,
    val restriction: Any,
    val year: Int
)