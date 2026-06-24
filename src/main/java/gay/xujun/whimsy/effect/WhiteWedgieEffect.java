package gay.xujun.whimsy.effect;

import gay.xujun.whimsy.Whimsy;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class WhiteWedgieEffect extends MobEffect {

    public static final Holder<MobEffect> WHITE_WEDGIE = Registry.registerForHolder(
            BuiltInRegistries.MOB_EFFECT,
            Whimsy.id("white_wedgie"),
            new WhiteWedgieEffect()
    );
    public WhiteWedgieEffect() {
        super(MobEffectCategory.BENEFICIAL, 0xe9b8b3);
        this.addAttributeModifier(
                Attributes.ATTACK_DAMAGE,
                Whimsy.id("effect.white_wedgie.attack_damage"),
                4.0,
                AttributeModifier.Operation.ADD_VALUE
        );
    }
    public static void initialize() {
    }
}