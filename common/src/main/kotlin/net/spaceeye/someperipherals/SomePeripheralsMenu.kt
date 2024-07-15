package net.spaceeye.someperipherals

import dev.architectury.registry.menu.MenuRegistry
import dev.architectury.registry.registries.DeferredRegister
import dev.architectury.registry.registries.RegistrySupplier
import net.minecraft.core.registries.Registries
import net.minecraft.world.inventory.AbstractContainerMenu
import net.minecraft.world.inventory.MenuType
import net.spaceeye.someperipherals.stuff.digitizer.DigitizerMenu

object SomePeripheralsMenu {
    private val MENU = DeferredRegister.create(SomePeripherals.MOD_ID, Registries.MENU)

    @JvmField val DIGITIZER_MENU = registerMenuType("digitizer", ::DigitizerMenu)

    private fun <T : AbstractContainerMenu?> registerMenuType(name: String, factory: MenuRegistry.ExtendedMenuTypeFactory<T>): RegistrySupplier<MenuType<T>?> =
        MENU.register(name) { MenuRegistry.ofExtended(factory) }!!

    fun register() {
        MENU.register()
    }
}