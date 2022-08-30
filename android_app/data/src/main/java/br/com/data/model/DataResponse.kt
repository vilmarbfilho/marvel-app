package br.com.data.model

data class DataResponse<T>(
   val offset: Int,
   val limit: Int,
   val total: Int,
   val count: Int,
   val results: T
)
