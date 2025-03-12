// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.5.0" apply false
    id("com.android.library") version "8.5.0" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
    id("org.jetbrains.kotlin.plugin.serialization") version "1.9.0" apply false
}

// Define versions in a single place
extra["composeVersion"] = "2023.10.01"
extra["coreKtxVersion"] = "1.12.0"
extra["lifecycleVersion"] = "2.7.0"
extra["retrofitVersion"] = "2.9.0"
extra["coroutinesVersion"] = "1.7.3"
extra["serializationVersion"] = "1.6.0"
extra["hiltVersion"] = "2.48"