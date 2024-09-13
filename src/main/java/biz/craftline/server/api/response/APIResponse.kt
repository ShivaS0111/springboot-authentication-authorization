package biz.craftline.server.api.response

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class APIResponse<T>(
    val success: Boolean,
    val data: T? = null,
    val message: String? = null,
    val errorCode: Int? = null
) {

    companion object {
        @JvmStatic
        @JvmOverloads
        fun <T> successResponse(data: T, message: String? = null) =
            APIResponse(success = true, data = data, message = message)


        @JvmStatic
        @JvmOverloads
        fun <T> successPaginatedResponse(data: T, message: String? = null) =
            APIResponse(success = true, data = data, message = message)


        @JvmStatic
        @JvmOverloads
        fun errorResponse(errorCode: Int? = null, message: String): APIResponse<Nothing> =
            APIResponse(success = false, message = message, errorCode = errorCode)


        data class Paginated<T : Any>(
            val prev: Int?,
            val next: Int?,
            val totalCount: Int = 0,
            val totalPages: Int = 0,
            val data: List<T>
        )
    }
}