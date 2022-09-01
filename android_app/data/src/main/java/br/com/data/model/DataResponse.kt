package br.com.data.model

import com.squareup.moshi.Json

data class DataResponse<T>(
   @Json(name = "offset")
   val offset: Int,
   @Json(name = "limit")
   val limit: Int,
   @Json(name = "total")
   val total: Int,
   @Json(name = "count")
   val count: Int,
   @Json(name = "results")
   val results: T
)
