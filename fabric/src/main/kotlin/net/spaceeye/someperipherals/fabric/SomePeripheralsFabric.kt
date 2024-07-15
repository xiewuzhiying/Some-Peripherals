package net.spaceeye.someperipherals.fabric

import dan200.computercraft.api.peripheral.PeripheralLookup
import dev.architectury.platform.Platform
import net.fabricmc.api.ClientModInitializer
import net.fabricmc.api.EnvType
import net.fabricmc.api.Environment
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback
import net.minecraft.core.BlockPos
import net.minecraft.core.Direction
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.entity.BlockEntity
import net.minecraft.world.level.block.state.BlockState
import net.spaceeye.someperipherals.SomePeripherals
import net.spaceeye.someperipherals.SomePeripheralsCommands
import net.spaceeye.someperipherals.fabric.integrations.cc.SomePeripheralsPeripheralLookupFabric

class SomePeripheralsFabric: ModInitializer {
    override fun onInitialize() {
        SomePeripherals.init()

        CommandRegistrationCallback.EVENT.register { dispatcher, _ -> SomePeripheralsCommands.registerServerCommands(dispatcher)}
        if (Platform.isModLoaded("computercraft")) {
            PeripheralLookup.get()
                .registerFallback { _: Level?, _: BlockPos?, _: BlockState?, blockEntity: BlockEntity?, _: Direction? ->
                    SomePeripheralsPeripheralLookupFabric.peripheralProvider(blockEntity)
                }
        }
    }
}

@Environment(EnvType.CLIENT)
class SomePeripheralsFabricClient: ClientModInitializer {
    override fun onInitializeClient() {
        SomePeripherals.initClient()
    }
}