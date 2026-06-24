package gay.xujun.whimsy.effect;

import gay.xujun.whimsy.Whimsy;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class RedWedgieEffect extends MobEffect {
    public static final Holder<MobEffect> RED_WEDGIE = Registry.registerForHolder(
            BuiltInRegistries.MOB_EFFECT,
            Whimsy.id("red_wedgie"),
            new RedWedgieEffect()
    );
    public RedWedgieEffect() {
        super(MobEffectCategory.BENEFICIAL, 0xe64a19);
    }
    @Override
    public boolean applyEffectTick(ServerLevel level, LivingEntity entity, int amplifier) {
        return true;
    }
    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return false;
    }
    public static void initialize() {
    }
}