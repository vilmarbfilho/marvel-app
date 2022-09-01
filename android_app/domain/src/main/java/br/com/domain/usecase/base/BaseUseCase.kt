package br.com.domain.usecase.base

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.withContext

abstract class BaseUseCase<in Params, out R> {

    private val supervisorJob = SupervisorJob()
    private val scope = CoroutineScope(Dispatchers.Main + supervisorJob)

    protected abstract suspend fun doWork(params: Params): R

    suspend fun execute(params: Params): DataResult<R> {
        return withContext(scope.coroutineContext) {
            try {
                val result = withContext(Dispatchers.IO) { doWork(params) }
                DataResult.Success(result)
            } catch (t: Throwable) {
                DataResult.Failure
            }
        }
    }

    fun cancelWork() = scope.coroutineContext.cancelChildren()
}