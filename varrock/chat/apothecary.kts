package gg.rsmod.plugins.content.areas.varrock.chat

arrayOf(Npcs.APOTHECARY).forEach { apothecary ->
    on_npc_option(npc = apothecary, option = "talk-to") {
        player.queue { dialog(this) }
    }

    on_npc_option(npc = apothecary, option = "Potions") {
        player.queue { dialog(this) }
    }

}

suspend fun dialog(it: QueueTask) {
    it.chatNpc("Sorry but i'm currently under development", animation = -1)

}

//todo finish Apothecary