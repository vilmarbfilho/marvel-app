package br.com.marvelapp.router

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import br.com.marvelapp.FlutterConstants
import br.com.marvelapp.FlutterEmbeddingActivity
import br.com.marvelapp.characterlist.model.CharacterUi
import io.flutter.embedding.engine.FlutterEngineCache
import org.json.JSONObject

class AppRouter(private val activity: AppCompatActivity) {

    fun openDetail(characterUi: CharacterUi) {
        val context = activity as Context

        var channel = FlutterEmbeddingActivity.initialiseFlutterEngine(
            context,
            FlutterConstants.INITIAL_ROUTE,
            FlutterConstants.ENGINE_ID,
            FlutterConstants.CHANNEL_ID,
        )

        val flutterDataJson = JSONObject()

        flutterDataJson.apply {
            put(FlutterConstants.DATA_CHARACTER_NAME, characterUi.name)
            put(FlutterConstants.DATA_CHARACTER_IMAGE, characterUi.imageUrl)
        }

        // pass data via channel
        channel?.invokeMethod(FlutterConstants.DATA_PASS_METHOD, flutterDataJson.toString())

        if (FlutterEngineCache.getInstance()
                .contains(FlutterConstants.ENGINE_ID)
        ) {
            activity.startActivity(
                FlutterEmbeddingActivity
                    .createBuilder(FlutterConstants.ENGINE_ID)
                    .destroyEngineWithActivity(true)
                    ?.build(context)
            )
        }
    }
}