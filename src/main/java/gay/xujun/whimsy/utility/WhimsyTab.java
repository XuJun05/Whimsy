package gay.xujun.whimsy.utility;

import gay.xujun.whimsy.Whimsy;
import gay.xujun.whimsy.block.BlockRegistry;
import gay.xujun.whimsy.item.ItemRegistry;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.*;

public class WhimsyTab {
    public static final ResourceKey<CreativeModeTab> CREATIVE_MODE_TAB_RESOURCE_KEY = ResourceKey.create(
            BuiltInRegistries.CREATIVE_MODE_TAB.key(), Identifier.fromNamespaceAndPath(Whimsy.MOD_ID, "creative_tab")
    );

    public static final CreativeModeTab CREATIVE_MODE_TAB = FabricCreativeModeTab.builder()
            .icon(() -> new ItemStack(ItemRegistry.BLACK_BRIEF))
            .title(Component.translatable("creativeTab.whimsy"))
            .displayItems((parameters, output) -> {
                //アイテム類
                output.accept(ItemRegistry.SAKURA_HELMET);
                output.accept(ItemRegistry.SAKURA_CHESTPLATE);
                output.accept(ItemRegistry.SAKURA_LEGGINGS);
                output.accept(ItemRegistry.SAKURA_BOOTS);
                output.accept(ItemRegistry.WHITE_BRIEF);
                output.accept(ItemRegistry.BLACK_BRIEF);
                output.accept(ItemRegistry.WHITE_FUNDOSHI);
                output.accept(ItemRegistry.RED_FUNDOSHI);
                //ブロック類
                output.accept(BlockRegistry.CONDENSED_DIRT);
                output.accept(ItemRegistry.SAKURA_INGOT);
            })
            .build();
    public static void initialize() {
        Registry.register(
                BuiltInRegistries.CREATIVE_MODE_TAB,
                CREATIVE_MODE_TAB_RESOURCE_KEY,
                CREATIVE_MODE_TAB
        );
    }
}