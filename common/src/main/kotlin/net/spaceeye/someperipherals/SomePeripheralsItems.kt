package net.spaceeye.someperipherals

import dev.architectury.registry.registries.DeferredRegister
import dev.architectury.registry.registries.RegistrySupplier
import net.minecraft.core.registries.Registries
import net.minecraft.network.chat.Component
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.spaceeye.someperipherals.blocks.SomePeripheralsCommonBlocks
import net.spaceeye.someperipherals.items.goggles.RangeGogglesItem
import net.spaceeye.someperipherals.items.goggles.StatusGogglesItem


object SomePeripheralsItems {
    val ITEMS = DeferredRegister.create(SomePeripherals.MOD_ID, Registries.ITEM)

    //var LOGO: RegistrySupplier<Item> = ITEMS.register("someperipherals_logo") { Item(Item.Properties()) }

    var STATUS_GOGGLES: RegistrySupplier<Item> = ITEMS.register("status_goggles") { StatusGogglesItem() }
    var RANGE_GOGGLES: RegistrySupplier<Item> = ITEMS.register("range_goggles") { RangeGogglesItem() }

    fun register() {
        SomePeripheralsBlocks.registerItems(ITEMS)
        SomePeripheralsCommonBlocks.registerItems(ITEMS)
        ITEMS.register()
        CREATIVE_TAB.register()
    }

    val CREATIVE_TAB = DeferredRegister.create(SomePeripherals.MOD_ID, Registries.CREATIVE_MODE_TAB)

    val TAB: RegistrySupplier<CreativeModeTab> = CREATIVE_TAB.register(SomePeripherals.MOD_ID) {
        CreativeModeTab.builder(CreativeModeTab.Row.TOP, 0)
            .title(Component.translatable("itemGroup.some_peripherals.someperipherals_tab"))
            .displayItems { itemDisplayParameters: CreativeModeTab.ItemDisplayParameters, output: CreativeModeTab.Output ->
                ITEMS.forEach { e ->
                    output.accept(
                        e.get()
                    )
                }
            }
            .icon {
                ItemStack(
                    SomePeripheralsCommonBlocks.RAYCASTER.get()
                )
            }.build()
    }
}