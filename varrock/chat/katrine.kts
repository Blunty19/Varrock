package gg.rsmod.plugins.content.areas.varrock.chat

val iffie = arrayOf(Npcs.KATRINE)

iffie.forEach { katrine ->
    on_npc_option(npc = katrine, option = "talk-to") {
        player.queue { chat(this) }
    }
}

suspend fun chat(it: QueueTask) {
    it.chatNpc("Sorry, but im currently under devlopment", animation = -1)
    //todo katrine dialogue
}