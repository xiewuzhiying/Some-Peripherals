package net.spaceeye.someperipherals.blockentities

import dev.architectury.registry.registries.DeferredRegister
import dev.architectury.registry.registries.RegistrySupplier
import net.minecraft.Util
import net.minecraft.core.BlockPos
import net.minecraft.core.Registry
import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.util.datafix.fixes.References
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.entity.BlockEntity
import net.minecraft.world.level.block.entity.BlockEntityType
import net.minecraft.world.level.block.state.BlockState
import net.spaceeye.someperipherals.SomePeripherals
import net.spaceeye.someperipherals.blocks.SomePeripheralsCommonBlocks


object CommonBlockEntities {
    private val BLOCKENTITIES = DeferredRegister.create(SomePeripherals.MOD_ID, Registries.BLOCK_ENTITY_TYPE)

    var RAYCASTER = SomePeripheralsCommonBlocks.RAYCASTER makePair ::RaycasterBlockEntity byName "raycaster"
    var GOOGLE_LINK_PORT = SomePeripheralsCommonBlocks.GOGGLE_LINK_PORT makePair ::GoggleLinkPortBlockEntity byName "goggle_link_port"
    var DIGITIZER = SomePeripheralsCommonBlocks.DIGITIZER makePair ::DigitizerBlockEntity byName "digitizer"

    private infix fun <T: BlockEntity, TT: Block> RegistrySupplier<TT>.makePair(blockEntity: (BlockPos, BlockState) -> T) = Pair(this, { bp: BlockPos, bs: BlockState -> blockEntity(bp, bs)})
    private infix fun <T: BlockEntity, TT: Block> Pair<RegistrySupplier<TT>, (BlockPos, BlockState) -> T>.byName(name: String): RegistrySupplier<BlockEntityType<T>> =
        BLOCKENTITIES.register(name) {
            val type = Util.fetchChoiceType(References.BLOCK_ENTITY, name)

            BlockEntityType.Builder.of(
                this.second,
                this.first.get()
            ).build(type)
        }

    fun registerBlockEntities() {
        BLOCKENTITIES.register()
    }
}