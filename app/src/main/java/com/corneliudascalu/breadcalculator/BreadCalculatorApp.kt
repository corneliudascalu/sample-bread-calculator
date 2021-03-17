package com.corneliudascalu.breadcalculator

import android.app.Application
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineCache
import io.flutter.embedding.engine.dart.DartExecutor
import io.flutter.plugin.common.MethodChannel

const val FLUTTER_ENGINE_ID = "breadCalculatorEngine"

class BreadCalculatorApp : Application() {
    override fun onCreate() {
        super.onCreate()
        val flutterEngine = FlutterEngine(this)

        // Start executing Dart code in the FlutterEngine.
        flutterEngine.dartExecutor.executeDartEntrypoint(
            DartExecutor.DartEntrypoint.createDefault()
        )

        MethodChannel(
            flutterEngine.dartExecutor.binaryMessenger,
            "bread.corneliudascalu.com/calculate"
        )
            .setMethodCallHandler { call, result ->

                if (call.method == "calculateBread") {
                    val flour = call.argument<String>("flour")

                    result.success("calculated flour: $flour")
                } else {
                    result.notImplemented()
                }
            }

        // Cache the pre-warmed FlutterEngine to be used later by FlutterFragment.
        FlutterEngineCache
            .getInstance()
            .put(FLUTTER_ENGINE_ID, flutterEngine)
    }
}