plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("kotlin-kapt")
}

android {
    namespace = "com.example.phrasetranslator"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.phrasetranslator"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
        freeCompilerArgs = listOf(
            "-Xopt-in=kotlin.RequiresOptIn",
            "-Xsuppress=EXPERIMENTAL_API_USAGE",
            "-Xsuppress=EXPERIMENTAL_MATERIAL3_API",
            "-Xsuppress=EXPERIMENTAL_API_USAGE_ERROR",
            "-Xsuppress=EXPERIMENTAL_MATERIAL_API",
            "-Xsuppress=EXPERIMENTAL_UNSIGNED_LITERALS",
            "-Xsuppress=EXPERIMENTAL_OVERRIDE",
            "-Xsuppress=EXPERIMENTAL_FEATURE_WARNING",
            "-Xsuppress=EXPERIMENTAL_IS_NOT_ENABLED",
            "-Xsuppress=EXPERIMENTAL_KOTLIN_MODULE",
            "-Xsuppress=EXPERIMENTAL_MULTI_PLATFORM",
            "-Xsuppress=EXPERIMENTAL_API_USAGE_ERROR",
            "-Xsuppress=EXPERIMENTAL_EXTENSION_PROPERTY",
            "-Xsuppress=EXPERIMENTAL_BUILDER_INFERENCE",
            "-Xsuppress=EXPERIMENTAL_FUN_INTERFACE",
            "-Xsuppress=EXPERIMENTAL_CONTRACT",
            "-Xsuppress=EXPERIMENTAL_COROUTINES_API",
            "-Xsuppress=EXPERIMENTAL_RANGE_API",
            "-Xsuppress=EXPERIMENTAL_IO_API",
            "-Xsuppress=EXPERIMENTAL_ANNOTATION_CLASS",
            "-Xsuppress=EXPERIMENTAL_ASSOCIATED_OBJECT",
            "-Xsuppress=EXPERIMENTAL_REQUIRES_OPT_IN",
            "-Xsuppress=EXPERIMENTAL_USE_PROPERTY_ACCESSOR",
            "-Xsuppress=EXPERIMENTAL_TYPE_INFERENCE",
            "-Xsuppress=EXPERIMENTAL_COLLECTIONS_API",
            "-Xsuppress=EXPERIMENTAL_DECLARATIONS",
            "-Xsuppress=EXPERIMENTAL_API_USAGE_ERROR",
            "-Xsuppress=EXPERIMENTAL_UNSIGNED_TYPES",
            "-Xsuppress=EXPERIMENTAL_DATA_CLASS",
            "-Xsuppress=EXPERIMENTAL_OBJECT_LITERAL",
            "-Xsuppress=EXPERIMENTAL_ARRAY_API",
            "-Xsuppress=EXPERIMENTAL_TEXT_API",
            "-Xsuppress=EXPERIMENTAL_WASM_API",
            "-Xsuppress=EXPERIMENTAL_JS_EXPORT",
            "-Xsuppress=EXPERIMENTAL_JS_IR",
            "-Xsuppress=EXPERIMENTAL_JS_MODULE",
            "-Xsuppress=EXPERIMENTAL_JS_NAME",
            "-Xsuppress=EXPERIMENTAL_JS_EXTERNAL",
            "-Xsuppress=EXPERIMENTAL_JS_INLINE",
            "-Xsuppress=EXPERIMENTAL_JS_ANNOTATIONS",
            "-Xsuppress=EXPERIMENTAL_JS_FUN",
            "-Xsuppress=EXPERIMENTAL_JS_CLASS",
            "-Xsuppress=EXPERIMENTAL_JS_INTERFACE",
            "-Xsuppress=EXPERIMENTAL_JS_OBJECT",
            "-Xsuppress=EXPERIMENTAL_JS_ENUM",
            "-Xsuppress=EXPERIMENTAL_JS_PROPERTY",
            "-Xsuppress=EXPERIMENTAL_JS_FUNCTION",
            "-Xsuppress=EXPERIMENTAL_JS_CONSTRUCTOR",
            "-Xsuppress=EXPERIMENTAL_JS_GETTER",
            "-Xsuppress=EXPERIMENTAL_JS_SETTER",
            "-Xsuppress=EXPERIMENTAL_JS_OVERRIDE",
            "-Xsuppress=EXPERIMENTAL_JS_DEFAULT",
            "-Xsuppress=EXPERIMENTAL_JS_OPTIONAL",
            "-Xsuppress=EXPERIMENTAL_JS_VARARG",
            "-Xsuppress=EXPERIMENTAL_JS_NULLABLE",
            "-Xsuppress=EXPERIMENTAL_JS_EXTERNAL_CLASS",
            "-Xsuppress=EXPERIMENTAL_JS_EXTERNAL_INTERFACE",
            "-Xsuppress=EXPERIMENTAL_JS_EXTERNAL_OBJECT",
            "-Xsuppress=EXPERIMENTAL_JS_EXTERNAL_ENUM",
            "-Xsuppress=EXPERIMENTAL_JS_EXTERNAL_PROPERTY",
            "-Xsuppress=EXPERIMENTAL_JS_EXTERNAL_FUNCTION",
            "-Xsuppress=EXPERIMENTAL_JS_EXTERNAL_CONSTRUCTOR",
            "-Xsuppress=EXPERIMENTAL_JS_EXTERNAL_GETTER",
            "-Xsuppress=EXPERIMENTAL_JS_EXTERNAL_SETTER",
            "-Xsuppress=EXPERIMENTAL_JS_EXTERNAL_OVERRIDE",
            "-Xsuppress=EXPERIMENTAL_JS_EXTERNAL_DEFAULT",
            "-Xsuppress=EXPERIMENTAL_JS_EXTERNAL_OPTIONAL",
            "-Xsuppress=EXPERIMENTAL_JS_EXTERNAL_VARARG",
            "-Xsuppress=EXPERIMENTAL_JS_EXTERNAL_NULLABLE",
            "-Xsuppress=EXPERIMENTAL_JS_EXTERNAL_ANNOTATIONS",
            "-Xsuppress=EXPERIMENTAL_JS_EXTERNAL_INLINE",
            "-Xsuppress=EXPERIMENTAL_JS_EXTERNAL_MODULE",
            "-Xsuppress=EXPERIMENTAL_JS_EXTERNAL_NAME",
            "-Xsuppress=EXPERIMENTAL_JS_EXTERNAL_FUN",
            "-Xsuppress=EXPERIMENTAL_JS_EXTERNAL_CLASS_ANNOTATIONS",
            "-Xsuppress=EXPERIMENTAL_JS_EXTERNAL_INTERFACE_ANNOTATIONS",
            "-Xsuppress=EXPERIMENTAL_JS_EXTERNAL_OBJECT_ANNOTATIONS",
            "-Xsuppress=EXPERIMENTAL_JS_EXTERNAL_ENUM_ANNOTATIONS",
            "-Xsuppress=EXPERIMENTAL_JS_EXTERNAL_PROPERTY_ANNOTATIONS",
            "-Xsuppress=EXPERIMENTAL_JS_EXTERNAL_FUNCTION_ANNOTATIONS",
            "-Xsuppress=EXPERIMENTAL_JS_EXTERNAL_CONSTRUCTOR_ANNOTATIONS",
            "-Xsuppress=EXPERIMENTAL_JS_EXTERNAL_GETTER_ANNOTATIONS",
            "-Xsuppress=EXPERIMENTAL_JS_EXTERNAL_SETTER_ANNOTATIONS",
            "-Xsuppress=EXPERIMENTAL_JS_EXTERNAL_OVERRIDE_ANNOTATIONS",
            "-Xsuppress=EXPERIMENTAL_JS_EXTERNAL_DEFAULT_ANNOTATIONS",
            "-Xsuppress=EXPERIMENTAL_JS_EXTERNAL_OPTIONAL_ANNOTATIONS",
            "-Xsuppress=EXPERIMENTAL_JS_EXTERNAL_VARARG_ANNOTATIONS",
            "-Xsuppress=EXPERIMENTAL_JS_EXTERNAL_NULLABLE_ANNOTATIONS",
            "-Xsuppress=EXPERIMENTAL_JS_EXTERNAL_INLINE_ANNOTATIONS",
            "-Xsuppress=EXPERIMENTAL_JS_EXTERNAL_MODULE_ANNOTATIONS",
            "-Xsuppress=EXPERIMENTAL_JS_EXTERNAL_NAME_ANNOTATIONS",
            "-Xsuppress=EXPERIMENTAL_JS_EXTERNAL_FUN_ANNOTATIONS"
        )
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation("androidx.activity:activity-compose:1.8.0")
    implementation(platform("androidx.compose:compose-bom:2023.06.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3:1.2.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.06.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    // Retrofit and Gson
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.1")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation("androidx.room:room-runtime:2.6.1")
    kapt("androidx.room:room-compiler:2.6.1")
    implementation("androidx.room:room-ktx:2.6.1") // Для корутин
}

// Retrofit and Gson