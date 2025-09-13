package com.moaiscoool.item;

import com.moaiscoool.Grilledcheese;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {
    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        // Create the item key.
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Grilledcheese.MOD_ID, name));

        // Create the item instance.
        Item item = itemFactory.apply(settings.registryKey(itemKey));

        // Register the item.
        Registry.register(Registries.ITEM, itemKey, item);

        return item;
    }

    public static final Item GRILLED_CHEESE = register("grilled_cheese", Item::new, new Item.Settings().food(new FoodComponent.Builder()
                    .nutrition(10)
                    .saturationModifier(6F)
            .build()));

    public static final Item CHEESE = register("cheese", Item::new, new Item.Settings().food(new FoodComponent.Builder()
            .nutrition(3)
            .saturationModifier(2F)
            .build()));

    public static void initialize(){
        // Get the event for modifying entries in the ingredients group.
        // And register an event handler that adds our grilled cheese item to the ingredients group.
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK)
                .register((itemGroup) -> itemGroup.add(ModItems.GRILLED_CHEESE));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK)
                .register((itemGroup) -> itemGroup.add(ModItems.CHEESE));
    }
}
