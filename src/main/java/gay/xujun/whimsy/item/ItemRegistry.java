package gay.xujun.whimsy.item;

import gay.xujun.whimsy.Whimsy;
import gay.xujun.whimsy.material.WhimsyArmorMaterials;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorMaterials;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.Equippable;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.util.function.Function;

public class ItemRegistry {

    private static final Logger LOGGER = LoggerFactory.getLogger(Whimsy.MOD_ID);

    //さくら装備
    public static final Item SAKURA_HELMET = register(
            "sakura_helmet",
            WhimsyArmorItem::new,
            new Item.Properties().humanoidArmor(WhimsyArmorMaterials.SAKURA_ARMOR_INSTANCE, ArmorType.HELMET)
                    .durability(ArmorType.HELMET.getDurability(15))
                    .enchantable(25));
    public static final Item SAKURA_CHESTPLATE = register(
            "sakura_chestplate",
            WhimsyArmorItem::new,
            new Item.Properties().humanoidArmor(WhimsyArmorMaterials.SAKURA_ARMOR_INSTANCE, ArmorType.CHESTPLATE)
                    .durability(ArmorType.CHESTPLATE.getDurability(15))
                    .enchantable(25));
    public static final Item SAKURA_LEGGINGS = register(
            "sakura_leggings",
            WhimsyArmorItem::new,
            new Item.Properties().humanoidArmor(WhimsyArmorMaterials.SAKURA_ARMOR_INSTANCE, ArmorType.LEGGINGS)
                    .durability(ArmorType.LEGGINGS.getDurability(15))
                    .enchantable(25));
    public static final Item SAKURA_BOOTS = register(
            "sakura_boots",
            WhimsyArmorItem::new,
            new Item.Properties().humanoidArmor(WhimsyArmorMaterials.SAKURA_ARMOR_INSTANCE, ArmorType.BOOTS)
                    .durability(ArmorType.BOOTS.getDurability(15))
                    .enchantable(25));
    //ブリーフ
    public static final Item WHITE_BRIEF = register(
            "white_brief",
            WhimsyArmorItem::new,
            new Item.Properties().humanoidArmor(WhimsyArmorMaterials.BRIFE_INSTANCE, ArmorType.LEGGINGS)
                    .durability(ArmorType.LEGGINGS.getDurability(15))
                    .enchantable(25));
    public static final Item BLACK_BRIEF = register(
            "black_brief",
            WhimsyArmorItem::new,
            new Item.Properties().humanoidArmor(WhimsyArmorMaterials.BRIFE_INSTANCE, ArmorType.LEGGINGS)
                    .durability(ArmorType.LEGGINGS.getDurability(15))
                    .enchantable(25));
    //褌 ※六尺褌
    public static final Item WHITE_FUNDOSHI = register(
            "white_fundoshi",
            WhimsyArmorItem::new,
            new Item.Properties().humanoidArmor(WhimsyArmorMaterials.FUNDOSHI_INSTANCE, ArmorType.LEGGINGS)
                    .durability(ArmorType.LEGGINGS.getDurability(15))
                    .enchantable(25));
    public static final Item RED_FUNDOSHI = register(
            "red_fundoshi",
            WhimsyArmorItem::new,
            new Item.Properties().humanoidArmor(WhimsyArmorMaterials.FUNDOSHI_INSTANCE, ArmorType.LEGGINGS)
                    .durability(ArmorType.LEGGINGS.getDurability(15))
                    .enchantable(25));
    //素材とかその他アイテムたち
    public static final Item SAKURA_INGOT = register(
            "sakura_ingot",
            Item::new,
            new Item.Properties());

    public static final Item SAKURA_UPGRADE_SMITHING_TEMPLATE = register(
            "sakura_upgrade_smithing_template",
            Item::new,
            new Item.Properties());

    public static final Item CLOTH = register(
            "cloth",
            Item::new,
            new Item.Properties());

    public static <T extends Item> T register (String name, Function<Item.Properties, T> itemFactory, Item.Properties settings) {
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Whimsy.MOD_ID, name));
        T item = itemFactory.apply(settings.setId(itemKey));
        Registry.register(BuiltInRegistries.ITEM, itemKey, item);
        return item;
    }
    public static void initialize() {
        LOGGER.info("");
    }
}
