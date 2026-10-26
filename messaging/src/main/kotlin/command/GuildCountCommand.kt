package com.shakster.borgar.messaging.command

import com.shakster.borgar.core.util.asSingletonList
import com.shakster.borgar.messaging.BOT_MANAGERS
import com.shakster.borgar.messaging.event.CommandEvent

object GuildCountCommand : NonChainableCommand() {

    override val name: String = "servercount"
    override val aliases: Set<String> = setOf("servers")
    override val description: String = "Gets the number of servers that this bot is in."
    override suspend fun run(arguments: CommandArguments, event: CommandEvent): List<CommandResponse> {
        val guildCount = BOT_MANAGERS.sumOf {
            it.getGuildCount()
        }
        val servers = if (guildCount == 1) "server" else "servers"
        return CommandResponse("This bot is in $guildCount $servers.").asSingletonList()
    }
}
