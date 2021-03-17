package com.corneliudascalu.breadcalculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.corneliudascalu.breadcalculator.databinding.ActivityMainBinding
import io.flutter.embedding.engine.FlutterEngineCache
import io.flutter.plugin.common.MethodChannel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val flutterEngine = FlutterEngineCache.getInstance()[FLUTTER_ENGINE_ID]
        if (flutterEngine != null) {
            MethodChannel(
                flutterEngine.dartExecutor.binaryMessenger,
                "bread.corneliudascalu.com/calculate"
            )
                .setMethodCallHandler { call, result ->

                    if (call.method == "calculateBread") {

                        val flour = call.argument<Int>("flour")
                        val waterRatio = call.argument<Double>("water")
                        val starterRatio = call.argument<Double>("starter")

                        if (flour == null || waterRatio == null || starterRatio == null) {
                            result.error("fail", "Invalid arguments", "")
                        } else {
                            Navigator.navigateToRecipe(
                                supportFragmentManager,
                                DoughChoices(flour, waterRatio.toFloat(), starterRatio.toFloat())
                            )
                            result.success("")
                        }
                    } else {
                        result.notImplemented()
                    }
                }
        }
        val token = User.getToken(this)
        if (token.isEmpty()) {
            supportFragmentManager.commit {
                replace(R.id.container, LoginFragment())
            }
        } else {
            Navigator.navigateToCalculator(supportFragmentManager)
        }
    }
}