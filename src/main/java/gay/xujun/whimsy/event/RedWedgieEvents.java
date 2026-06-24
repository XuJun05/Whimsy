package gay.xujun.whimsy.event;

import gay.xujun.whimsy.effect.RedWedgieEffect;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;

public class RedWedgieEvents {

    public static void initialize() {

        AttackEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {

            if (!world.isClientSide()
                    && entity instanceof LivingEntity target
                    && player.hasEffect(RedWedgieEffect.RED_WEDGIE)) {

                target.igniteForSeconds(5);
            }

            return InteractionResult.PASS;
        });
    }
}