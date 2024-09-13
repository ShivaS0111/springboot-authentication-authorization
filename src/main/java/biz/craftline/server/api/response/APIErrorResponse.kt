package biz.craftline.server.api.response

data class APIErrorResponse(
    val message: String? = null,
    val actualMessage: String? = null,
    val exception:Exception? = null
)