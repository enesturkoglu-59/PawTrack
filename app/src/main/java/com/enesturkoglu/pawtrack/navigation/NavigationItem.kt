package com.enesturkoglu.pawtrack.navigation

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Polymorphic

@Polymorphic
@Serializable
sealed interface Screen


@Serializable
object AddPet : Screen

@Serializable
object Calendar : Screen

@Serializable
object Task : Screen

