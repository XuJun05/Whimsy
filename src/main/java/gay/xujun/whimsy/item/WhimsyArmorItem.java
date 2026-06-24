package gay.xujun.whimsy.item;

import com.geckolib.animatable.GeoItem;
import com.geckolib.animatable.client.GeoRenderProvider;
import com.geckolib.animatable.instance.AnimatableInstanceCache;
import com.geckolib.animatable.manager.AnimatableManager;
import com.geckolib.renderer.GeoArmorRenderer;
import com.geckolib.util.GeckoLibUtil;
import com.google.common.base.Suppliers;
import net.minecraft.world.entity.EquipmentSlot;
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