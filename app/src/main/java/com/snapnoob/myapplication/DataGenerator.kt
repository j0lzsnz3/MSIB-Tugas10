package com.snapnoob.myapplication

object DataGenerator {
    fun createGalleryData(): List<PhotoCollection> {
        return listOf(
            PhotoCollection(
                date = "13 February 2020",
                imageUrls = getUrlsForFebruary()
            ),
            PhotoCollection(
                date = "9 January 2020",
                imageUrls = getUrlsForJanuary()
            )
        )
    }

    private fun getUrlsForFebruary(): List<String> {
        return listOf(
            "https://media.nomadicmatt.com/preparedtraveler.jpg",
            "https://youmatter.world/app/uploads/sites/2/2019/11/travel-world.jpg",
            "https://thumbor.forbes.com/thumbor/960x0/https%3A%2F%2Fblogs-images.forbes.com%2Fnomanazish%2Ffiles%2F2018%2F01%2Ftravel-1749508_1280-1200x766.jpg"
        )
    }

    private fun getUrlsForJanuary(): List<String> {
        return listOf(
            "https://theplaidzebra.com/wp-content/uploads/2016/11/11-Benefits-to-starting-a-travel-blog-and-traveling-the-world.jpg",
            "https://www.cerebralpalsyguidance.com/wp-content/uploads/2016/05/traveling.jpg",
            "https://www.rentcafe.com/blog/wp-content/uploads/sites/5/2020/04/traveling-change-featured.jpg"
        )
    }
}