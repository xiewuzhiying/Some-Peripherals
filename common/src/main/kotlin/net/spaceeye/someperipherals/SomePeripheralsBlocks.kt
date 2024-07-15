package net.spaceeye.someperipherals

import dev.architectury.registry.registries.DeferredRegister
import net.minecraft.core.registries.Registries
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.Item
import net.spaceeye.someperipherals.blocks.SomePeripheralsCommonBlocks


object SomePeripheralsBlocks {
    private val BLOCKS = DeferredRegister.create(SomePeripherals.MOD_ID, Registries.BLOCK)

    fun register() {
        SomePeripheralsCommonBlocks.registerBaseBlocks()
        BLOCKS.register()
    }

    fun registerItems(items: DeferredRegister<Item>) {
        BLOCKS.forEach {
            items.register(it.id) { BlockItem(it.get(), Item.Properties()) }
        }
    }
}