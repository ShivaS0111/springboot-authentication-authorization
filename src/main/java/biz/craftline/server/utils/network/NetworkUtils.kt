package biz.craftline.server.utils.network

import biz.craftline.server.api.response.APIResponse
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.ok


fun <T> success(data:T): ResponseEntity<APIResponse<T>> {
    return ok(APIResponse.successResponse(data))
}
