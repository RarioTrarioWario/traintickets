// FastMinecarts.kt

package top.godbranch.superExpress

import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.event.Listener
import org.bukkit.event.EventHandler
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.persistence.PersistentDataType
import org.bukkit.entity.Player

class FastMinecarts : JavaPlugin(), Listener {
    override fun onEnable() {
        server.pluginManager.registerEvents(this, this)
    }

    @EventHandler
    fun onPlayerInteract(event: PlayerInteractEvent) {
        val player: Player = event.player
        val item = player.inventory.itemInMainHand

        // Check for ticket type
        if (item.hasItemMeta() && item.itemMeta!!.persistentDataContainer.has(ticketTypeKey, PersistentDataType.STRING)) {
            val ticketType = item.itemMeta!!.persistentDataContainer.get(ticketTypeKey, PersistentDataType.STRING)!!

            // Handle ticket logic based on type
            when (ticketType) {
                "timed" -> handleTimedTicket(player)
                "unlimited" -> handleUnlimitedTicket(player)
            }
        }
    }

    private fun handleTimedTicket(player: Player) {
        // Timed ticket logic: countdown decreases while riding minecart
    }

    private fun handleUnlimitedTicket(player: Player) {
        // Unlimited ticket logic
    }

    companion object {
        val ticketTypeKey = NamespacedKey("superexpress", "ticket_type")
        val ticketSecondsKey = NamespacedKey("superexpress", "ticket_seconds")
        val ticketMultiplierKey = NamespacedKey("superexpress", "ticket_multiplier")
    }
}