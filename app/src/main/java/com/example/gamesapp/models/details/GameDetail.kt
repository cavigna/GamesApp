package com.example.gamesapp.models.details


import com.google.gson.annotations.SerializedName

data class GameDetail(
    @SerializedName("achievements_count")
    var achievementsCount: Int = 0,
    @SerializedName("added")
    var added: Int = 0,
    @SerializedName("added_by_status")
    var addedByStatus: AddedByStatus = AddedByStatus(),
    @SerializedName("additions_count")
    var additionsCount: Int = 0,
    @SerializedName("alternative_names")
    var alternativeNames: List<Any> = listOf(),
    @SerializedName("background_image")
    var backgroundImage: String = "",
    @SerializedName("background_image_additional")
    var backgroundImageAdditional: String = "",
    @SerializedName("clip")
    var clip: Any = Any(),
    @SerializedName("creators_count")
    var creatorsCount: Int = 0,
    @SerializedName("description")
    var description: String = "",
    @SerializedName("description_raw")
    var descriptionRaw: String = "",
    @SerializedName("developers")

    var developers: List<DeveloperDetail> =
        listOf(DeveloperDetail(0, 0 , "", "", "")),

    @SerializedName("dominant_color")
    var dominantColor: String = "",
    @SerializedName("esrb_rating")
    var esrbRating: Any = Any(),
    @SerializedName("game_series_count")
    var gameSeriesCount: Int = 0,
    @SerializedName("genres")
    var genres: List<Genre> = listOf(),
    @SerializedName("id")
    var id: Int = 0,
//    @SerializedName("metacritic")
//    var metacritic: Int = 0,

    @SerializedName("metacritic")
    var metacritic: Any = Any(),

    @SerializedName("metacritic_platforms")
    var metacriticPlatforms: List<Any> = listOf(),
    @SerializedName("metacritic_url")
    var metacriticUrl: String = "",
    @SerializedName("movies_count")
    var moviesCount: Int = 0,
    @SerializedName("name")
    var name: String = "",
    @SerializedName("name_original")
    var nameOriginal: String = "",
    @SerializedName("parent_achievements_count")
    var parentAchievementsCount: Int = 0,
    @SerializedName("parent_platforms")
    var parentPlatforms: List<ParentPlatform> = listOf(),
    @SerializedName("parents_count")
    var parentsCount: Int = 0,
    @SerializedName("platforms")
    var platforms: List<PlatformX> = listOf(),
    @SerializedName("playtime")
    var playtime: Int = 0,
    @SerializedName("publishers")
    var publishers: List<Publisher> = listOf(),
    @SerializedName("rating")
    var rating: Double = 0.0,
    @SerializedName("rating_top")
    var ratingTop: Int = 0,
    @SerializedName("ratings")
    var ratings: List<Rating> = listOf(),
    @SerializedName("ratings_count")
    var ratingsCount: Int = 0,
    @SerializedName("reactions")
    var reactions: Reactions = Reactions(),
    @SerializedName("reddit_count")
    var redditCount: Int = 0,
    @SerializedName("reddit_description")
    var redditDescription: String = "",
    @SerializedName("reddit_logo")
    var redditLogo: String = "",
    @SerializedName("reddit_name")
    var redditName: String = "",
    @SerializedName("reddit_url")
    var redditUrl: String = "",
    @SerializedName("released")
    var released: Any = Any(),
    @SerializedName("reviews_count")
    var reviewsCount: Int = 0,
    @SerializedName("reviews_text_count")
    var reviewsTextCount: Int = 0,
    @SerializedName("saturated_color")
    var saturatedColor: String = "",
    @SerializedName("screenshots_count")
    var screenshotsCount: Int = 0,
    @SerializedName("slug")
    var slug: String = "",
    @SerializedName("stores")
    var stores: List<Store> = listOf(),
    @SerializedName("suggestions_count")
    var suggestionsCount: Int = 0,
    @SerializedName("tags")
    var tags: List<Tag> = listOf(),
    @SerializedName("tba")
    var tba: Boolean = false,
    @SerializedName("twitch_count")
    var twitchCount: Int = 0,
    @SerializedName("updated")
    var updated: String = "",
    @SerializedName("user_game")
    var userGame: Any = Any(),
    @SerializedName("website")
    var website: String = "",
    @SerializedName("youtube_count")
    var youtubeCount: Int = 0
)