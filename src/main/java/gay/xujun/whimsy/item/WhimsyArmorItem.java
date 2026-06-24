package gay.xujun.whimsy.item;

import com.geckolib.animatable.GeoItem;
import com.geckolib.animatable.client.GeoRenderProvider;
import com.geckolib.animatable.instance.AnimatableInstanceCache;
import com.geckolib.animatable.manager.AnimatableManager;
import com.geckolib.renderer.GeoArmorRenderer;
import com.geckolib.util.GeckoLibUtil;
import com.google.common.base.Suppliers;
import gay.xujun.whimsy.Whimsy;
import gay.xujun.whimsy.effect.RedWedgieEffect; // 追加
import gay.xujun.whimsy.effect.WhiteWedgieEffect;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier; // 追加
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance; // 追加
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity; // 追加
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeModifier; // 追加
import net.minecraft.world.entity.ai.attributes.Attributes; // 追加
import net.minecraft.world.entity.player.Player; // 追加
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class WhimsyArmorItem extends Item implements GeoItem {

    private final AnimatableInstanceCache geoCache = GeckoLibUtil.createInstanceCache(this);

    public WhimsyArmorItem(Properties properties) {
        super(properties);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.geoCache;
    }

    @Override
    public void inventoryTick(ItemStack stack, ServerLevel level, Entity entity, EquipmentSlot slot) {
        if (entity instanceof Player player) {

            // ─────────────────────────────────────────────────
            // 🩲 おぱんちゅ（LEGS）の処理
            // ─────────────────────────────────────────────────
            if (slot == EquipmentSlot.LEGS) {
                // 1. 赤ふんどし
                if (stack.is(ItemRegistry.RED_FUNDOSHI)) {
                    MobEffectInstance currentEffect = player.getEffect(RedWedgieEffect.RED_WEDGIE);
                    if (currentEffect == null || currentEffect.getDuration() <= 80) {
                        player.addEffect(new MobEffectInstance(RedWedgieEffect.RED_WEDGIE, 240, 0, true, true, true));
                    }
                }
                // 2. 純白の六尺褌
                else if (stack.is(ItemRegistry.WHITE_FUNDOSHI)) {
                    MobEffectInstance currentEffect = player.getEffect(WhiteWedgieEffect.WHITE_WEDGIE);
                    if (currentEffect == null || currentEffect.getDuration() <= 80) {
                        player.addEffect(new MobEffectInstance(WhiteWedgieEffect.WHITE_WEDGIE, 240, 0, true, true, true));
                    }
                }
                // 3. 黒ブリーフ
                else if (stack.is(ItemRegistry.BLACK_BRIEF)) {
                    MobEffectInstance currentEffect = player.getEffect(MobEffects.SPEED);
                    if (currentEffect == null || currentEffect.getDuration() <= 80) {
                        player.addEffect(new MobEffectInstance(MobEffects.SPEED, 240, 0, true, true, true));
                    }
                }
                // 4. 白ブリーフ
                else if (stack.is(ItemRegistry.WHITE_BRIEF)) {
                    MobEffectInstance currentEffect = player.getEffect(MobEffects.SPEED);
                    if (currentEffect == null || currentEffect.getDuration() <= 80) {
                        player.addEffect(new MobEffectInstance(MobEffects.SPEED, 240, 0, true, true, true));
                    }
                }
            }
            //さくら装備れうい
            boolean hasFullSakura =
                    player.getItemBySlot(EquipmentSlot.HEAD).is(ItemRegistry.SAKURA_HELMET) &&
                            player.getItemBySlot(EquipmentSlot.CHEST).is(ItemRegistry.SAKURA_CHESTPLATE) &&
                            player.getItemBySlot(EquipmentSlot.LEGS).is(ItemRegistry.SAKURA_LEGGINGS) &&
                            player.getItemBySlot(EquipmentSlot.FEET).is(ItemRegistry.SAKURA_BOOTS);

            var stepAttr = player.getAttribute(Attributes.STEP_HEIGHT);
            if (stepAttr != null) {
                var modifierId = Identifier.fromNamespaceAndPath(Whimsy.MOD_ID, "sakura_step_bonus");
                if (hasFullSakura && slot == EquipmentSlot.HEAD) {
                    if (!stepAttr.hasModifier(modifierId)) {
                        stepAttr.addOrUpdateTransientModifier(new AttributeModifier(
                                modifierId, 0.4, AttributeModifier.Operation.ADD_VALUE
                        ));
                    }
                }
                else if (!hasFullSakura) {
                    if (stepAttr.hasModifier(modifierId)) {
                        stepAttr.removeModifier(modifierId);
                    }
                }
            }
            if (hasFullSakura && slot == EquipmentSlot.HEAD) {
                MobEffectInstance speedEffect = player.getEffect(MobEffects.SPEED);
                if (speedEffect == null || speedEffect.getDuration() <= 80) {
                    player.addEffect(new MobEffectInstance(MobEffects.SPEED, 240, 1, true, true, true));
                }
            }
        }
        super.inventoryTick(stack, level, entity, slot);
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, net.minecraft.world.item.component.TooltipDisplay displayComponent, java.util.function.Consumer<net.minecraft.network.chat.Component> textConsumer, net.minecraft.world.item.TooltipFlag type) {

        //赤褌
        if (stack.is(ItemRegistry.RED_FUNDOSHI)) {
            textConsumer.accept(Component.translatable("tooltip.whimsy.red_fundoshi.line1")
                    .withStyle(ChatFormatting.RED));
            textConsumer.accept(Component.translatable("tooltip.whimsy.red_fundoshi.line2")
                    .withStyle(ChatFormatting.GRAY));
        }
        //白褌
        if (stack.is(ItemRegistry.WHITE_FUNDOSHI)) {
            textConsumer.accept(Component.translatable("tooltip.whimsy.white_fundoshi.line1")
                    .withStyle(ChatFormatting.AQUA));
            textConsumer.accept(Component.translatable("tooltip.whimsy.white_fundoshi.line2")
                    .withStyle(ChatFormatting.GRAY));
        }
        //黒ブリーフ
        if (stack.is(ItemRegistry.BLACK_BRIEF)) {
            textConsumer.accept(Component.translatable("tooltip.whimsy.black_brief.line1")
                    .withStyle(ChatFormatting.LIGHT_PURPLE));
            textConsumer.accept(Component.translatable("tooltip.whimsy.black_brief.line2")
                    .withStyle(ChatFormatting.GRAY));
        }
        //白ブリーフ
        if (stack.is(ItemRegistry.WHITE_BRIEF)) {
            textConsumer.accept(Component.translatable("tooltip.whimsy.white_brief.line1")
                    .withStyle(ChatFormatting.YELLOW));
            textConsumer.accept(Component.translatable("tooltip.whimsy.white_brief.line2")
                    .withStyle(ChatFormatting.GRAY));
        }
        super.appendHoverText(stack, context, displayComponent, textConsumer, type);
    }

    @Override
    public void createGeoRenderer(Consumer<GeoRenderProvider> consumer) {
        consumer.accept(new GeoRenderProvider() {
            private final Supplier<GeoArmorRenderer<?, ?>> renderer =
                    Suppliers.memoize(() -> new WhimsyArmorRenderer(WhimsyArmorItem.this));
            @Override
            public @Nullable GeoArmorRenderer<?, ?> getGeoArmorRenderer(ItemStack itemStack, EquipmentSlot equipmentSlot) {
                return this.renderer.get();
            }
        });
    }

    private static class WhimsyArmorRenderer extends GeoArmorRenderer<WhimsyArmorItem, net.minecraft.client.renderer.entity.state.HumanoidRenderState> {
        public WhimsyArmorRenderer(WhimsyArmorItem item) {
            super(item);
        }

        @Override
        public List<ArmorSegment> getSegmentsForSlot(net.minecraft.client.renderer.entity.state.HumanoidRenderState state, EquipmentSlot slot) {
            if (slot == EquipmentSlot.LEGS) {
                return List.of(
                        ArmorSegment.LEFT_LEG,
                        ArmorSegment.RIGHT_LEG,
                        ArmorSegment.CHEST
                );
            }
            return super.getSegmentsForSlot(state, slot);
        }
    }
}