package uz.beko404.sharedelementtransaction.utill

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.NavOptions
import androidx.navigation.Navigator

fun NavController.navigateSafe(@IdRes resId: Int,
                               args: Bundle?,
                               navOptions: NavOptions?,
                               navigatorExtras: Navigator.Extras?) {
    val destinationId = currentDestination?.getAction(resId)?.destinationId.orEmpty()
    currentDestination?.let { node ->
        val currentNode = when (node) {
            is NavGraph -> node
            else -> node.parent
        }
        if (destinationId != 0) {
            currentNode?.findNode(destinationId)?.let { navigate(resId, args, navOptions, navigatorExtras) }
        }
    }
}

fun Int?.orEmpty(default: Int = 0): Int {
    return this ?: default
}