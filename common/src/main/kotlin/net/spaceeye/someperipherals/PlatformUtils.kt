package net.spaceeye.someperipherals

import dan200.computercraft.api.peripheral.IPeripheral
import dev.architectury.injectables.annotations.ExpectPlatform
import net.minecraft.world.inventory.Slot
import net.minecraft.world.level.block.entity.BlockEntity
import net.spaceeye.someperipherals.config.AbstractConfigBuilder
import net.spaceeye.someperipherals.stuff.utils.CommonBlockEntityInventory

object PlatformUtils {
    @ExpectPlatform
    @JvmStatic
    fun getPeripheralProvider(): IPeripheral = throw AssertionError()

    @ExpectPlatform
    @JvmStatic
    fun getConfigBuilder(): AbstractConfigBuilder = throw AssertionError()

    @ExpectPlatform
    @JvmStatic
    fun makeCommonBlockEntityInventory(size: Int): CommonBlockEntityInventory = throw AssertionError()

    @ExpectPlatform
    @JvmStatic
    fun setDigitizerStuff(be: BlockEntity, addSlot: (slot: Slot) -> Slot): Unit = throw AssertionError()
}