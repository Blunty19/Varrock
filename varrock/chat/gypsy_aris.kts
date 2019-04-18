package gg.rsmod.plugins.content.areas.varrock.chat

val gypsy_aris = arrayOf(Npcs.GYPSY_ARIS)

gypsy_aris.forEach { gypsyaris ->
    on_npc_option(npc = gypsyaris, option = "talk-to") {
        player.queue { chat(this) }
    }
}

suspend fun chat(it: QueueTask) {
    it.chatNpc("I'm waiting for Owner to finish my code :(", animation = -1)
}
//TODO finish gypsy aris chat
