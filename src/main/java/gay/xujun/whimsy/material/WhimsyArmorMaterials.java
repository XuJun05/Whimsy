package gay.xujun.whimsy.material;

import gay.xujun.whimsy.Whimsy;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;

import java.util.Map;

public class WhimsyArmorMaterials {

    public static final int TEST_DURABILITY = 15;

    public static final ResourceKey<EquipmentAsset> TEST_ARMOR_MATERIAL_KEY = ResourceKey.create(
            EquipmentAssets.ROOT_ID,
            Identifier.fromNamespaceAndPath(Whimsy.MOD_ID, "test")
    );

    public static final TagKey<Item> REPAIRS_TEST_ARMOR = TagKey.create(
            BuiltInRegistries.ITEM.key(),
            Identifier.fromNamespaceAndPath(Whimsy.MOD_ID, "repairs_test_armor")
    );
    //テスト用
    public static final ArmorMaterial TEST_INSTANCE = new ArmorMaterial(
            TEST_DURABILITY,
            Map.of(
                    ArmorType.HELMET, 3,
                    ArmorType.CHESTPLATE, 8,
                    ArmorType.LEGGINGS, 6,
                    ArmorType.BOOTS, 3
            ),
            25,
            SoundEvents.ARMOR_EQUIP_IRON,
            0.0F,
            0.0F,
            REPAIRS_TEST_ARMOR,
            TEST_ARMOR_MATERIAL_KEY
    );
    //さくら装備
    public static final int SAKURA_ARMOR_DURABILITY = 15;
    public static final ResourceKey<EquipmentAsset> SAKURA_MATERIAL_KEY = ResourceKey.create(
            EquipmentAssets.ROOT_ID,
            Identifier.fromNamespaceAndPath(Whimsy.MOD_ID, "sakura_armor")
    );
    public static final TagKey<Item> REPAIRS_SAKURA_ARMOR = TagKey.create(
            BuiltInRegistries.ITEM.key(),
            Identifier.fromNamespaceAndPath(Whimsy.MOD_ID, "repaors_sakrua_armor")
    );
    public static final ArmorMaterial SAKURA_ARMOR_INSTANCE = new ArmorMaterial(
            SAKURA_ARMOR_DURABILITY,
            Map.of(
                    ArmorType.HELMET, 6,
                    ArmorType.CHESTPLATE, 18,
                    ArmorType.LEGGINGS, 12,
                    ArmorType.BOOTS, 6
            ),
            25,
            SoundEvents.ARMOR_EQUIP_IRON,
            5.0F,
            0.2F,
            REPAIRS_SAKURA_ARMOR,
            SAKURA_MATERIAL_KEY
    );
    //ブリーフ
    public static final int BRIFE_DURABILITY = 15;
    public static final ResourceKey<EquipmentAsset> BRIEF_MATERIAL_KEY = ResourceKey.create(
            EquipmentAssets.ROOT_ID,
            Identifier.fromNamespaceAndPath(Whimsy.MOD_ID, "brife")
    );
    public static final TagKey<Item> REPAIRS_BRIFE = TagKey.create(
            BuiltInRegistries.ITEM.key(),
            Identifier.fromNamespaceAndPath(Whimsy.MOD_ID, "repairs_brife")
    );
    public static final ArmorMaterial BRIFE_INSTANCE = new ArmorMaterial(
            BRIFE_DURABILITY,
            Map.of(
                    ArmorType.LEGGINGS, 3
            ),
            25,
            SoundEvents.ARMOR_EQUIP_LEATHER,
            0.0F,
            0.0F,
            REPAIRS_BRIFE,
            BRIEF_MATERIAL_KEY
    );
    //ふんどし
    public static final int FUNDOSHI_DURABILITY = 15;
    public static final ResourceKey<EquipmentAsset> FUNDOSHI_MATERIAL_KEY = ResourceKey.create(
            EquipmentAssets.ROOT_ID,
            Identifier.fromNamespaceAndPath(Whimsy.MOD_ID, "fundoshi")
    );
    public static final TagKey<Item> REPAIRS_FUNDOSHI = TagKey.create(
            BuiltInRegistries.ITEM.key(),
            Identifier.fromNamespaceAndPath(Whimsy.MOD_ID, "repairs_fundoshi")
    );
    public static final ArmorMaterial FUNDOSHI_INSTANCE = new ArmorMaterial(
            FUNDOSHI_DURABILITY,
            Map.of(
                    ArmorType.LEGGINGS, 4
            ),
            25,
            SoundEvents.ARMOR_EQUIP_LEATHER,
            0.0F,
            0.0F,
            REPAIRS_FUNDOSHI,
            FUNDOSHI_MATERIAL_KEY
    );
}