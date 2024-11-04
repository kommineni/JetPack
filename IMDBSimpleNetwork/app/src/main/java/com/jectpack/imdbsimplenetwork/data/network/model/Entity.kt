package com.jectpack.imdbsimplenetwork.data.network.model

data class Entity(
    val __typename: String,
    val episodes: Any,
    val id: String,
    val originalTitleText: OriginalTitleText,
    val primaryImage: PrimaryImage,
    val principalCredits: List<PrincipalCredit>,
    val releaseDate: ReleaseDate,
    val releaseYear: ReleaseYear,
    val series: Any,
    val titleText: TitleText,
    val titleType: TitleType
)