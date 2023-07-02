package br.com.marvelapp

import android.content.Context
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineCache
import io.flutter.embedding.engine.dart.DartExecutor
import io.flutter.plugin.common.MethodChannel

class FlutterEmbeddingActivity: FlutterActivity() {

    companion object {
        private var cachedFlutterEngine: FlutterEngine? = null

        fun initialiseFlutterEngine(
            context: Context,
            initialRoute: String,
            engineId: String,
            channelId: String
        ): MethodChannel? {
            cachedFlutterEngine = FlutterEngine(context)
            cachedFlutterEngine?.navigationChannel?.setInitialRoute(initialRoute)
            cachedFlutterEngine?.dartExecutor?.executeDartEntrypoint(
                DartExecutor.DartEntrypoint.createDefault()
            )

            FlutterEngineCache
                .getInstance()
                .put(engineId, cachedFlutterEngine)

            return cachedFlutterEngine?.dartExecutor?.let { executor ->
                MethodChannel(
                    executor,
                    channelId
                )
            }
        }

        fun createBuilder(engineId: String): CachedEngineIntentBuilder {
            return withCachedEngine(engineId)
        }
    }
}