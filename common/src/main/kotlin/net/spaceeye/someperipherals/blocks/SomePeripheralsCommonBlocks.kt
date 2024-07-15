package net.spaceeye.someperipherals.blocks

import dev.architectury.registry.registries.DeferredRegister
import net.minecraft.core.registries.Registries
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.Item
import net.spaceeye.someperipherals.SomePeripheralsItems.TAB

import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.state.BlockBehaviour
import net.minecraft.world.level.material.MapColor
import net.spaceeye.someperipherals.SomePeripherals

object SomePeripheralsCommonBlocks {
    private val BLOCKS = DeferredRegister.create(SomePeripherals.MOD_ID, Registries.BLOCK)

    @JvmField var BALLISTIC_ACCELERATOR = BLOCKS.register("ballistic_accelerator") {Block(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).strength(2.0f))}
    @JvmField var RAYCASTER = BLOCKS.register<Block>("raycaster") { RaycasterBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).strength(2.0f)) }
    @JvmField var GOGGLE_LINK_PORT = BLOCKS.register<Block>("goggle_link_port") {GoggleLinkPort(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).strength(2.0f))}
    @JvmField var RADAR = BLOCKS.register("radar") {Block(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).strength(2.0f))}
    @JvmField var DIGITIZER = BLOCKS.register("digitizer") {DigitizerBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).strength(2.0f))}
    @JvmField var WORLD_SCANNER = BLOCKS.register("world_scanner") {Block(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).strength(2.0f))}

    fun registerBaseBlocks() {
        BLOCKS.register()
    }

    fun registerItems(items: DeferredRegister<Item?>) {
        for (block in BLOCKS) {
            items.register(block.id) { BlockItem(block.get(), Item.Properties()) }
        }
    }
}