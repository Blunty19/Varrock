package gg.rsmod.plugins.content.areas.varrock.chat

val iffie = arrayOf(Npcs.IFFIE)

iffie.forEach { iffie ->
    on_npc_option(npc = iffie, option = "talk-to") {
        player.queue { chat(this) }
    }
}

suspend fun chat(it: QueueTask) {
    it.chatNpc("Sorry, dearie, if I stop to chat I'll lose count. Talk to my sister instead; she likes to chat. You'll find her upstairs in the church", animation = -1)
}