package com.ids.fao.custom.player.interfaces

import com.ids.fao.custom.player.interfaces.MediaPlayer

interface VideoViewContract {

    interface Presenter {

        fun deactivate()

        fun getPlayer(): MediaPlayer

        fun play(url: String)

        fun releasePlayer()

        fun setMediaSessionState(isActive: Boolean)
    }

    interface View

}