package gg.rsmod.plugins.content.areas.varrock.chat

val guards = arrayOf(Npcs.GUARD_1147)

guards.forEach { guard ->
    on_npc_option(npc = guard, option = "talk-to") {
        player.queue { chat(this) }
    }
}

suspend fun chat(it: QueueTask) {
    it.chatNpc("Please don't disturb me, I've got to keep an eye out for suspicious individuals.", animation = -1)
}